package co.mini.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.mini.board.common.DAO;
import co.mini.board.vo.MemberVo;

public class MemberDAO extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

	// 관리자용 멤버조회 *****************
	
	

	// 관리자용 멤버 수정 *****************

	// 관리자용 멤버삭제 ****************
	
	
	

	// 회원가입 등록
	public int insert(MemberVo vo) {
		int n = 0;

		String sql = "INSERT INTO member(memberid, membername, memberpassword,membertel, memberaddress) values(?,?,?,?,?);";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPassword());
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAddress());

			n = psmt.executeUpdate();
			System.out.println("�쉶�썝媛��엯 �벑濡� " + n + "嫄� �벑濡�");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	// 로그인 기능

	public MemberVo login(MemberVo vo) {

		String sql = "SELECT MEMBERID, MEMBERNAME,MEMBERAUTH FROM MEMBER WHERE MEMBERID=? AND MEMBERPASSWORD=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());

			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return vo;

	}

	
	//close
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
