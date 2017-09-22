package edu.xidian.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidian.domain.Customer;
import edu.xidian.service.CustomerService;
import edu.xidian.web.Check;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	CustomerService customerService = new CustomerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("this is servlet");
		
		Customer customer = new Customer();
		
		customer.setId(request.getParameter("id"));
		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));
		customer.setDescription(request.getParameter("description"));
		
		
		if (customerService.findById(customer.getId()).getId() != null) {
			request.getSession().removeAttribute("customer");
			request.setAttribute("msg", "该客户已存在，请直接登入");
			request.getRequestDispatcher("/exist.jsp").forward(request, response);
			return;
		}
		
	/*
		if (Check.check(customer)) {
			request.setAttribute("check", Check.errors);
			for ( int i = 0;!Check.errors.isEmpty();i++) {
				Check.errors.re
			}
			request.getRequestDispatcher("/add.jsp").forward(request, response);
		}*/
		
		customerService.add(customer);
		
		request.setAttribute("msg", "成功添加员工");
		this.getServletContext().getRequestDispatcher("/msg.jsp").forward(request, response);
		return;
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
