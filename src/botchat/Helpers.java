package botchat;

public class Helpers {

	public static Response getResponse(String message) {
		message = message.trim();
		Response res = new Response();
		res = Helpers.getType(message, res);
		res = Helpers.getText(message, res);
		return res;
	}

	public static Response getType(String message, Response res) {
		if (Constant.BOT1.equals(message) || Constant.BOT2.equals(message) || Constant.BOT3.equals(message)) {
			res.setType(Constant.BOT);
			res.setCommand(Constant.HELP);
		} else if (message.startsWith(Constant.BOT1) && message.charAt(3) == ' ') {
			res.setType(Constant.BOT);
			res.setCommand(message.substring(4));
		} else if (message.startsWith(Constant.BOT2) && message.charAt(4) == ' ') {
			res.setType(Constant.BOT);
			res.setCommand(message.substring(5));
		} else if (message.startsWith(Constant.BOT3)) {
			res.setType(Constant.BOT);
			res.setCommand(message.substring(4));
		} else
			res.setType(Constant.MESSAGE);
		return res;
	}

	public static Response getText(String message, Response res) {

		if (res.getType().equals(Constant.BOT)) {
			if (Constant.PING.equals(res.getCommand().trim())) {
				res.setText(Constant.PONG);
			} else {
				res.setText(res.getCommand());
			}

		} else {
			if (Constant.PING.equals(message)) {
				res.setText(Constant.PONG);
			} else {
				res.setText(message);
			}
		}
		return res;
	}
}
