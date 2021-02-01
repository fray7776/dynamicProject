package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import co.mini.board.common.Command;
import co.mini.board.common.DAO;
import co.mini.board.dao.MemberDAO;
import co.mini.board.vo.MemberVo;

public class Login extends DAO implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		MemberVo vo = new MemberVo();

		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));

		vo = dao.login(vo);
		HttpSession session = request.getSession();

		session.setAttribute("MemberVo", vo);

		return "main/main";

	}

}
