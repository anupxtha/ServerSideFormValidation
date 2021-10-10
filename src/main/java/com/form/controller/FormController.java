package com.form.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.form.entities.UserData;

@Controller
public class FormController {

	@GetMapping("/")
	public String login(Model model) {
		
		model.addAttribute("userData", new UserData() );
		
		return "form";
	}
	
	
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("userData") UserData data, BindingResult result){
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		
		System.out.println(data);
		
		return "success";
	}
	
}
