package edu.xidian.web;

import java.util.HashMap;

import edu.xidian.domain.Customer;

public class Check {
	
	public static HashMap errors = new HashMap();
	public static boolean check(Customer customer) {
		
		boolean isOK = true;
		
		
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
		}
		if (customer.getEmail()== null || customer.getEmail().trim().equals("")) {
			isOK = false;
			errors.put("email", "邮箱不可为空");
		} else if (!customer.getEmail().matches("\\w+@\\w+(\\.\\w+)+")) {
			isOK = false;
			errors.put("email", "邮箱不符合格式");
		}
	
		if (customer.getDescription() == null || customer.getDescription().trim().equals("")) {
			isOK = false;
		}
		return isOK;
		
	}
	

}
