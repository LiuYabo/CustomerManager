package edu.xidain.cusmang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidain.cusmang.entity.Customer;
import edu.xidain.cusmang.service.CustomerService;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) request.getAttribute("id");
		
		CustomerService customerService = new CustomerService();

		try {
			customerService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("成功删除员工");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}

}