package co.sophy.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "sophy";
	private String password = "1234";
	
	public Connection conn;
	
	//생성자: classname과 동일한 메소드, DAO가 클래스니까 아래는 DAO에 대한 생성자
	public DAO() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}
}
