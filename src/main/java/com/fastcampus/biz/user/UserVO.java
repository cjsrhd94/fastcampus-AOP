package com.fastcampus.biz.user;

import lombok.Data;

import java.util.Date;

// VO Å¬·¡½º
@Data
public class UserVO {
	private String id;
	private String password;
	private String name;
	private Date regDate;
	private String role; 
}
