package edu.xidain.cusmang.service;

import java.util.List;

import edu.xidain.cusmang.dao.CustomerDao;
import edu.xidain.cusmang.entity.Customer;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();
	
	public void add(Customer customer) throws Exception {
		customerDao.add(customer);
	}
	
	public void delete(String id) throws Exception {
		customerDao.delete(id);
	}
	
	public void updata(Customer customer) throws Exception {
		customerDao.updata(customer);
	}
	
	public Customer findById(String id) throws Exception {
		return customerDao.findById(id);
	}
	
	public List<Customer> findAll() throws Exception {
		return customerDao.findAll();
	}
	
	

}
