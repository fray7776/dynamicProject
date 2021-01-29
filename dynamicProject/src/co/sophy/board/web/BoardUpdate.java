package co.sophy.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;
import co.sophy.board.dao.BoardDao;
import co.sophy.board.vo.BoardVo;

public class BoardUpdate implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// Update.do처리 메소드
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo.setbContent(request.getParameter("text1"));
		
		request.setAttribute("vo", vo);
		int n=dao.update(vo);
		
		return "BoardList.do";
	}

}
