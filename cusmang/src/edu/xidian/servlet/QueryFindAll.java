package edu.xidian.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.xidian.domain.QueryInfo;
import edu.xidian.domain.pageBean;
import edu.xidian.service.CustomerService;


@WebServlet("/QueryFindAll")
public class QueryFindAll extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryInfo qi = new QueryInfo();
		pageBean pb = new pageBean();
		System.out.println(request.getParameter("currentpage"));
		/*if (request("currentpage") != null) {
			qi.setCurrentPage((int)request.getParameter("currentpage"));
		}*/
		if (request.getParameter("currentpage") != null) {
			qi.setCurrentPage( Integer.parseInt((String)request.getParameter("currentpage")));
		}
		
		CustomerService customerService = new CustomerService();
		pb = customerService.pageQuery(qi);
		
		int [] bar = new int[pb.getTotalPage()];
		for (int i = 0; i < pb.getTotalPage(); i++) {
			bar[i] = i + 1;
		}
		
		//response.setHeader("refresh", "15");
		

		request.setAttribute("pagebean", pb);
		request.setAttribute("bar", bar);
		request.getRequestDispatcher("/QueryFindAll.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
