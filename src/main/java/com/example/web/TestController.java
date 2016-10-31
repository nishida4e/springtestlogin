package com.example.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.domain.FoodPrice;
import com.example.service.FoodPriceService;
import com.example.service.LoginUserDetails;
import com.example.service.UserServiceTest;

@Controller
@RequestMapping("menu")
public class TestController {

	@Autowired
	FoodPriceService foodService;
	
	@GetMapping
	String init(Model model) {
		List<FoodPrice> foodList = foodService.findAll();
		model.addAttribute("foodModel", foodList);
		return "menulist";
	}

	@PostMapping(path = "reg")
	String reg(FoodPriceForm form) {
		form = new FoodPriceForm();
		return "reg";
	}

	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, FoodPriceForm form) {
		FoodPrice fp = foodService.findOne(id);
		BeanUtils.copyProperties(fp, form);
		return "reg";
	}

	@PostMapping(path = "create")
	String create(Integer id, @Validated FoodPriceForm form, BindingResult result,
            @AuthenticationPrincipal LoginUserDetails userDetails) {

		if (result.hasErrors()) {
			return "reg";
		}

		FoodPrice fp = new FoodPrice();
		BeanUtils.copyProperties(form, fp);
		fp.setId(id);
		foodService.create(fp, userDetails.getUser());
		return "redirect:/menu";
	}

	@PostMapping(path = "delete")
	String delete(@RequestParam Integer id) {
		foodService.delete(id);
		return "redirect:/menu";
	}

	@PostMapping(path = "back")
	String back() {
		return "redirect:/menu";
	}
	
	/*
	@Autowired
	UserServiceTest userService;
	
	@PostMapping(path = "test")
	String test() {
		userService.delete("koko1");
		return "redirect:/menu";
	}
	*/

}
