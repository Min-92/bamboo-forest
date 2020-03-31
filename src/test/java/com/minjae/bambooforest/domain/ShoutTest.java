package com.minjae.bambooforest.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ShoutTest {

	private int TEST_NUMBER = 100;

	@Test
	public void generate() {
		// given
		Shout shout = new Shout("안녕하세요");

		// when
		shout.generate((min, max) -> TEST_NUMBER);

		// then
		assertEquals("안녕하세요", shout.getContent());
		assertEquals(TEST_NUMBER, shout.getXPosition());
		assertEquals(TEST_NUMBER, shout.getYPosition());
		assertEquals(TEST_NUMBER, shout.getFontIndex());
		assertNotNull(shout.getCreatedDateTime());
	}
}
