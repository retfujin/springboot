package com.zkbr.mystudy.jspservletjdbc.controller;

import com.zkbr.mystudy.jspservletjdbc.dao.SanatoriumDao;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sanatorium")
public class UserSanatoriumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanatoriumDao sanatoriumDao;
	private static String MAIN_JSP = "/main.jsp";
	private static String CONTENT = "/user.jsp";
	
    public UserSanatoriumController() {
        super();
        sanatoriumDao = new SanatoriumDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		request.setAttribute("title", "这个是一个例子");
		request.setAttribute("content", CONTENT);
		request.setAttribute("sanatorium", sanatoriumDao.getAllHousing());
		
		if (null != action) {
			if (action.equalsIgnoreCase("srp")) {
				int housingId = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("content", "/details.jsp");
				request.setAttribute("title", "这个是一个例子");
				request.setAttribute("discription", sanatoriumDao.getDescriptionByHousingId(housingId));
			} else if(action.equalsIgnoreCase("sn")) {
//				int number = Integer.parseInt(request.getParameter("number"));
//				request.setAttribute("content", "/details.jsp");
//				request.setAttribute("title", "这个是一个例子" + number);
//				request.setAttribute("discription", sanatoriumDao.getQuantityByNumber(number));
			} else {}
		}
		
		RequestDispatcher view = request.getRequestDispatcher(MAIN_JSP);
		view.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
