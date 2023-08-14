package service;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Memos;
import entity.Users;
import lombok.RequiredArgsConstructor;
import repository.MemoRepository;
import repository.UserRepository;

@Service
@RequiredArgsConstructor //final변수초기화생성자.= Autowired 대신
public class MemoService {
	//@Autowired
	final UserRepository userRepository;
	final MemoRepository memoRepository;
	//user 입력
	public void input(long id, String contents){
		//id가 1번 사용자 contents 글내용 작성
		//4명 user 등록 - insert
		Memos memo = new Memos();
		memo.setContents(contents);
		//memo.setMemoseq(0);//자동증가
		
		//메모를 쓸려는 작성자 정보 user 객체로 return 
		Users user = userRepository.findById(id);
		memo.setWriter(user);
		memoRepository.save(memo);
		
	}
	

	//모든 user 조회
	public List<Memos> getMemos() {
		return memoRepository.findAll();
	}
	
	//특정 user의 모든 메모를 조회
	public List<Memos> getUserMemos(long id){
		return memoRepository.findByWriter(userRepository.findById(id));
	}
	
}
