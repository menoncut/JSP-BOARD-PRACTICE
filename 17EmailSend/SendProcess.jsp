<%@page import="org.w3c.dom.html.HTMLCollection"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="smtp.NaverSMTP"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Map<String, String> emailInfo = new HashMap<String, String>();
	emailInfo.put("form", request.getParameter("form"));
	emailInfo.put("to", request.getParameter("to"));
	emailInfo.put("subject", request.getParameter("subject"));
	
	String content = request.getParameter("content");
	String format = request.getParameter("format");
	if (format.equals("text")) {
		emailInfo.put("content", content);
		emailInfo.put("format", "text/plain;charset=UTF-8");
	}
	else if (format.equals("html")) {
		content = content.replace("\r\n", "<br>");
		String htmlContent = "";
		try {
			String templatePath = application.getRealPath(
													"/17EmailSend/MailForm.html");
			BufferedReader br = new BufferedReader(new FileReader(templatePath));
			
			String oneLine;
			while ((oneLine = br.readLine()) != null) { 
				htmlContent += oneLine + "\n";
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	htmlContent = htmlContent.replace("__CONTENT__", content);
	emailInfo.put("content", htmlContent);
	emailInfo.put("format", "text/html;charset=UTF-8");
	}
	
	try {
		NaverSMTP smtpServer = new NaverSMTP();
		smtpServer.emailSending(emailInfo);
		out.print("이메일 전송 성공");
	}
	catch (Exception e) {
		out.print("이메일 전송 실패");
		e.printStackTrace();
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>