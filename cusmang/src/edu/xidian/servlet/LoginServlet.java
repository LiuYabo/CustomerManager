package edu.xidian.servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidian.domain.Customer;
import edu.xidian.service.CustomerService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	CustomerService customerService = new CustomerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String referer = request.getHeader("referer");
		if (referer == null || !referer.startsWith("http://")) {
			response.sendRedirect("/cusmang/index.jsp");
		}
		
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		
		
		List<Customer> list = new ArrayList<Customer> ();
		list = customerService.findAll();
		
		for(Customer c : list) {
			if (c.getId().equals(id) && c.getEmail().equals(email)) {
				request.getSession().setAttribute("customer", c);
				System.out.println(c);
				response.sendRedirect("/cusmang/LoginSuccess.jsp");
				return;
			}
		}
		request.setAttribute("msg", "用户名或密码错误");
		response.sendRedirect("/cusmang/Login2.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
