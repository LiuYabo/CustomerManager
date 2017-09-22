package edu.xidian.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidian.domain.Customer;
import edu.xidian.service.CustomerService;

@WebServlet("/addCheck")
public class addCheck extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CustomerService customerService = new CustomerService();
		Customer customer = new Customer();
		
		customer.setId(request.getParameter("id"));
		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));
		customer.setDescription(request.getParameter("description"));
		
		HashMap errors = new HashMap();

		boolean isOK = true;
			
		if (customerService.findById(customer.getId()).getId() != null) {
			request.getSession().removeAttribute("customer");
			request.setAttribute("msg", "该客户已存在，请直接登入");
			request.getRequestDispatcher("/exist.jsp").forward(request, response);
			return;
		}
		
			//校验输入合法性
		if (customer.getId() == null || customer.getId().trim().equals("")) {
				isOK = false;
				errors.put("Id", "Id不可为空");
			} else if (!customer.getId().matches("\\d{1,5}")) {
				isOK = false;
				errors.put("Id", "Id必须为1~5位的数字");
			}
			if (customer.getName() == null || customer.getName().trim().equals("")) {
				isOK = false;
				errors.put("Name", "客户名不可为空");
			} else if (!customer.getName().matches("[A-Za-z]{1,8}")) {
				isOK = false;
				errors.put("Name", "客户名必须为1~8位的字母");
			}
			if (customer.getPhone() == null || customer.getPhone().trim().equals("")) {
				isOK = false;
				errors.put("phone", "手机不可为空");
			} else if (!customer.getPhone().matches("\\d{11}")) {
				isOK = false;
				errors.put("phone", "手机号码有误");
			}
			if (customer.getEmail()== null || customer.getEmail().trim().equals("")) {
				isOK = false;
				errors.put("email", "邮箱不可为空");
			} else if (!customer.getEmail().matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "邮箱不符合格式");
			}
		
			if (isOK == false) {
				request.setAttribute("check", errors);
				request.getRequestDispatcher("/add.jsp").forward(request, response);
				return;
			}
			

			else {
				customerService.add(customer);
				
				request.setAttribute("msg", "成功添加员工");
				this.getServletContext().getRequestDispatcher("/msg.jsp").forward(request, response);
				return;
			}
			
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
