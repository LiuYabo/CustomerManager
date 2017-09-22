package edu.xidian.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidian.domain.Customer;
import edu.xidian.service.CustomerService;


@WebServlet("/FindById")
public class FindById extends HttpServlet {
	
	CustomerService customerService = new CustomerService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Customer customer = customerService.findById(id);
		System.out.println(customer.getEmail());
		
		request.setAttribute("customer", customer);
		
		request.getRequestDispatcher("/FindById.jsp").forward(request, response);;
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
