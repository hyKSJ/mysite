package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.util.WebUtil;

public class AddReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String groupNo = request.getParameter("groupNo");
		String depth = request.getParameter("depth");
		String orderNo = request.getParameter("orderNo");
		request.setAttribute("no", no);
		request.setAttribute("title", title);
		request.setAttribute("contents", contents);
		request.setAttribute("groupNo", groupNo);
		request.setAttribute("depth", depth);
		request.setAttribute("orderNo", orderNo);
		
		WebUtil.forward("board/writereply",request, response);

	}

}
