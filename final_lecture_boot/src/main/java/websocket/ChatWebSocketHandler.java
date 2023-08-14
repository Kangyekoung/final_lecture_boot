package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ChatWebSocketHandler implements WebSocketHandler {

	//채팅클라이언트 모아놓은 리스트
	List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//웹소켓 연결시 1번 실행
		//연결 클라이언트 list로 관리
		list.add(session);
		System.out.println("클라이언트수=" + list.size() + " - " + "session ip: " + session.getRemoteAddress() + "에서 접속");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// 연결 도중 여러번 실행
		//1. 1개 클라이언트 메시지 수신
		String msg = (String)message.getPayload(); //클라이언트가 서버에 보낸 메시지
		System.out.println("서버 : " + msg);
		//2. 접속 모든 클라이언트 메시지 송신 //클라이언트에게 메세지 전할려면 WebSocketMessage타입으로 전달해야함
		for(WebSocketSession socket : list) {
			WebSocketMessage<String> sendmsg = new TextMessage(msg); //string msg -> WebsocketMessage 타입으로 변경
			socket.sendMessage(sendmsg);
		}
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// 웹소켓 연결해제시 1번 실행
		list.remove(session);
		System.out.println("session ip: " + session.getRemoteAddress() + "에서 접속해제");
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		//오류처리. 사용x
		
	}

	
	@Override
	public boolean supportsPartialMessages() {
		// 부가정보 생성
		return false;
	}
	
}
