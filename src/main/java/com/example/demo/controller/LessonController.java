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
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.LessonService;
import com.example.demo.form.LessonForm;
import com.example.demo.object.Lesson;

@Controller
public class LessonController {
	@Autowired
	private LessonService service;

	@GetMapping("/lesson")
	public String index(@ModelAttribute LessonForm form) {
		return "lesson";
	}

	@PostMapping("/lesson/register")
	public String register(@ModelAttribute @Validated LessonForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "lesson";
		}
		Lesson lesson = new Lesson();
		BeanUtils.copyProperties(form, lesson);
		lesson.setId(service.getNextId());
		service.insertOne(lesson);

		BeanUtils.copyProperties(lesson, form);
		model.addAttribute("message", "登録が完了しました。");
		return "lesson";
	}

	@GetMapping("/lesson/list")
	public String getList(Model model) {
		List<Lesson> lessonList = service.selectMany();
		model.addAttribute("lessonList", lessonList);
		return "lessonList";
	}

}
