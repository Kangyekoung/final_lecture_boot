package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
////@NoArgsConstructor //기본생성자 - final 변수x
@AllArgsConstructor //모든 멤버변수 생성자
//@RequiredArgsConstructor//final변수 포함 생성자
@Data//@Setter @Getter @ToString @RequiredArgsConstructor
public class TestDTO { 
	String id;
	int pw;
	final String clientid; //final선언변수값 초기화는 생성자내부 초기화(setter x)
	
}
