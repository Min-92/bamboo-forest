package com.minjae.bambooforest.dto;

import com.minjae.bambooforest.domain.Shout;
import java.time.LocalDateTime;

public class ShoutResponseDto {

	private String id;
	private String content;
	private LocalDateTime createdDateTime;
	private int xPosition;

	public ShoutResponseDto(Shout shout) {
		this.content = shout.getContent();
		this.id = shout.getId();
		this.createdDateTime = shout.getCreatedDateTime();
		this.xPosition = shout.getXPosition();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public int getXPosition() {
		return xPosition;
	}

	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}
}
