package com.estsoft.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookmall.vo.CartVo;

public class CartDao {
	private Connection getConnection( ) throws SQLException {
		Connection conn = null;
		try {
			//1. 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.  Connection 얻기
			String url = "jdbc:mysql://localhost/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버를 찾을 수 없습니다 : "+  ex);
		} 
		return conn;
	}
	
	//getList 할 때 !! JOIN으로 불러오면 번호가 아니라 이름이 뜬다고~~~~ 아 그렇게 하고 싶다는 얘기인가..?
	//아직 정확한 내막은 모르겠지만 그렇다고 한다. 흠 신기하군 고쳐보자! 
	//만약 a라는 테이블이 주인데 b라는 곳에서 외래키를 가져오면 b.이라고 써주는 식이라고 한다...??
	//하지만 이것의 장점은 무엇이지?? 이것은 내일 연지 공의에게 물어보도록 하자.
	public List<CartVo> getList() {
		List<CartVo> list = new ArrayList<CartVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT m.memberId, b.bookId, c.quantity FROM cart c, member m, book b WHERE "
					+ "c.memberId = m.memberId AND c.bookId = b.bookId";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Long memberId = rs.getLong(1);
				Long bookId = rs.getLong(2);
				int quantity = rs.getInt(3);
				
				CartVo cartVo = new CartVo();
				cartVo.setMemberId(memberId);
				cartVo.setBookId(bookId);
				cartVo.setQuantity(quantity);
				
				list.add(cartVo);
			}
		} catch (SQLException ex) {
			System.out.println("error : " + ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return list;
	}
	
	public void insert(CartVo cartVo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			//Foreign key 값은 자동 증가 안들어간다~~~ ?로 받아주면!
			String sql  = "INSERT INTO cart values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//bind
			pstmt.setLong(1, cartVo.getMemberId());
			pstmt.setLong(2, cartVo.getBookId());
			pstmt.setInt(3, cartVo.getQuantity());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQL 오류 : " + ex);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
