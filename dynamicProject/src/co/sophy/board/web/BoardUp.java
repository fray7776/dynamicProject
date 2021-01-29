package co.sophy.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sophy.board.common.Command;

public class BoardUp implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// /BoardEdit.do ¸Þ¼Òµå
		return "board/boardEditForm";
	}

}
