<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.DBConnPool" %>    
<%@ page import="common.JDBConnect" %>   
<%@ page import="membership.MemberDAO"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커넥션 풀</title>
</head>
<body>
	<h2>커넥션 풀 테스트</h2>
	<%
// 		DBConnPool pool = new DBConnPool();
// 		pool.close();

// 		JDBConnect jdbc = new JDBConnect();
// 		jdbc.close();

// 		JDBConnect jdbc = new JDBConnect(application);
// 		jdbc.close();
		
	String oracleDriver = application.getInitParameter("OracleDriver");
	String oracleURL = application.getInitParameter("OracleURL");
	String oracleId = application.getInitParameter("OracleId");
	String oraclePwd = application.getInitParameter("OraclePwd");
	
	MemberDAO dao = new MemberDAO(oracleDriver, oracleURL, oracleId, oraclePwd);

		
	%>
</body>
</html>