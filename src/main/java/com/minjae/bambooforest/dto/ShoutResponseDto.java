package com.minjae.bambooforest.dto;

import com.minjae.bambooforest.domain.Shout;
import java.time.LocalDateTime;

public class ShoutResponseDto {

	private String id;
	private String content;
	private LocalDateTime createdDateTime;
	private int xPosition;
	private int yPosition;
	private int fontIndex;

	public ShoutResponseDto(Shout shout) {
		this.content = shout.getContent();
		this.id = shout.getId();
		this.createdDateTime = shout.getCreatedDateTime();
		this.xPosition = shout.getXPosition();
		this.yPosition = shout.getYPosition();
		this.fontIndex = shout.getFontIndex();
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

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getFontIndex() {
		return fontIndex;
	}

	public void setFontIndex(int fontIndex) {
		this.fontIndex = fontIndex;
	}
}
