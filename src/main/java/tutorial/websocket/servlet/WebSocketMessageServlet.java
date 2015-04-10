package tutorial.websocket.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

@WebServlet(urlPatterns = "/message")
public class WebSocketMessageServlet extends WebSocketServlet {

	public static int ONLINE_USER_COUNT = 1;

	public String getUser(HttpServletRequest req) {
		return (String) req.getSession().getAttribute("user");
	}

	@Override
	// 跟平常Servlet不同的是，需要实现createWebSocketInbound，在这里初始化自定义的WebSocket连接对象
	protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest req) {
		return new WebSocketMessageInbound(this.getUser(req));
	}

}
