package edu.xidian.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidian.service.CustomerService;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	CustomerService customerService = new CustomerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid = (String) request.getParameter("id");
		System.out.println(cid);
		customerService.delete(cid);
		
		System.out.println("arrive servlet");
		request.setAttribute("msg", "成功删除用户");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);;
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
