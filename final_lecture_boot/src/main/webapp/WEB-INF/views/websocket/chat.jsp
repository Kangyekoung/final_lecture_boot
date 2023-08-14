<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function(){
	var websocket;
	$("#enterbtn").on('click', function(){
		websocket = new WebSocket("ws://localhost:8080/chatws");
		//websocket open 되어있을때, 연결 되어있는지 확인
		websocket.onopen = function(){console.log("웹소켓 연결 성공");}
		websocket.onclose = function() {console.log("웹소켓 연결 해제 성공");}
		websocket.onmessage= function(server){
			console.log("웹소켓으로부터 수신(서버에서 데이터 받음) 성공");
			$("#chatarea").append(server.data+"<br>");
		}
	});
	$("#exitbtn").on('click', function(){
		websocket.close();	
	});
	
	$("#sendbtn").on('click', function(){//메시지전송버튼클릭시
		//nickname : message
		websocket.send($("#nickname").val() + ":" + $("#message").val());
		$("#message").val('');
	});
	
	$("#message").on('keydown', function(e){//메시지엔터시
		//엔터키
		if(e.keyCode == 13){
			websocket.send($("#nickname").val() + ":" + $("#message").val());
			$("#message").val('');
		}
	});
});
</script>
</head>
<body>
아이디 <input type=text id="nickname" value=${param.id}><!-- el표기범  http://localhost:8080/chatstart?id=조-->
<input type=button value="입장" id="enterbtn">
<input type=button value="퇴장" id="exitbtn">

<h1>채팅 영역</h1>
<div id="chatarea" style="background-color:yellow;border:2px solid black">
채팅내용표시<br></div>
대화 : <input type=text id="message">
<input type=button value="메시지전송" id="sendbtn">
</body>
</html>