package tutorial.websocket.servlet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WebSocketMessageInboundPool {
	// 保存连接的MAP容器
	private static final Map<String, WebSocketMessageInbound> connections = new HashMap<String, WebSocketMessageInbound>();

	// 向连接池中添加连接
	public static void addMessageInbound(WebSocketMessageInbound inbound) {
		// 添加连接
		System.out.println("user : " + inbound.getUser() + " join..");
		connections.put(inbound.getUser(), inbound);
	}
	/**
	 * 获取所有用户
	 * @return
	 */
	public static Set<String> getOnlineUser() {
		return connections.keySet();
	}
	/**
	 * 移除连接
	 * @param inbound
	 */
	public static void removeMessageInbound(WebSocketMessageInbound inbound) {
		System.out.println("user:" + inbound.getUser() + " exit...");
		connections.remove(inbound.getUser());
	}
	
    public static void sendMessageToUser(String user,String message){  
    	
    	
    }
	
	
}
