package View;

import java.util.EventObject;

public class SendHexFileEvent extends EventObject {
	
	private String content;
	
	public SendHexFileEvent(Object source,String content){
		super(source);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
