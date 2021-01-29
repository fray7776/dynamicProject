package co.sophy.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;
import co.sophy.board.dao.BoardDao;
import co.sophy.board.vo.BoardVo;

public class BoardDelete implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// boardDelete.doÃ³¸® 
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		
		request.setAttribute("vo", vo);
		int n = dao.delete(vo);
		String viewPage=null;
		
		if(n>0) {
			viewPage="board/successdel";
		}else {
			viewPage="board/faildel";
		}
		return viewPage;
	}

}
