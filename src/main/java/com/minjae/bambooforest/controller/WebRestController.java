package com.minjae.bambooforest.controller;

import com.minjae.bambooforest.dto.ShoutRequestDto;
import com.minjae.bambooforest.dto.ShoutResponseDto;
import com.minjae.bambooforest.service.ShoutService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
	private ShoutService shoutService;

	public WebRestController(ShoutService shoutService){
		this.shoutService = shoutService;
	}

	@MessageMapping("/shouts")
	@SendTo("/topic/shouts")
	public ShoutResponseDto shout(ShoutRequestDto dto){
		/**
		 * todo : db에 shout 저장 후 해당 데이터 리턴
		 * todo : @DestinationVariable 사용해서 채널 분리 참고 : https://stackoverflow.com/questions/27047310/path-variables-in-spring-websockets-sendto-mapping
		 */
		return  shoutService.save(dto);
	}
}
