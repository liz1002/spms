package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SPMSDAO;
import com.khrd.dto.SPMS;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class ProjectDetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			SPMSDAO dao = SPMSDAO.getInstance();
			SPMS spms = dao.projectDetail(conn, no);
			req.setAttribute("spms", spms);
			return "/WEB-INF/view/projectDetail.jsp";
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}
}
