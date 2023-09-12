package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.web.mvc.Action;

public class UpdateBoardOrReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		new BoardDao().updateTitleAndContentsByNo(title, contents, no);

		response.sendRedirect(request.getContextPath() + "/board?a=detailboardorreply&no=" + no + "&title=" + title
				+ "&contents=" + contents);

	}

}
