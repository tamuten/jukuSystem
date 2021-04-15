package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.StudentService;
import com.example.demo.form.StudentForm;
import com.example.demo.object.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/student")
	public String index(@ModelAttribute StudentForm form) {
		return "student";
	}

	@PostMapping("/student/register")
	public String register(@ModelAttribute @Validated StudentForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "student";
		}
		Student student = new Student();
		BeanUtils.copyProperties(form, student);
		studentService.register(student);

		model.addAttribute("message", "登録が完了しました。");
		return "student";
	}

	@GetMapping("/student/edit/{id:.+}")
	public String edit(@ModelAttribute StudentForm form, Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Student student = studentService.selectOne(id);
			BeanUtils.copyProperties(student, form);
		}

		return "student";
	}

	@GetMapping("/student/list")
	public String list(Model model) {
		List<Student> studentList = studentService.selectMany();
		model.addAttribute("studentList", studentList);
		return "studentList";
	}

}
