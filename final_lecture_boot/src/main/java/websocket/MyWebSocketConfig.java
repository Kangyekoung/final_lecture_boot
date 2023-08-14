package websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

@Configuration //설정관련 클래스
@RequiredArgsConstructor //lombot 사용시 추가(생성자 멤버변수 포함)
@EnableWebSocket
public class MyWebSocketConfig implements WebSocketConfigurer{
	//@Autowired
	final ChatWebSocketHandler handler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//다른 서버, 포트에서 접속 하도록 허용 setAllowedOrigins("*")
		registry.addHandler(handler, "/chatws").setAllowedOrigins("*");//"ws://localhost:8080/chatws" 호출되면 웹소켓을 실행	
	}
}
