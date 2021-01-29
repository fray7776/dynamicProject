package co.sophy.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;
import co.sophy.board.dao.BoardDao;
import co.sophy.board.vo.BoardVo;
import co.sophy.board.vo.ReplyVo;

public class LookBoard implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// newBoard.do처리 메소드, 글 상세보기
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		ReplyVo rvo = new ReplyVo();
		ArrayList<ReplyVo> list = new ArrayList<ReplyVo>(); //댓글 담기
		
		vo.setbId(Integer.parseInt(request.getParameter("bId"))); //BoardList에 보면 form에 hidden으로 bid가 넘어오니까 
		rvo.setBid(Integer.parseInt(request.getParameter("bId"))); //댓글 가져오기
		
		vo = dao.select(vo); //vo에 다시 담겠다는.. 주글은 읽어서 close되고 
		dao = new BoardDao(); //다시 dao열어서 동작시키기
		list = dao.replySelect(rvo); //댓글 읽기
		request.setAttribute("vo", vo); //main 글
		request.setAttribute("list", list); // reply 글
		return "board/boardView"; //.do가 아니니까 command가 .jsp붙여줄거임
	}

}
