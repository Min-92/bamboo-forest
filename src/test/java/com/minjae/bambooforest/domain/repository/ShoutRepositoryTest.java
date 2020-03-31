package com.minjae.bambooforest.domain.repository;

import static org.junit.Assert.assertEquals;

import com.minjae.bambooforest.domain.Shout;
import com.minjae.bambooforest.domain.strategy.RandomGenerateStrategy;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoutRepositoryTest {

	@Autowired
	ShoutRepository shoutRepository;

	private Shout shout;

	@Before
	public void generateShout() {
		shout = new Shout("안녕하세요.");
		shout.generate(new RandomGenerateStrategy());
	}

	@Test
	public void saveShout() {
		// when
		Shout savedShout = shoutRepository.save(shout);

		// then
		String id = savedShout.getId();
		assert (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id));
	}

	@Test
	public void loadShout() {
		// given
		Shout savedShout = shoutRepository.save(shout);
		String id = savedShout.getId();

		// then
		Optional<Shout> optionalShout = shoutRepository.findById(id);
		Shout loadedShout = optionalShout.get();

		// when
		assertEquals(loadedShout.getId(), shout.getId());
		assertEquals(loadedShout.getContent(), shout.getContent());
		assertEquals(loadedShout.getCreatedDateTime(), shout.getCreatedDateTime());
		assertEquals(loadedShout.getXPosition(), shout.getXPosition());
		assertEquals(loadedShout.getYPosition(), shout.getYPosition());
		assertEquals(loadedShout.getCreatedDateTime(), shout.getCreatedDateTime());
	}
}
