package com.zkbr.mystudy.jspservletjdbc.controller;

import com.zkbr.mystudy.jspservletjdbc.dao.UserDao;
import com.zkbr.mystudy.jspservletjdbc.model.User;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String MAIN_JSP = "/main.jsp";
    private static String LOGIN_FORM = "/login.jsp";
    private UserDao userDao;
	
    public LoginController() {
        super();
        userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "登录管理面板");
		request.setAttribute("content", LOGIN_FORM);

		
		RequestDispatcher view = request.getRequestDispatcher(MAIN_JSP);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userDao.getUser(username, password);
		
		if(user != null) {
			request.getSession().setAttribute("userInfo", user);
			request.getSession().setMaxInactiveInterval(1800);
			response.sendRedirect(request.getContextPath() + "/manager");
		} else {
			request.setAttribute("error", "用户名或密码错误!");
			doGet(request, response);
		}
	}
}
