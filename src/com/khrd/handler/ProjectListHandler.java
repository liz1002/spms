package com.khrd.handler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SPMSDAO;
import com.khrd.dto.SPMS;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class ProjectListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			SPMSDAO dao = SPMSDAO.getInstance();
			List<SPMS> list = dao.projectList(conn);
			req.setAttribute("list", list);
			return "/WEB-INF/view/projectList.jsp";
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}
}
