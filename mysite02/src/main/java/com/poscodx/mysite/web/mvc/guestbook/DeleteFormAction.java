package com.poscodx.mysite.web.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.util.WebUtil;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		request.setAttribute("no", no);
		WebUtil.forward("guestbook/deleteform",request, response);

	}

}
