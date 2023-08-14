package service;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Users;
import lombok.RequiredArgsConstructor;
import repository.UserRepository;

@Service
@RequiredArgsConstructor //final변수초기화생성자.= Autowired 대신
public class UserService {
	//@Autowired
	final UserRepository userRepository;
	
	//user 입력
	public void input(){
		//4명 user 등록
		Users user1 = new Users();
		user1.setUsername("홍길동");
		userRepository.save(user1);
		
		Users user2 = new Users();
		user2.setUsername("이자바");
		userRepository.save(user2);
		
		Users user3 = new Users();
		user3.setUsername("김정보");
		userRepository.save(user3);
		
		Users user4 = new Users();
		user4.setUsername("김길동");
		userRepository.save(user4);
		
		//update 
		//id가 4인걸 김길동 -> 홍길동
		Users user5 = new Users();
		user5.setId(4);
		user5.setUsername("최길동");
		userRepository.save(user5);
		
		//delete
		//userRepository.delete(user5);
	}
	

	//모든 user 조회
	public List<Users> getUsers() {
		return userRepository.findAll();
	}
	
	//특정 user 조회
	public List<Users> getUsers(String name){
		return userRepository.findByUsernameLikeOrderByIdDesc(name);
	}
}
