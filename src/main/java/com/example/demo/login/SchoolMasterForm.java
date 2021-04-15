package com.example.demo.login;

import lombok.Data;

@Data
public class SchoolMasterForm {
	private Integer schoolId;
	private String schoolName;
	private String schoolNameKana;
	private String zipcode;
	private String address;
}
