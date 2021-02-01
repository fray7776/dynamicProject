package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.dao.BookDAO;
import co.mini.board.vo.BookVo;

public class InsertBAdmin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// insertbAdmin.do 처리하는 메소드
		BookDAO dao = new BookDAO();
		BookVo vo = new BookVo();
		
		vo.setBookName(request.getParameter("bookName"));
		vo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		vo.setbCount(Integer.parseInt(request.getParameter("bCount")));
		
		request.setAttribute("vo", vo);
		int n=dao.insertAdmin(vo);
		
		return "bookManage/InsertBookForm";
	}

}
