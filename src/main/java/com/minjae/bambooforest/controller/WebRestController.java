package com.minjae.bambooforest.controller;

import com.minjae.bambooforest.domain.Shout;
import com.minjae.bambooforest.dto.ShoutRequestDto;
import com.minjae.bambooforest.dto.ShoutResponseDto;
import com.minjae.bambooforest.service.ShoutService;
import java.util.List;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

	private ShoutService shoutService;

	public WebRestController(ShoutService shoutService) {
		this.shoutService = shoutService;
	}

	@MessageMapping("/shouts")
	@SendTo("/topic/shouts")
	public ShoutResponseDto shout(ShoutRequestDto requestDto) {
		Shout shout = shoutService.save(requestDto);
		return new ShoutResponseDto(shout);
	}

	@GetMapping("/shouts")
	public List<ShoutResponseDto> getShouts() {
		return shoutService.load();
	}
}
