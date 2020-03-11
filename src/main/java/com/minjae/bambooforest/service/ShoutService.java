package com.minjae.bambooforest.service;

import com.minjae.bambooforest.domain.Shout;
import com.minjae.bambooforest.dto.ShoutRequestDto;
import com.minjae.bambooforest.dto.ShoutResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ShoutService {
	public ShoutResponseDto save(ShoutRequestDto dto){
		Shout shout = dto.toEntity();
		shout.generate();

		// todo : db에 데이터 save, responseDto return;

		return new ShoutResponseDto();
	}
}
