package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.khrd.dto.SPMS;
import com.khrd.jdbc.JDBCUtil;

public class SPMSDAO {
	private static final SPMSDAO dao = new SPMSDAO();
	
	public static SPMSDAO getInstance() {
		return dao;
	}
	
	public SPMSDAO() {}
	
	public List<SPMS> projectList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from spms";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<SPMS> list = new ArrayList<>();
			while(rs.next()) {
				SPMS spms = new SPMS(
								rs.getInt("no"),
								rs.getString("name"),
								rs.getString("content"),
								rs.getString("startdate"),
								rs.getString("enddate"),
								rs.getString("progress"));
				list.add(spms);
			}
			return list;		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return null;
	}//projectList
	
	public SPMS projectDetail(Connection conn, int no){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from spms where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				SPMS spms = new SPMS(
								rs.getInt("no"),
								rs.getString("name"),
								rs.getString("content"),
								rs.getString("startdate"),
								rs.getString("enddate"),
								rs.getString("progress"));
				return spms;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return null;
	}//projectDetail
	
	public int insertProject(Connection conn, SPMS spms) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into spms values(null, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, spms.getName());
			pstmt.setString(2, spms.getContent());
			pstmt.setString(3,spms.getStartdate());
			pstmt.setString(4, spms.getEnddate());
			pstmt.setString(5, spms.getProgress());
			return pstmt.executeUpdate();		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}//insertProject
	
	public int updateProject(Connection conn, SPMS spms) { 
		PreparedStatement pstmt = null;
		try {
			String sql = "update spms set name=?, content=?, startdate=?, enddate=?, progress=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, spms.getName());
			pstmt.setString(2, spms.getContent());
			pstmt.setString(3,spms.getStartdate());
			pstmt.setString(4, spms.getEnddate());
			pstmt.setString(5, spms.getProgress());
			pstmt.setInt(6, spms.getNo());
			return pstmt.executeUpdate();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}//updateProject
	
	
	
}
