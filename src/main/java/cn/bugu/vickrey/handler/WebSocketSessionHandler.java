package cn.bugu.vickrey.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * 消息处理类
 *
 */
public class WebSocketSessionHandler implements WebSocketHandler{
	
	//静态变量，用来记录当前连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
	
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static CopyOnWriteArraySet<WebSocketSession> webSocketSet = new CopyOnWriteArraySet<WebSocketSession>();
	
	//用户进入系统监听
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketSet.add(session);  //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前连接数为" + getOnlineCount());
	}

	//
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
	    //将消息进行转化，因为是消息是json数据，可能里面包含了发送给某个人的信息，所以需要用json相关的工具类处理之后再封装成TextMessage，
	    //我这儿并没有做处理，消息的封装格式一般有{from:xxxx,to:xxxxx,msg:xxxxx}，来自哪里，发送给谁，什么消息等等	    
		System.out.println("来自客户端的消息:" + message.getPayload().toString());
		TextMessage msg = new TextMessage(message.getPayload().toString());

		//TextMessage msg = (TextMessage)message.getPayload();
		//给所有用户群发消息
	    sendMessagesToUsers(msg);
	    //给指定用户群发消息
	    //sendMessageToUser(userId,msg);  
	}
        
    //后台错误信息处理方法
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		exception.printStackTrace();
	}

	//用户退出后的处理，不如退出之后，要将用户信息从websocket的session中remove掉，这样用户就处于离线状态了，也不会占用系统资源
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		if(session.isOpen()){
			session.close();
		}
		webSocketSet.remove(session);  //从set中删除
		subOnlineCount();              //在线数减1
        System.out.println("有一连接关闭！当前连接数为" + getOnlineCount());
		
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
	
	/**
	 * 给所有的用户发送消息
	 */
	public void sendMessagesToUsers(TextMessage message){
		for(WebSocketSession session : webSocketSet){
			try {
			    //isOpen()在线就发送
				if(session.isOpen()){
					session.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 发送消息给指定的用户
	 */
	public void sendMessageToUser(String userId,TextMessage message){
		for(WebSocketSession session : webSocketSet){
			if(session.getAttributes().get("userid").equals(userId)){
				try {
				    //isOpen()在线就发送
					if(session.isOpen()){
						session.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
    	WebSocketSessionHandler.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
    	WebSocketSessionHandler.onlineCount--;
    }
}
