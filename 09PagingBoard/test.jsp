<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int tCount = 0; 
	BoardDAO dao = new BoardDAO(application);
	Map<String, Object> map = new HashMap<String, Object>();
	
	tCount = dao.selectCount(map);
%>
	<p>board 테이블 전체 게시글 수 : <%= tCount %></p>
<!-- 검색조건이 있다면 검색조건에 맞는 전체 게시글 수를 가져오고
검색조건이 없다면 위와 같이 빈 map 객체만 전달하면 전체 게시글 수를 반환한다. -->	
	
</body>
</html>