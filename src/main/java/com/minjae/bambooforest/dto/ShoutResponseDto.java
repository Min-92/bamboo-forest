package com.minjae.bambooforest.dto;

import com.minjae.bambooforest.domain.Shout;

public class ShoutResponseDto {

	private String content;

	//todo : 좌표, 시간 등 필요한 정보 추가
	public ShoutResponseDto(Shout shout) {
		this.content = shout.getContent();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
