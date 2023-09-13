package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.util.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String begin = request.getParameter("begin");
		String i = request.getParameter("i");
		int page = Integer.parseInt(i);
		
		List<BoardVo> list = new BoardDao().findAll(page);
		
		request.setAttribute("list", list);
		request.setAttribute("begin", begin);
		WebUtil.forward("board/list",request, response);

	}

}