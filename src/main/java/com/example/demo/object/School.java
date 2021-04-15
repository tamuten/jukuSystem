package com.example.demo.object;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class School {
	private Integer schoolId;
	private String schoolName;
	private String schoolNameKana;
	private String schoolAbbreviatedName;
	private String address;
	private String zipcode;
	private String manager;
	private boolean deleteFlg;
	private Timestamp updateTime;

}
