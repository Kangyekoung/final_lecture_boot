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
	$("#ajaxbtn").on('click', function(){
		$.ajax({
			url : '/helloajax2',
			type: 'get',
			dataType: 'json',
			success : function(server){
				$("#result").html(server.model);
			}
		});
		
	});//ajaxbtn end
	
	$("#ajaxbtn2").on('click', function(){
		$.ajax({
			url : '/helloajaxparam2',
			data : {id: 'ajax-get-id', password : 2222},
			type: 'get',
			dataType: 'json',
			success : function(server){
				$("#result").html(server.id +":" + server.password);
			}
		});
		
	})
});
</script>
</head>
<body>
<input type=button value="ajax(매개변수없는get)요청" id="ajaxbtn">
<input type=button value="ajax(매개변수전달있는get)요청" id="ajaxbtn2">
<div id="result"></div>
</body>
</html>