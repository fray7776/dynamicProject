package co.sophy.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import co.sophy.board.common.Command;
import co.sophy.board.dao.BoardDao;
import co.sophy.board.vo.BoardVo;

public class BoardList implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		//게시판 리스트를 가져온느것
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		list=dao.selectList();
		request.setAttribute("list", list);
				
		return "board/BoardList";
	}

}
