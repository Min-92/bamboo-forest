package com.minjae.bambooforest.dto;

import com.minjae.bambooforest.domain.Shout;

public class ShoutRequestDto {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Shout toEntity(){
		return new Shout(content);
	}
}
