package com.poscodx.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.util.WebUtil;

public class JoinFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		WebUtil.forward("user/joinform", request, response);
	}
}