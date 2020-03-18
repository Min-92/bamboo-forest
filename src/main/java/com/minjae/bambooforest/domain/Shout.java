package com.minjae.bambooforest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "shout", timeToLive = 180)
public class Shout {

	@Id
	private String id;
	private String content;

	public Shout(String content) {
		this.content = content;
	}

	public void generate() {
		//todo 포지션,사이즈 생성
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
