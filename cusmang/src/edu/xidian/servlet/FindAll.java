package edu.xidian.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidian.domain.Customer;
import edu.xidian.service.CustomerService;


@WebServlet("/FindAll")
public class FindAll extends HttpServlet {
		CustomerService customerService = new CustomerService();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("refresh", "20");
		List<Customer> list = new ArrayList<Customer>();
		list = customerService.findAll();
		request.setAttribute("list", list);
		System.out.println("this is servlet");
		request.getRequestDispatcher("/FindAll.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
