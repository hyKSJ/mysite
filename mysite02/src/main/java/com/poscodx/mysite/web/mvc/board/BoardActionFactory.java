package com.poscodx.mysite.web.mvc.board;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.ActionFactory;

public class BoardActionFactory implements ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("addboard".equals(actionName)) {
			action = new AddBoardAction();
		} else if ("addboardform".equals(actionName)) {
			action = new AddBoardFormAction();
		} else if ("addreply".equals(actionName)) {
			action = new AddReplyAction();
		} else if ("addreplyform".equals(actionName)) {
			action = new AddReplyFormAction();
		} else if ("detailboardorreply".equals(actionName)) {
			action = new DetailBoardOrReplyAction();
		} else if ("updateboardorreply".equals(actionName)) {
			action = new UpdateBoardOrReplyAction();
		} else if ("updateboardorreplyform".equals(actionName)) {
			action = new UpdateBoardOrReplyFormAction();
		} else if ("deleteboardorreply".equals(actionName)) {
			action = new DeleteBoardOrReplyAction();
		} else if ("deleteboardorreplyform".equals(actionName)) {
			action = new DeleteBoardOrReplyFormAction();
		} else {
			action = new ListAction();
		}

		return action;
	}
}
