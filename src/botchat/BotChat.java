package botchat;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/bot")
public class BotChat {

	@OnMessage
	public void echo(String message, Session session) {
		Response res = new Response();
		if (message.equals(Constant.PING)) {
			res.text = Constant.PONG;
		} else {
			res.text = message;
		}
		res.success = Constant.SUCCESS;
		res.type = Constant.MESSAGE;
		session.getOpenSessions().forEach(s -> {
			try {
				s.getBasicRemote().sendText(res.toJson());
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		});
	}
}
