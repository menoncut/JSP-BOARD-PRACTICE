package model2.mvcboard;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/14MVCBoard/Write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String savaDirectory = req.getServletContext().getRealPath("/Uploads");
		String originalFileName = "";
		try {
			originalFileName = FileUtil.uploadFile(req, savaDirectory);
			System.out.println("들어옴");
		}
		catch (Exception e) {
			resp.sendRedirect("../mvcboard/write.do");
			return;
		}
		
		MVCBoardDTO dto = new MVCBoardDTO();
		dto.setName(req.getParameter("name"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setPass(req.getParameter("pass"));
		
		if(originalFileName != "") {
			String saveFileName = FileUtil.renameFile(savaDirectory, originalFileName);
			dto.setOfile(originalFileName);
			dto.setSfile(saveFileName);
		}
		
		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.insertWrite(dto);
		dao.close();
		
		if(result == 1) {
			resp.sendRedirect("../mvcboard/list.do");
		}
		else {
			resp.sendRedirect("../mvcboard/write.do");			
		}
	}
}

























































