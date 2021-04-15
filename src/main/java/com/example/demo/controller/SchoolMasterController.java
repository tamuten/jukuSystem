package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.SchoolMasterService;
import com.example.demo.login.SchoolMasterForm;
import com.example.demo.object.School;

@Controller
public class SchoolMasterController {

	@Autowired
	private SchoolMasterService storeService;

	@RequestMapping("/index")
	public String index(@ModelAttribute SchoolMasterForm form) {
		return "storeDetail";
	}

	@RequestMapping("/")
	private String index(Model model) {
		System.out.println("StoreController#show called.");

		model.addAttribute("name", "kenji tajima");
		model.addAttribute("lang", "java");
		model.addAttribute("framework", "spring framework");

		return "index";
	}

	@RequestMapping(value = "/storeDetail", name = "update")
	public String register(@ModelAttribute @Validated SchoolMasterForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "storeDetail";
		}

		School school = new School();
		BeanUtils.copyProperties(form, school);
		storeService.register(school);

		System.out.println("更新に成功");
		return "storeDetail";
	}

	@RequestMapping("schoolList")
	public String getAllSchools(Model model) {
		model.addAttribute("page", storeService.getAllSchools());
		return "schoolList";
	}

}
