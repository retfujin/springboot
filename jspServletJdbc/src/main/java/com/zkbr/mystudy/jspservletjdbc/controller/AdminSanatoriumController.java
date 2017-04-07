package com.zkbr.mystudy.jspservletjdbc.controller;

import com.zkbr.mystudy.jspservletjdbc.dao.SanatoriumDao;
import com.zkbr.mystudy.jspservletjdbc.model.Sanatorium;
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
		Sanatorium housing = new Sanatorium();
		
		String structureId = request.getParameter("sid");
		if(structureId == null || structureId.isEmpty()) {
			Sanatorium structure = new Sanatorium();
			structure.setCorpsName(request.getParameter("cname"));
			housing.setStructureId(sanatoriumDao.addCorps(structure));			
		} else {
			housing.setStructureId(Integer.parseInt(structureId));
		}
		String number = request.getParameter("number");
		if (number == null || number.isEmpty()) {
			housing.setNumber(0);
		} else {
			housing.setNumber(Integer.parseInt(number));
		}
		
		String quantity = request.getParameter("quantity");
		if (quantity == null || quantity.isEmpty()) {
			housing.setQuantity(0);
		} else {
			housing.setQuantity(Integer.parseInt(quantity));
		}
				
		String recreation = request.getParameter("recreation");
		if(recreation == null || recreation.isEmpty()){
			housing.setRecreation(null);
		} else {
			housing.setRecreation(recreation);
		}
		
		String procedures = request.getParameter("procedures");
		if(procedures == null || procedures.isEmpty()) {
			housing.setProcedures(null);
		} else {
			housing.setProcedures(procedures);
		}
		
		sanatoriumDao.addDiscription(housing);		
		
		response.sendRedirect(request.getContextPath() + request.getServletPath());
	}

}
