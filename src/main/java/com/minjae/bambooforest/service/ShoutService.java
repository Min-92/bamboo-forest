package com.minjae.bambooforest.service;

import com.minjae.bambooforest.domain.Shout;
import com.minjae.bambooforest.domain.repository.ShoutRepository;
import com.minjae.bambooforest.domain.strategy.RandomGenerateStrategy;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoutService {

	private ShoutRepository shoutRepository;

	public ShoutService(ShoutRepository shoutRepository) {
		this.shoutRepository = shoutRepository;
	}

	@Transactional
	public Shout save(Shout shout) {
		shout.generate(new RandomGenerateStrategy());
		return shoutRepository.save(shout);
	}

	@Transactional(readOnly = true)
	public List<Shout> loadAll() {
		List<Shout> shouts = StreamSupport.stream(shoutRepository.findAll().spliterator(), false)
			.filter(Objects::nonNull)
			.collect(Collectors.toList());

		return shouts;
	}
}
