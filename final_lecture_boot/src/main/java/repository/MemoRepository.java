package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Memos;
import entity.Users;

public interface MemoRepository extends JpaRepository<Memos, Integer> {
	//save, delete, count, findAll, findOne
	
	//사용자 정의 메소드
	List<Memos> findByWriter(Users writer);
}
