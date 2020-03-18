package com.minjae.bambooforest.service;

import com.minjae.bambooforest.domain.Shout;
import com.minjae.bambooforest.domain.repository.ShoutRepository;
import com.minjae.bambooforest.dto.ShoutRequestDto;
import com.minjae.bambooforest.dto.ShoutResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoutService {

	private ShoutRepository shoutRepository;

	public ShoutService(ShoutRepository shoutRepository) {
		this.shoutRepository = shoutRepository;
	}

	@Transactional
	public Shout save(ShoutRequestDto dto) {
		Shout shout = dto.toEntity();
		shout.generate();
		return shoutRepository.save(shout);
	}

	@Transactional(readOnly = true)
	public List<ShoutResponseDto> load() {
		List<ShoutResponseDto> result = new ArrayList();

		shoutRepository.findAll().forEach(shout -> {
			result.add(new ShoutResponseDto(shout));
		});

		return result;
	}
}
