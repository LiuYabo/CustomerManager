package edu.xidian.service;

import java.util.List;

import edu.xidian.dao.CustomerDao;
import edu.xidian.domain.Customer;
import edu.xidian.domain.QueryInfo;
import edu.xidian.domain.QueryResult;
import edu.xidian.domain.pageBean;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();

	public void delete(String id) {
		customerDao.delete(id);
	}
	
	public void add(Customer customer) {
	    customerDao.add(customer);
	}
	
	public Customer findById(String id) {
		return customerDao.findById(id);
	}
	/*
	public boolean check(Customer customer) {
		customerDao.check().
		return customerDao.check(customer);
	}
	*/
	public List<Customer> findAll() {
		return customerDao.fingAll();
	}
	
	public pageBean pageQuery(QueryInfo qi) {
		
		QueryResult qs = customerDao.pageQuery(qi.getStartIndex(), qi.getPageSize());
		pageBean pb = new pageBean();
		pb.setCurrentPage(qi.getCurrentPage());
		pb.setList(qs.getList());
		pb.setPageSize(qi.getPageSize());
		pb.setTotalRecord(qs.getTotalRecord());
		pb.setTotalPage();
// 		pb.setPagebar();
		return pb;

	}
}
