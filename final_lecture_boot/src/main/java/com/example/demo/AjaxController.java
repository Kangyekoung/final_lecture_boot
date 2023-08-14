package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AjaxController {
	
	@RequestMapping("/ajaxstart")
	public String start() {
		return "ajax_jquery";
	}
	
	@GetMapping("/helloajax")// 요청 - 응답 view 리턴
	@ResponseBody //요청(동일 서버 동작 파일) - 응답 현재뷰 포함 데이터 리턴
	@CrossOrigin("*")	//CORS 허용. 요청(다른(모든) 서버 동작 파일) - 응답 현재뷰 포함 데이터 리턴
	public LoginDTO helloajax(){
		return new LoginDTO("get-id", 1111);
	}
	
	@GetMapping("/helloajaxparam")// 요청 - 응답 view 리턴
	@ResponseBody //요청(동일 서버 동작 파일) - 응답 현재뷰 포함 데이터 리턴
	@CrossOrigin("*")	//CORS 허용. 요청(다른(모든) 서버 동작 파일) - 응답 현재뷰 포함 데이터 리턴
	public LoginDTO helloajaxparam(String id, int password){
		return new LoginDTO(id, password);
	}
	
	@PostMapping("/helloajaxparam")// 요청 - 응답 view 리턴
	@ResponseBody //요청(동일 서버 동작 파일) - 응답 현재뷰 포함 데이터 리턴
	@CrossOrigin("*")	//CORS 허용. 요청(다른(모든) 서버 동작 파일) - 응답 현재뷰 포함 데이터 리턴
	//jquery
	public LoginDTO helloajaxparampost(LoginDTO dto){
	//react
	//public LoginDTO helloajaxparampost(@RequestBody LoginDTO dto){ //@RequestBody : react에서 json 전달, 해석
		return dto;
	}
	
	//@ReponseBody - 응답데이터 json
	//@RequestBody - 요청데이터 json 해석
	
	@GetMapping("/helloajaxarray")
	@ResponseBody
	@CrossOrigin("*")
	
	//jquery
	/*public ArrayList<Integer> helloajaxarray(@RequestParam("ids[]") ArrayList<Integer> ids){
		System.out.println();
		//ids 숫자 요청 전달받아서 10배 곱한 결과 리턴
		for(int i = 0; i < ids.size(); i++) {
			ids.set(i, ids.get(i)*10);
		}
		return ids;
	}
	*/
	//react - ids=1&ids=5&ids=9
	public int[] helloajaxarray(int[] ids){
		System.out.println();
		//ids 숫자 요청 전달받아서 10배 곱한 결과 리턴
		for(int i = 0; i < ids.length; i++) {
			ids[i] = ids[i] * 10;
		}
		return ids;
	}
	
	@PostMapping("/playerInfo")// 요청- 응답 view 리턴
	@ResponseBody //요청(동일 서버 동작 파일)- 응답 현재뷰 포함 데이터 리턴
	@CrossOrigin("*")   //CORS 허용. 요청(다른(모든) 서버 동작 파일)- 응답 현재뷰 포함 데이터 리턴
	
	//parameters => {"playerList" : JSON.stringify(playerArray(자바스크립트객체2개배열);}
	
	//jquery
	//public PlayerDTO playerInfo(@RequestParam Map<String, Object>  parameters ) throws Exception {
	
	//react
	public PlayerDTO playerInfo(@RequestBody Map<String, Object>  parameters ) throws Exception {
		// json = JSON.stringify(playerArray)
		String json = parameters.get("playerList").toString();
		ObjectMapper mapper = new ObjectMapper();
		
		//전달받은 요청데이터를 PlayerDTO 객체저장 ArrayList 변환
		List<PlayerDTO>  list = mapper.readValue(json, new TypeReference<ArrayList<PlayerDTO>>() {} );
		// player값이 "son"이면 국적, 이름 정보 전달
		for(PlayerDTO dto  :list) {
			if(dto.player.equals("son")) {
				return new PlayerDTO(dto.player, dto.goal, "한국", "손흥민");
			}
		}
		return new PlayerDTO("", 0, "none","찾을 수 없음");
	}
	
	
}//controller end


class LoginDTO{
	String id;
	int password;
	
	public LoginDTO() {
		
	}
	
	public LoginDTO(String id, int password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class PlayerDTO{
	String player;
	int goal;
	String nation;
	String name;
	
	public PlayerDTO() {}
	
	public PlayerDTO(String player, int goal, String nation, String name) {
		super();
		this.player = player;
		this.goal = goal;
		this.nation = nation;
		this.name = name;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}