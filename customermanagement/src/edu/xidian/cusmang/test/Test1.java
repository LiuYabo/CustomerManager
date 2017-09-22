package edu.xidian.cusmang.test;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import edu.xidain.cusmang.dao.CustomerDao;
import edu.xidain.cusmang.dao.CustomerDao;
import edu.xidain.cusmang.entity.Customer;
import edu.xidian.cusmang.utils.JdbcUtils;




public class Test1 {
	
 	
 

	@Test
	public void test1() throws Exception {
 
	
     	Customer c1 = new Customer("1id","1name","1gender","1phone","1email","1description");
  		Customer c2 = new Customer("2id","2name","2gender","2phone","2email","2description");
 
		Customer c3 = new Customer("3id","3name","3gender","3phone","3email","3description");

 		
 		//System.out.println(c1.getDescription().toString());
 		
		
		CustomerDao cd = new CustomerDao();
 	
 		cd.add(c3);
    	System.out.println("测试完毕");
 
 	}
	
	@Test
    	public void test2() throws Exception {
		CustomerDao cd = new CustomerDao();
	 	
 		cd.delete("1");
    	System.out.println("测试完毕");

    	}
	@Test
	public void findId() throws Exception {
		CustomerDao cd = new CustomerDao();
	 	Customer c = null;
 		c = cd.findById("3");
 		System.out.println(c.getEmail());
    	System.out.println("测试完毕");
	}
	
	
	@Test
	public void findAll() throws Exception {
		CustomerDao cd = new CustomerDao();
	 	List<Customer> c = cd.findAll();
 		
 		for (Customer cs : c) {
 			System.out.println(cs.getDescription());
 		}
 		
 			
 		
 		
    	System.out.println("测试完毕");
	}
	
	@Test
	public void updata() throws Exception {
		CustomerDao cd = new CustomerDao();
		Customer c3 = new Customer();
		c3.setDescription("66");
		c3.setEmail("55");
		c3.setGender("44");
		c3.setId("3");
		c3.setName("22");
		c3.setPhone("33");
//	 	 c3 = new Customer("3","3","3g","3phone","3email","3description");
 		cd.updata(c3);
// 		System.out.println(c.getEmail());
    	System.out.println("测试完毕");
	}
	
	



}
