package botchat;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/bot")
public class BotChat {

	@OnMessage
	public void echo(String message, Session session) {
		 String str = session.getId().toString();

		session.getOpenSessions().forEach(s -> s.getAsyncRemote().sendText(str));
	}
}
