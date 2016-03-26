package com.estsoft.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookmall.vo.BookVo;

//어제 했던 것들 중 AuthorDao 참고한다.
public class BookDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");
			//2. Connection 얻기
			String url = "jdbc:mysql://localhost/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버를 찾을 수 없습니다 : " + ex);
		}
		return conn;
	}
	
	//list화 시키는 것은 바로 여기였던 듯 하다.
	//뭐가 잘못된거지?!? error : java.sql.SQLException: Invalid value for getLong( ); -> 사스가 오타
	public List<BookVo> getList( ) {
		List<BookVo> list = new ArrayList<BookVo>( );
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT b.bookId, c.categoryId, b.title, b.price FROM book b, category c WHERE b.categoryId = c.categoryId ORDER BY b.bookId ASC";
			rs = stmt.executeQuery( sql );
			while( rs.next( ) ) {
				Long bookId = rs.getLong(1);
				Long categoryId = rs.getLong(2);
				String title = rs.getString(3);
				int price = rs.getInt(4);
				
				BookVo bookVo = new BookVo( );
				bookVo.setBookId(bookId);
				bookVo.setCategoryId(categoryId);
				bookVo.setTitle(title);
				bookVo.setPrice(price);
				
				list.add(bookVo);
			}
		} catch (SQLException ex) {
			System.out.println("error : "+ex);
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				if ( stmt != null ) {
					stmt.close();
				}
				if ( conn != null ) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return list;	
	}
	
	public void insert (BookVo bookVo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection( );
			//3. Statement 준비
			String sql = "INSERT INTO book values( null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. bind
			pstmt.setLong(1,  bookVo.getCategoryId());
			pstmt.setString(2, bookVo.getTitle());
			pstmt.setInt(3,  bookVo.getPrice());
			
			//5. SQL 실행
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQL 오류 : " + ex);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
