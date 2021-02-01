package co.mini.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mini.board.common.DAO;
import co.mini.board.vo.BookRentalVo;
import co.mini.board.vo.MemberVo;

public class BookRentalDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

//관리자용 조회(전체 대여 조회기능)
	public ArrayList<BookRentalVo> SelectAdminRental(MemberVo m) {
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalVo vo = new BookRentalVo();
		String sql = "SELECT * FROM BOOK A, BOOKRENTAL B WHERE A.BOOKCODE=B.BOOKCODE";
		
		try {
			psmt= conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setRentalCode(rs.getInt("rentalcode"));
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getDate("returndate"));
				vo.setBookName(rs.getString("bookname"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
		
	
//회원용 조회
	public ArrayList<BookRentalVo> SelectUserRental(MemberVo m) {

		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalVo vo;
		String sql = "select * from book a, bookrental b where a.bookcode=b.bookcode and b.memberid=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m.getMemberId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookRentalVo();
				vo.setRentalCode(rs.getInt("rentalcode"));
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getDate("returndate"));
				vo.setBookName(rs.getString("bookname"));
				list.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

//대출
	public int Rental(BookRentalVo vo) {
		int n = 0;
		int n2 = 0;

		String sql = "UPDATE BOOK SET BCOUNT=(BCOUNT-1) WHERE BOOKCODE=?;";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());

			n = psmt.executeUpdate();

			if (n != 0) {
				sql = "INSERT INTO BOOKRENTAL(RENTALCODE, RENTALDATE,BOOKCODE,MEMBERID) VALUES(RENTAL_SEQ.NEXTVAL, 4, 0)), SYSDATE, ?,?)";
			
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getBookCode());
				psmt.setString(2, vo.getMemberId());
				
				n2= psmt.executeUpdate();
			
			
			}
			

		} catch (SQLException e) {
			System.out.println("��異쒖떎�뙣");
			e.printStackTrace();
		} finally {
			close();
		}

		return n+n2;
	}

//반납
	public int Return(BookRentalVo vo) {
		int n = 0;
		int n2 = 0;

		String sql = "UPDATE (SELECT BCOUNT FROM BOOK A, BOOKRENTAL B WHERE A.BOOKCODE=B.BOOKCODE AND B.RENTALCODE='?') SET BCOUNT=(BCOUNT+1)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getRentalCode());

			n = psmt.executeUpdate();

			if (n != 0) {
				sql = "update (select returndate from book a, bookrental b where A.bookcode=b.bookcode and b.rentalcode='?') set returndate=sysdate";
			
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, vo.getRentalCode());
				
				n2= psmt.executeUpdate();			
			
			}
			

		} catch (SQLException e) {
			System.out.println("諛섎궔�떎�뙣");
			e.printStackTrace();
		} finally {
			close();
		}

		return n+n2;
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
