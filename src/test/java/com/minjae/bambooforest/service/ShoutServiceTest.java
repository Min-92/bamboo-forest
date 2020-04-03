package com.minjae.bambooforest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.minjae.bambooforest.domain.Shout;
import com.minjae.bambooforest.domain.repository.ShoutRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShoutServiceTest {

	@Mock
	private ShoutRepository shoutRepository;

	@InjectMocks
	private ShoutService shoutService;

	@Test
	public void save() {
		// given
		Shout shout = new Shout("안녕하세요");
		when(shoutRepository.save(shout)).thenReturn(shout);

		// when
		Shout savedShout = shoutService.save(shout);

		// then
		assertEquals(shout.getContent(), savedShout.getContent());
	}

	@Test
	public void loadAll() {
		// given
		List<Shout> shouts = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			shouts.add(new Shout("테스트" + i));
		}
		Iterable<Shout> shoutIterable = shouts;

		when(shoutRepository.findAll()).thenReturn(shoutIterable);

		// when
		List<Shout> loadedShouts = shoutService.loadAll();

		// then
		for (int i = 0; i < 5; i++) {
			assertEquals(shouts.get(i), loadedShouts.get(i));
		}
	}

}
