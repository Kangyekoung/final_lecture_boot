<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#ajaxbtn").on('click', function(){
		$.ajax({
			url : '/helloajax',
			type:'get',
			dataType : 'json',
			success : function(server){
				$("#result").html
				(server.id +":" + server.password);
			}
		});
	});//ajaxbtn end
	
	//2. 매개변수 o, get 방식
	$("#ajaxbtn2").on('click', function(){
		$.ajax({
			url : '/helloajaxparam',
			data : {id : 'ajax-get-id', password : 2222},
			type:'get',
			dataType : 'json',
			success : function(server){
				$("#result").html
				(server.id +":" + server.password);
			}
		});
	});//ajaxbtn2 end
	
	//3. 매개변수 o /post 방식
	$("#ajaxbtn3").on('click', function(){
		$.ajax({
			url : '/helloajaxparam',
			data : {id : 'ajax-post-id', password : 3333},
			type:'post',
			dataType : 'json',
			success : function(server){
				$("#result").html
				(server.id +":" + server.password);
			}
		});
	});//ajaxbtn3 end

	//4.매개변수(배열)-리턴(배열)/get방식
	//배열
	//ids[] 변수명 인식 전달 - 컨트롤러 변수명 '[]'포함 변수명 없다
	//http://localhost:8080/helloajaxarray?ids%5B%5D=1&ids%5B%5D=5&ids%5B%5D=9&ids%5B%5D=8
	//배열-ArrayList 변환
	$("#ajaxbtn4").on('click', function(){
		$.ajax({
			url : '/helloajaxarray',
			data : {ids : [1, 5, 9, 8]}, //ids[]=1&ids[[=5]
			type:'get',
			dataType : 'json',
			success : function(server){
				$("#result").html();
				for(var i in server){
					$("#result").append(server[i] + "<br>");
				}
				
			}
		});
	});//ajaxbtn4 end
	
	
	//5. 매개변수(객체배열) /post방식
	$("#ajaxbtn5").on('click', function(){
		var playerArray = [];
		
		var player1 = { "player":"son", "goal":30 };
		var player2 = { "player":"kane", "goal":45 };	
		
		playerArray.push(player1);
		playerArray.push(player2);		
		
		var playerList = {"playerList" : JSON.stringify(playerArray) }
		
		$.ajax({
			url : '/playerInfo',
			data : playerList,
			type:'post',
			dataType : 'json',
			success : function(server){//server=PlayerDTO객체
			 $("#result").html(server.nation + ":" + server.name);
				
			}
		});
	});//ajaxbtn5 end
});//ready end
</script>
</head>
<body>
<input type=button value="ajax(매개변수없는get)요청" id="ajaxbtn">
<input type=button value="ajax(매개변수전달있는get)요청" id="ajaxbtn2">
<input type=button value="ajax(매개변수전달있는post)요청" id="ajaxbtn3">
<input type=button value="ajax(매개배열get)요청" id="ajaxbtn4">
<input type=button value="ajax(객체배열post)요청" id="ajaxbtn5">
<div id="result"></div>
</body>
</html>
