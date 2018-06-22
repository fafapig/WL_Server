package com.geek99.serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geek99.dao.OrderDao;
import com.geek99.dao.OrderDaoImpl;

/**
 * Servlet implementation class PaidServlet
 */
@WebServlet("/PaidServlet")
public class PaidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDao dao = new OrderDaoImpl();
		String stid = request.getParameter("tid");
		int tid = Integer.parseInt(stid);
		int r = dao.pay(tid);
		PrintWriter out = response.getWriter();	
		if(r==1){
			out.print("scuessjiesuan！");
		}else{
			out.print("failjiesun！");
		}
	}

}
