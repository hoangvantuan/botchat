package botchat;

import java.util.Random;

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
			res.setCommand(message.substring(4).trim());
		} else if (message.startsWith(Constant.BOT2) && message.charAt(4) == ' ') {
			res.setType(Constant.BOT);
			res.setCommand(message.substring(5).trim());
		} else if (message.startsWith(Constant.BOT3)) {
			res.setType(Constant.BOT);
			res.setCommand(message.substring(4).trim());
		} else
			res.setType(Constant.MESSAGE);
		return res;
	}

	public static Response getText(String message, Response res) {

		if (res.getType().equals(Constant.BOT)) {
			if (Constant.PING.equals(res.getCommand().trim())) {
				res.setText(Constant.PONG);
			} else if (Helpers.isTalk(res)) {
				res.setText(Helpers.getTalk(res));
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

	public static boolean isTalk(Response res) {
		if (Constant.TALK.equals(res.getCommand()))
			return true;
		else if (res.getCommand().startsWith(Constant.TALK) && res.getCommand().charAt(4) == ' ') {
			return true;
		} else {
			return false;
		}
	}

	public static String getTalk(Response res) {

		if (Constant.TALK.equals(res.getCommand())) {
			return Constant.SAYANYTHING;
		} else {
			Random rand = new Random();
			int n = rand.nextInt(Constant.talk.length - 1);
			return Constant.talk[n];
		}
	}
}
