package botchat;

public class Response {

	public String type;
	public String text;
	public boolean success;

	public Response() {
	}

	public String toJson() {

		StringBuffer str = new StringBuffer();
		str.append("{\"type\":").append("\"" + type + "\"").append(",\"text\":").append("\"" + text + "\"")
				.append(",\"success\":").append("\"" + success + "\"}");
		return str.toString();
	}

}
