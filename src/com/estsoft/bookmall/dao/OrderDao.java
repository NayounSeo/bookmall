package com.estsoft.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookmall.vo.OrderVo;
import com.estsoft.bookmall.vo.OrderedBooksVo;
//TH 연지 : DB에 OrderedBooks를 구현하기 위한 준비를
//여기에서 메소드들로 해준다!!
//가격은 그냥 넣어줘도 괜찮다고.
public class OrderDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 2. Connection 얻기
			String url = "jdbc:mysql://localhost/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버를 찾을 수 없습니다:" + ex);
		}
		return conn;
	}
	
	public void insert( OrderVo orderVo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// DB 연결 가져오기
			conn = getConnection();
			
			//Statement 준비
			String sql = "INSERT INTO orders values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement( sql );
			
			// bind
			pstmt.setLong(1, orderVo.getMemberId());
			pstmt.setLong(2, orderVo.getBookId());
			pstmt.setInt(3, orderVo.getPrice());
			pstmt.setString(4,  orderVo.getAddress());
			
			// SQL 실행
			pstmt.executeUpdate();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		} finally {
			// 자원정리(clean-up)
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}		
	}
	
	public List<OrderVo> getList() {

		List<OrderVo> list = new ArrayList<OrderVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql ="SELECT o.orderId, m.memberId, o.bookId, o.price, o.address FROM orders o, member m WHERE o.memberId = m.memberId "
					+ "ORDER BY o.orderId ASC";
			rs = stmt.executeQuery( sql );
			while( rs.next() ) {
				Long orderId = rs.getLong(1);
				Long memberId = rs.getLong(2);
				Long bookId = rs.getLong(3);
				int price = rs.getInt(4);
				String address = rs.getString(5);
				
				OrderVo orderVo = new OrderVo();
				orderVo.setOrderId(orderId);
				orderVo.setMemberId(memberId);
				orderVo.setBookId(bookId);
				orderVo.setPrice(price);
				orderVo.setAddress(address);
				list.add(orderVo);
			}
			
		} catch( SQLException ex ) {
			System.out.println( "error : " + ex );
		} finally {
			try {
				if (rs != null) {
					rs.close();				
				}
				if (stmt != null){
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

	//JOIN에 제한조건을 붙이기 위해서 주문 Orders 테이블에 서적 번호 추가.
	public void insertOrderedBooks() {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO orderedBooks(orderId, bookId, quantity)"
					+ " SELECT o.orderId, c.bookId, c.quantity FROM orders o, cart c"
					+ " WHERE o.memberId = c.memberId AND o.bookId = c.bookId";
			
			stmt.executeUpdate(sql);
	
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		} finally {
			// 자원정리(clean-up)
			try {
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}		
		
	}
	
	public List<OrderedBooksVo> getListOrderedBooks() {
		List<OrderedBooksVo> list = new ArrayList<OrderedBooksVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT orderId, bookId, quantity FROM orderedBooks";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Long orderId = rs.getLong(1);
				Long bookId = rs.getLong(2);
				int quantity = rs.getInt(3);
				
				OrderedBooksVo orderedBooksVo = new OrderedBooksVo();
				orderedBooksVo.setOrderId(orderId);
				orderedBooksVo.setBookId(bookId);
				orderedBooksVo.setQuantity(quantity);

				list.add(orderedBooksVo);
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
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		return list;
	}

}


