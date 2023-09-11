package com.poscodx.mysite.web.mvc.guestbook;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.GuestbookDao;
import com.poscodx.mysite.vo.GuestbookVo;
import com.poscodx.web.mvc.Action;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String message = request.getParameter("message");

		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());

		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		vo.setDate(date);

		new GuestbookDao().insert(vo);

		response.sendRedirect(request.getContextPath() + "/guestbook");

	}

}
