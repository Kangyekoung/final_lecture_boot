package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Users;
import lombok.RequiredArgsConstructor;
import service.UserService;

@RestController //ResponseBody 메소드에 다 붙어있기
@RequiredArgsConstructor
public class UserController {
	//@Autowired
	final UserService userservice;
	
	@GetMapping("/inputUser")
	public List<Users> inputUser() {
		userservice.input();//3명 user 등록
		//return userservice.getUsㄴㄴers();//모든 user 정보 조회
		return userservice.getUsers("%길동%"); //이름 "길동" 포함 user 조회  
	}
}
