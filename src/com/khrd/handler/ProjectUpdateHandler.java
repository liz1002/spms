package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SPMSDAO;
import com.khrd.dto.SPMS;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class ProjectUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		if(req.getMethod().equalsIgnoreCase("get")) {
			int no = Integer.parseInt(req.getParameter("no"));
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				
				SPMSDAO dao = SPMSDAO.getInstance();
				SPMS spms = dao.projectDetail(conn, no);
				req.setAttribute("spms", spms);
				return "/WEB-INF/view/projectUpdateForm.jsp";	
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}			
		} else if(req.getMethod().equalsIgnoreCase("post")) {
			int no = Integer.parseInt(req.getParameter("no"));
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String progress = req.getParameter("progress");
			String startdate = req.getParameter("startdate");
			String enddate = req.getParameter("enddate");
			
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				SPMSDAO dao = SPMSDAO.getInstance();
				SPMS spms = new SPMS(no, name, content, startdate, enddate, progress);
				dao.updateProject(conn, spms);
				resp.sendRedirect(req.getContextPath() + "/detail.do?no=" + no);
				return null;
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}
}
