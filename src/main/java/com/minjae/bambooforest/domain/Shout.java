package com.minjae.bambooforest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shout {
	@Id
	@GeneratedValue
	private Long id;
	private String content;
	private String color;
	private String font;
	private int xPosition;
	private int yPosition;
	private int size;
	private int rotate;

	public Shout(String content){
		this.content = content;
	}

	public void generate(){
		color = "red";
		font = "goolim";
		//size는 길이에 따라서
		//color는 제외해도 될듯
		//rotate는 45 넘지 않도록
		//position은 글자가 밖으로 나가지 않도록
		//todo
	}
}
