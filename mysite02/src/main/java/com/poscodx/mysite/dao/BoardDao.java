package com.poscodx.mysite.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.poscodx.mysite.vo.BoardVo;

public class BoardDao {
	public List<BoardVo> findAll(int page) {
		List<BoardVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int page1 = (page-1) * 5;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "select a.no, a.title, a.contents, a.hit, a.reg_date, a.g_no, a.o_no, a.depth, a.user_no, b.name, (select ceiling(count(*)/5) from board) as total from board a, user b where a.user_no = b.no order by g_no desc, o_no asc limit ?, 5";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			
			pstmt.setInt(1, page1);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				int hit = rs.getInt(4);
				Date reg_date = rs.getDate(5);
				int groupNo = rs.getInt(6);
				int orderNo = rs.getInt(7);
				int depth = rs.getInt(8);
				Long userNo = rs.getLong(9);
				String name = rs.getString(10);
				int total = rs.getInt(11);

				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setHit(hit);
				vo.setReg_date(reg_date);
				vo.setGroupNo(groupNo);
				vo.setOrderNo(orderNo);
				vo.setDepth(depth);
				vo.setUserNo(userNo);
				vo.setName(name);
				vo.setTotal(total);
				vo.setPage(page);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 7. 자원정리
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public void insert(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into board select null, ?, ?, 0, curdate(), MAX(g_no) + 1, 1, 1, ? from board";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setLong(3, vo.getUserNo());

			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertreply(BoardVo vo) {
		Connection conn = null;
		PreparedStatement update_pstmt = null;
		PreparedStatement insert_pstmt = null;

		try {
			conn = getConnection();

			String update_sql = "update board set o_no = o_no + 1 where g_no = ? and o_no >= ?";

			update_pstmt = conn.prepareStatement(update_sql);
			update_pstmt.setInt(1, vo.getGroupNo());
			update_pstmt.setInt(2, vo.getOrderNo() + 1);

			update_pstmt.executeQuery();

			String insert_sql = "insert into board values(null, ?, ?, 0, curdate(),?, ?, ?, ?)";

			insert_pstmt = conn.prepareStatement(insert_sql);
			insert_pstmt.setString(1, vo.getTitle());
			insert_pstmt.setString(2, vo.getContents());
			insert_pstmt.setInt(3, vo.getGroupNo());
			insert_pstmt.setInt(4, vo.getOrderNo() + 1);
			insert_pstmt.setInt(5, vo.getDepth() + 1);
			insert_pstmt.setLong(6, vo.getUserNo());

			insert_pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (update_pstmt != null) {
					update_pstmt.close();
				}
				if (insert_pstmt != null) {
					insert_pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void updateTitleAndContentsByNo(String title, String contents, String no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int no1 = Integer.parseInt(no);

		try {
			conn = getConnection();
			String sql = "update board set title=?, contents=? where no = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setInt(3, no1);

			pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void updatehit(String no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int no1 = Integer.parseInt(no);

		try {
			conn = getConnection();
			String sql = "update board set hit = hit + 1 where no = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, no1);

			pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteByNo(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "delete from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);

			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.177:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}

}
