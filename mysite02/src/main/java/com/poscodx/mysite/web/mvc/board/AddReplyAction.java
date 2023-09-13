package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;

public class AddReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String groupNo1 = request.getParameter("groupNo");
		String depth1 = request.getParameter("depth");
		String orderNo1 = request.getParameter("orderNo");
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		int groupNo = Integer.parseInt(groupNo1);
		int depth = Integer.parseInt(depth1);
		int orderNo = Integer.parseInt(orderNo1);
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setGroupNo(groupNo);
		vo.setDepth(depth);
		vo.setOrderNo(orderNo);
		vo.setUserNo(authUser.getNo());


		new BoardDao().insertreply(vo);

		response.sendRedirect(request.getContextPath() + "/board?begin=1&i=1");

	}

}
