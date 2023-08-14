package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Memos;
import entity.Users;
import lombok.RequiredArgsConstructor;
import service.MemoService;
import service.UserService;

@RestController //ResponseBody 메소드에 다 붙어있기
@RequiredArgsConstructor
public class MemoController {
	//@Autowired
	final MemoService memoservice;
	
	@GetMapping("/inputMemo")
	public List<Memos> inputMemo(long id, String contents) {
		memoservice.input(id, contents);//메모 등록
		//return memoservice.getMemos(); ///모든 메모 정보조회
		
		// user id 작성 메모 정보 조회
		return memoservice.getUserMemos(id);//user id 작성 메모 정보 조회
		
	}
}
