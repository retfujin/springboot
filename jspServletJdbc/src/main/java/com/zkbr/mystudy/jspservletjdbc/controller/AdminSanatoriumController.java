package com.zkbr.mystudy.jspservletjdbc.controller;

import com.zkbr.mystudy.jspservletjdbc.dao.SanatoriumDao;
import com.zkbr.mystudy.jspservletjdbc.model.Product;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/manager") 
public class AdminSanatoriumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String MAIN_JSP = "/main.jsp";
	private static String CONTENT = "/admin.jsp";
	private SanatoriumDao sanatoriumDao;
	
    public AdminSanatoriumController() {
    	super();
    	sanatoriumDao = new SanatoriumDao();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		request.setAttribute("title", "这个是一个例子");
		request.setAttribute("content", CONTENT);
		request.setAttribute("sanatorium", sanatoriumDao.getAllHousing());
		
		if(null != action) {
			if(action.equalsIgnoreCase("add")) {
				request.setAttribute("title", "这个是一个例子");
				request.setAttribute("content", "/add.jsp");
				request.setAttribute("structure", sanatoriumDao.getStructure());
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher(MAIN_JSP);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Product housing = new Product();
		
		String structureId = request.getParameter("sid");
		if(structureId == null || structureId.isEmpty()) {
			Product structure = new Product();
			structure.setProTypeName(request.getParameter("cname"));
			housing.setProTypeId(sanatoriumDao.addCorps(structure));			
		} else {
			housing.setProTypeId(Integer.parseInt(structureId));
		}
		String number = request.getParameter("number");
		if (number == null || number.isEmpty()) {
			housing.setNumber(0);
		} else {
			housing.setNumber(Integer.parseInt(number));
		}
		
		String model = request.getParameter("model");
		if (model == null || model.isEmpty()) {
			housing.setModel("无");
		} else {
			housing.setModel(model);
		}
				
		String proName = request.getParameter("proName");
		if(proName == null || proName.isEmpty()){
			housing.setProName("");
		} else {
			housing.setProName(proName);
		}
		
		String proRemark = request.getParameter("proRemark");
		if(proRemark == null || proRemark.isEmpty()) {
			housing.setProRemark("");
		} else {
			housing.setProRemark(proRemark);
		}
		
		sanatoriumDao.addDiscription(housing);		
		
		response.sendRedirect(request.getContextPath() + request.getServletPath());
	}

}
