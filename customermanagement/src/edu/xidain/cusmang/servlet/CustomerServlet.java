package edu.xidain.cusmang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidain.cusmang.entity.Customer;
import edu.xidain.cusmang.service.CustomerService;

@WebServlet("/CustomerServlet")

public class CustomerServlet extends HttpServlet {
	public CustomerService  customerService= new CustomerService();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("findId");
		
		String method = (String) request.getAttribute("method");
		
		/*
		if (method.equals("add")) {
			try {
				add(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("msg", "成功录入员工信息");
			this.getServletContext().getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		}
		
		if (method.equals("delete")) {
			try {
				delete(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("msg", "成功删除员工信息");
			this.getServletContext().getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		}
		if (method.equals("updata")) {
			try {
				updata(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("msg", "成功更新员工信息");
			this.getServletContext().getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		}
		
		*/
//		if (method.equals("findId")) {
			Customer customer = new Customer();
			try {
				
				customer = findById(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	//		System.out.println(customer.getEmail().toString());

			request.setAttribute("customer", customer);
			this.getServletContext().getRequestDispatcher("/msgFindId.jsp").forward(request, response);
			
//		}
		
		/*
		if (method.equals("findAll")) {
			List<Customer> list = new ArrayList<Customer>();
			try {
				list = findAll(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("customerList", list);
			this.getServletContext().getRequestDispatcher("/msgFindId.jsp").forward(request, response);
		}
		
		*/
		


	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Customer customer = new Customer();
		
		customer.setDescription((String)request.getAttribute("description"));
		customer.setEmail((String)request.getAttribute("email"));
		customer.setGender((String)request.getAttribute("gender"));
		customer.setId((String)request.getAttribute("id"));
		customer.setName((String)request.getAttribute("name"));
		customer.setPhone((String)request.getAttribute("phone"));
		
		customerService.add(customer);
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = (String) request.getAttribute("id");
		customerService.delete(id);	
	}
	
	public void updata(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Customer customer = new Customer();
		
		customer.setDescription((String)request.getAttribute("description"));
		customer.setEmail((String)request.getAttribute("email"));
		customer.setGender((String)request.getAttribute("gender"));
		customer.setId((String)request.getAttribute("id"));
		customer.setName((String)request.getAttribute("name"));
		customer.setPhone((String)request.getAttribute("phone"));
		
		customerService.updata(customer);
	}
	
	public Customer findById (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = (String) request.getAttribute("id");
		System.out.println(id);
		return customerService.findById(id);
	}
	

	public List<Customer> findAll (HttpServletRequest request, HttpServletResponse response) throws Exception {
		return customerService.findAll();
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
