package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SPMSDAO;
import com.khrd.dto.SPMS;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class ProjectInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/projectInsertForm.jsp";
		} else if(req.getMethod().equalsIgnoreCase("post")) {
			req.setCharacterEncoding("utf-8");
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String progress = req.getParameter("progress");
			String startdate = req.getParameter("startdate");
			String enddate = req.getParameter("enddate");
			
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				
				SPMSDAO dao = SPMSDAO.getInstance();
				SPMS spms = new SPMS(0, name, content, startdate, enddate, progress);
				dao.insertProject(conn, spms);
				
				resp.sendRedirect(req.getContextPath() + "/list.do");
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
