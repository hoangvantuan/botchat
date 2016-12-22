package botchat;

public class Response {

	private String type = "";
	private String text = "";
	private boolean success = true;;
	private String command = "";

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Response() {
	}

	public String toJson() {

		StringBuffer str = new StringBuffer();
		str.append("{\"type\":").append("\"" + type + "\"").append(",\"text\":").append("\"" + text + "\"")
				.append(",\"success\":").append("\"" + success + "\"}");
		return str.toString();
	}

}
