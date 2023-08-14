package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController2 {

	@RequestMapping("/ajaxstart2")
	public String start() {
		return "ajax_jquery2";
	}
	
	@GetMapping("/helloajax2")
	@ResponseBody
	public String hellojajx2(){
		return "{\"model\" :  \"스프링부트(ajax)를 시작합니다\"}";
	}
	
}



