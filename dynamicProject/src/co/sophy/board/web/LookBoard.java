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
		// newBoard.doó�� �޼ҵ�, �� �󼼺���
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		ReplyVo rvo = new ReplyVo();
		ArrayList<ReplyVo> list = new ArrayList<ReplyVo>(); //��� ���
		
		vo.setbId(Integer.parseInt(request.getParameter("bId"))); //BoardList�� ���� form�� hidden���� bid�� �Ѿ���ϱ� 
		rvo.setBid(Integer.parseInt(request.getParameter("bId"))); //��� ��������
		
		vo = dao.select(vo); //vo�� �ٽ� ��ڴٴ�.. �ֱ��� �о close�ǰ� 
		dao = new BoardDao(); //�ٽ� dao��� ���۽�Ű��
		list = dao.replySelect(rvo); //��� �б�
		request.setAttribute("vo", vo); //main ��
		request.setAttribute("list", list); // reply ��
		return "board/boardView"; //.do�� �ƴϴϱ� command�� .jsp�ٿ��ٰ���
	}

}
