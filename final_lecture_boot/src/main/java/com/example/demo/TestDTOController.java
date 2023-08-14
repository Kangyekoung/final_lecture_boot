package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestDTOController {
	@RequestMapping("/lomboktest")
	@ResponseBody
	public TestDTO test(String id, int pw, String clientid) {
		TestDTO dto = new TestDTO(id, pw, clientid);
		dto.setPw(1234);
		return dto;
	}
}
