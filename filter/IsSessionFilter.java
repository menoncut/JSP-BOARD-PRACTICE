package filter;

import java.io.*;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName="IsSessionFilter",
		urlPatterns={"/09PagingBoard/Write.jsp",
		"/09PagingBoard/Edit.jsp", "/09PagingBoard/DeleteProcess.jsp"})
public class IsSessionFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
//		OutputStream os = null;
//		PrintStream out = new PrintStream(os, true);
		if (session.getAttribute("UserId") == null) {
			String backUrl = req.getRequestURI();

//			out.print("<html><body><script>");
//			out.print("alert('[filter]로그인 후 이용하세요.')");
//			out.print("</script></body></html>");
			
						resp.sendRedirect("../15FilterListener/LoginFilter.jsp?backUrl=" + backUrl);
//			String msg = "[Filter] 로그인 후 이용해주십시오.";
//			String url = "../15FilterListener/LoginFilter.jsp";
//			String script = ""
//					+ "<script>"
//					+ "		alert('" + msg + "');"
//					+ "		location.href='" + url + "';"
//					+ "</script>";
//			out.print(script);
//			JSFunction.alertLocation("[Filter] 로그인 후 이용해주십시오.",
//					"../15FilterListener/LoginFilter.jsp", out);
			System.out.println(backUrl);
			return;
		}
		else {
			chain.doFilter(request, response);
		}
	}
}
