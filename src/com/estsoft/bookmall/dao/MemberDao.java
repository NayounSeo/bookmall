package com.estsoft.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookmall.vo.MemberVo;

public class MemberDao {
	private Connection getConnection( ) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버를 찾을 수 없습니다." + ex);
		}
		return conn;
	}
	
	public List<MemberVo> getList() {
		List<MemberVo> list = new ArrayList<MemberVo>( );
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection( );
			stmt = conn.createStatement();
			String sql = "SELECT memberId, memberName, email, password, phone FROM member";
			rs = stmt.executeQuery(sql);
			while(rs.next() ) {
				Long memberId = rs.getLong(1);
				String memberName = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				String phone = rs.getString(5);
				
				MemberVo memberVo = new MemberVo( );
				memberVo.setMemberId(memberId);
				memberVo.setMemberName(memberName);
				memberVo.setEmail(email);
				memberVo.setPassword(password);
				memberVo.setPhone(phone);
				
				list.add(memberVo);
			}
		} catch ( SQLException ex ) {
			System.out.println("error : " + ex);
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				if ( stmt != null ) {
					stmt.close();
				}
				if (conn != null ) {
					conn.close( );
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return list;	
	}
	
	public void insert(MemberVo memberVo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			//3.Statement 준비
			String sql  = "INSERT INTO member values ( null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. Bind
			pstmt.setString(1, memberVo.getMemberName());
			pstmt.setString(2, memberVo.getEmail());
			pstmt.setString(3, memberVo.getPassword());
			pstmt.setString(4,  memberVo.getPhone());
			
			pstmt.executeUpdate( );
		} catch (SQLException ex) {
			System.out.println("SQL 오류 : "+ ex);
		} finally {
			try {
				if (pstmt != null ) {
					pstmt.close( );
				}
				if (conn != null ) {
					conn.close();
				}
			} catch (SQLException ex ) {
				ex.printStackTrace();
			}
		}
	}

}
