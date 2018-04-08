package cn.bugu.vickrey.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.bugu.vickrey.handler.WebSocketSessionHandler;

import cn.bugu.vickrey.interceptor.WebSocketHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketHandlerConfigurer implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(getHandler(), "/websocket").addInterceptors(new WebSocketHandshakeInterceptor())
				.setAllowedOrigins("*");
		registry.addHandler(getHandler(), "/socketjs").addInterceptors(new WebSocketHandshakeInterceptor())
				.setAllowedOrigins("*").withSockJS();
	}

	@Bean
	public WebSocketHandler getHandler() {
		return new WebSocketSessionHandler();
	}

}