package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> { //<Entity명, PK타입>
	//save
	//delete
	//findAll
	//findOne
	//count
	List<Users> findByUsernameLikeOrderByIdDesc(String name);
	//select * from users where id like '%name변수%' order by id desc;
	Users findById(long id);//select * from users where id=id변수
}
