package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
/* drop table users;
 * create table users (컬러명 타입 제약조건 , , , ); 
 * create table users (id int primary key auto_increment, username varchar(20) not null);
 * */
@Table(name="users")
@Entity	//jpa db 연결시 테이블 매핑(db users 테이블 = Users 클래스(변수) 객체 매핑)
@Getter
@Setter
public class Users {
	@Id //pk
	@GeneratedValue(strategy=GenerationType.IDENTITY) //mysql - auto_increment(insert sql 실행시 자동 1 증가), oracle - sequence
	long id;
	@Column(length=20, nullable=false)
	String username;
	
//	@Transient
//	int pw; //db 저장 컬럼명 아니다. 자바 임시변수
}
