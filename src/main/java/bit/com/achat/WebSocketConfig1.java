package bit.com.achat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker //@EnableWebSocketMessageBroker is used to enable our WebSocket server
public class WebSocketConfig1 implements WebSocketMessageBrokerConfigurer {
	
	
	
	/*
	 1. WebSocket end-point 및 message broker 를 구성하는것이다.
	 
	 @Configuration = 이 어노테이션은 해당 클래스가 Bean 설정을 할것이다라는 것 나타냄
	 @EnableWebSocketMessageBroker = WebSocket 서버를 활성화하는 데 사용됩니다.
	
	Spring frameworkd는 WebSocket 메시지를 처리하는 Client, 
	Server 측 application을 작성하는데
	사용할 수 있는 WebSocket API를 제공하고 있습니다.
	
	*/
	
	  @Override
	    public void registerStompEndpoints(StompEndpointRegistry registry) {
		  registry.addEndpoint("/ws")
            .setAllowedOrigins("http://localhost:8085")
            .withSockJS();
		  System.out.println("contect ws");
	        //registry.addEndpoint("/ws"); // 그냥 websocket 지원
	    }


	    @Override
	    public void configureMessageBroker(MessageBrokerRegistry registry) {
	        registry.setApplicationDestinationPrefixes("/app");
	        registry.enableSimpleBroker("/topic");
	        System.out.println("configureMessageBroker app topic");
	    }
	
}
