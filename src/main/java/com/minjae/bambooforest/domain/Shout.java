package com.minjae.bambooforest.domain;

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


	public Shout(String content) {
		this.content = content;
	}

	public void generate() {
		createdDateTime = LocalDateTime.now();
		xPosition = (int) (Math.random() * 100);
		yPosition = (int) (Math.random() * 100);
		fontIndex = (int) (Math.random() * 6);
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
