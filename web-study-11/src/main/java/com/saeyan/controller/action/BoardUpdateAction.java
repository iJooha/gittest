package com.saeyan.controller.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.BoardVO;
import com.seayan.dao.BoardDAO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException, ServletException {
		BoardVO bvo = new BoardVO();
		
		bvo.setNum(Integer.parseInt(request.getParameter("num")));
		bvo.setName(request.getParameter("name"));
		bvo.setPass(request.getParameter("pass"));
		bvo.setEmail(request.getParameter("email"));
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		
		BoardDAO bdao = BoardDAO.getInstance();
		bdao.updateBoard(bvo);
		
		new BoardListAction().execute(request, response);
		
	}

}
