package edu.xidian.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlettest")
public class servlettest extends HttpServlet implements SingleThreadModel {
	int i = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		i++;
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		System.out.println(i);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
