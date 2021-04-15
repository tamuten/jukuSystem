package com.example.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class StudentForm {
	private String id;
	@NotEmpty
	@Length(max = 60)
	private String name;
	@NotNull
	private int grade;
}
