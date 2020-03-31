package com.minjae.bambooforest.domain;

import com.minjae.bambooforest.domain.strategy.GenerateStrategy;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "shout", timeToLive = 60)
public class Shout {

	@Id
	private String id;
	private String content;
	private LocalDateTime createdDateTime;
	private int xPosition;
	private int yPosition;
	private int fontIndex;
	private int MAX_OF_POSITION = 100;
	private int MIN_OF_POSITION = 0;
	private int MAX_OF_FONT_INDEX = 6;
	private int MIN_OF_FONT_INDEX = 0;


	public Shout(String content) {
		this.content = content;
	}

	public void generate(GenerateStrategy generateStrategy) {
		createdDateTime = LocalDateTime.now();
		xPosition = generateStrategy.getIntInRange(MIN_OF_POSITION, MAX_OF_POSITION);
		yPosition = generateStrategy.getIntInRange(MIN_OF_POSITION, MAX_OF_POSITION);
		fontIndex = generateStrategy.getIntInRange(MIN_OF_FONT_INDEX, MAX_OF_FONT_INDEX);
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public int getFontIndex() {
		return fontIndex;
	}
}
