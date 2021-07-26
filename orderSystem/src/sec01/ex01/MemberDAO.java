package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.net.aso.l;

public class MemberDAO {
	
		private Connection con;
		private PreparedStatement pstmt;
		private DataSource dataFactory;

		public MemberDAO() {
			try {
				Context ctx = new InitialContext();
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
public List<MemberVO> listMembers(){
	List<MemberVO> membersList = new ArrayList<MemberVO>();
	try {
		con=dataFactory.getConnection();
		String query = "select * from ts_member";
		System.out.println(query);
		pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String ts_id = rs.getString("ts_id");
			String ts_pwd = rs.getString("ts_pwd");
			String ts_bdname = rs.getString("ts_bdname");
			String ts_bdno = rs.getString("ts_bdno");
			String ts_phone = rs.getString("ts_phone");
			MemberVO memberVO = new MemberVO(ts_id, ts_pwd, ts_bdname, ts_bdno, ts_phone);
			membersList.add(memberVO);
		}
		rs.close();
		pstmt.close();
		con.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return membersList;
}
public void addMember(MemberVO vo) {
	try {
		con=dataFactory.getConnection();
		String ts_id = vo.getTs_id();
		String ts_pwd = vo.getTs_pwd();
		String ts_bdname = vo.getTs_bdname();
		String ts_bdno = vo.getTs_bdno();
		String ts_phone = vo.getTs_phone();
		String query = "INSERT INTO ts_member";
		query += " (ts_id,ts_pwd,ts_bdname,ts_bdno,ts_phone)";
		query += " values(?,?,?,?,?)";
		System.out.println(query);
		pstmt=con.prepareStatement(query);
		pstmt.setString(1, ts_id);
		pstmt.setString(2, ts_pwd);
		pstmt.setString(3, ts_bdname);
		pstmt.setString(4, ts_bdno);
		pstmt.setString(5, ts_phone);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

	public Boolean loginCheck(MemberVO vo) {
		boolean result = false;
		String id = vo.getTs_id();
		String pwd = vo.getTs_pwd();
		try {
		con=dataFactory.getConnection();
		
		String query = "select decode(count(*),1,'true','false') as result from ts_member";
				query += " where ts_id=? and ts_pwd=?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		result = Boolean.parseBoolean(rs.getString("result"));
		System.out.println("result =" + result);
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return result;
	}
	public void delMember(String ts_id) {
		try {
			con = dataFactory.getConnection();
			String query = "delete from ts_member";
				query += " where ts_id=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ts_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public MemberVO findMember(String _id) {
		MemberVO memInfo = null;
		try {
			con=dataFactory.getConnection();
			String query = "select * from ts_member";
					query +=  " where ts_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(query);
			ResultSet rs =pstmt.executeQuery();
			rs.next();
			String ts_id = rs.getString("ts_id");
			String ts_pwd = rs.getString("ts_pwd");
			String ts_bdname = rs.getString("ts_bdname");
			String ts_bdno = rs.getString("ts_bdno");
			String ts_phone = rs.getString("ts_phone");
			memInfo = new MemberVO(ts_id, ts_pwd, ts_bdname, ts_bdno, ts_phone);
			pstmt.close();
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return memInfo;
	}
	public void modMember(MemberVO memberVO) {
		String ts_id = memberVO.getTs_id();
		String ts_pwd = memberVO.getTs_pwd();
		String ts_bdname = memberVO.getTs_bdname();
		String ts_bdno = memberVO.getTs_bdno();
		String ts_phone = memberVO.getTs_phone();
		try {
			con=dataFactory.getConnection();
			String query = "update ts_member set ts_pwd=?,ts_bdname=?,ts_bdno=?,ts_phone=?";
					query += " where ts_id=?";
			System.out.println(query);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, ts_pwd);
			pstmt.setString(2, ts_bdname);
			pstmt.setString(3, ts_bdno);
			pstmt.setString(4, ts_phone);
			pstmt.setString(5, ts_id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}
	
	
}



