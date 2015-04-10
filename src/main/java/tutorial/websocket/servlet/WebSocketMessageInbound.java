package tutorial.websocket.servlet;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import net.sf.json.JSONObject;

import org.apache.catalina.websocket.MessageInbound;

public class WebSocketMessageInbound extends MessageInbound{
	//当前连接的用户名称  
    private final String user;  
	
	public WebSocketMessageInbound(String user) {
		this.user = user;
	}
	public String getUser(){
		return user;
	}
	
	@Override
	protected void onBinaryMessage(ByteBuffer message) throws IOException {
		JSONObject result = new JSONObject();
		result.element("type", "user_join");
		result.element("user", this.user);
		WebSocketMessageInboundP
		
	}

	@Override
	protected void onTextMessage(CharBuffer message) throws IOException {
		
	}

}
