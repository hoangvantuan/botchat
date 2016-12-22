package botchat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/bot")
public class BotChat {

	private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void open(Session session) {
		System.out.println("client connect " + session.getId());
		sessions.add(session);
	}

	@OnMessage
	public void message(String message, Session session) {
		Response res = Helpers.getResponse(message);
		this.broadcast(res);

	}

	@OnClose
	public void close(Session session) {
		sessions.remove(session);
	}

	@OnError
	public void error(Session session, Throwable e) {
		Response res = new Response();
		res.setSuccess(Constant.FAILL);
		res.setText(e.getMessage());
		res.setType(Constant.ERROR);
		this.broadcast(res);

	}

	public void broadcast(Response res) {
		sessions.forEach(s -> {
			s.getAsyncRemote().sendText(res.toJson());
		});
	}
}
