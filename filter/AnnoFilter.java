package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName="AnnoFilter", urlPatterns="/15FilterListener/AnnoFilter.jsp")
public class AnnoFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		System.out.println("검색 필드 : " + searchField);
		System.out.println("검색어 : " + searchWord);
		chain.doFilter(req, resp);
	}
	
	@Override
	public void destroy() {
	}
}
