package com.geek99.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geek99.dao.User;
import com.geek99.dao.UserDao;
import com.geek99.dao.UserDaoImpl;
import com.google.gson.Gson;

import java.io.PrintWriter;
/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+","+password);
		
		System.out.println("do post");
		
		UserDao dao = new UserDaoImpl();
		User u = dao.login(username,password);
		PrintWriter out = response.getWriter();
		if(u!=null){
			//使用gson
			Gson gson = new Gson();
			
			String json = gson.toJson(u);
			out.print(json);
			System.out.println(json);
			//out.print("login sucess");
		}else{
			out.print("-1");
		}
	}

}
