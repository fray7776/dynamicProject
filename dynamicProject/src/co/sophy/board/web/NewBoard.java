package co.sophy.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;

public class NewBoard implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// newBoard.do처리 메소드
		return "board/newBoardForm";
	}

}
