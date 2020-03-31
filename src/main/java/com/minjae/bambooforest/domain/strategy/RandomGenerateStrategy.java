package com.minjae.bambooforest.domain.strategy;

public class RandomGenerateStrategy implements GenerateStrategy {

	public int getIntInRange(int min, int max) {
		return (int) (Math.random() * ((max - min) + 1)) + min;
	}
}
