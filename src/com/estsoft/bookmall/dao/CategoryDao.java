package com.estsoft.bookmall.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.estsoft.bookmall.vo.CategoryVo;

public class CategoryDao {
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
	
	public List<CategoryVo> getList( ) {
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			//3. Statement 실행
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = "SELECT categoryId, categoryName FROM category";
			rs = stmt.executeQuery(sql);
			
			//5. 데이터 받아오기
			while(rs.next( )) {
				Long categoryId  = rs.getLong(1);
				String categoryName = rs.getString(2);
				
				CategoryVo categoryVo = new CategoryVo( );
				categoryVo.setCategoryId(categoryId);
				categoryVo.setCategoryName(categoryName);
				
				list.add( categoryVo );
				
			}
		} catch (SQLException ex) {
			System.out.println("SQL 오류 : " + ex);
		} finally {
			try {
				if (rs != null ) {
					rs.close();
				}
				if (stmt != null ) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return list;
	}
	
	public void insert( CategoryVo categoryVo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			//3. Statement  준비
			String sql = "INSERT INTO category values(null, ?)";
			pstmt = conn.prepareStatement(sql);
			//4. Bind
			pstmt.setString(1, categoryVo.getCategoryName());
			//5. SQL 실행
			pstmt.executeUpdate( );
		} catch (SQLException ex) {
			System.out.println("SQL 오류 : " +ex);
		} finally {
			//6. 자원 정리
			try {
				if ( pstmt != null ) {
					pstmt.close();
				}
				if ( conn != null ) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}		
	}

}
