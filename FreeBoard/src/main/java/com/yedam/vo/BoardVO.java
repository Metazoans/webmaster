package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data	//getter,setter,tostring등 기본 기능 전부 생성
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String writerName;
	private int viewCnt;
	private Date writeDate;
	private Date updateDate;
}
