package edu.xidian.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.sql.PreparedStatement;

import edu.xidian.domain.Customer;
import edu.xidian.domain.QueryResult;
import edu.xidian.util.JdbcUtil;

public class CustomerDao {
	
	
	public void delete(String id)
	{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
	try {	
			
		conn = JdbcUtil.getConnection();
		
		String sql = "delete from t_customer where id =" +id ;
		st = conn.createStatement();
		int num = st.executeUpdate(sql);
		if (num>0) {
			System.out.println("deletedao success");
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, st, rs);
		}
		
	}
	/*
	public boolean check(Customer customer) {
		boolean isOK = true;
		HashMap errors = new HashMap();
		
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
		
	}*/
	
	public void add(Customer customer) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn =JdbcUtil.getConnection();
			String sql = "insert into t_customer (id, name, gender, phone, email, description) values (?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			
			st.setString(1, customer.getId());
			st.setString(2, customer.getName());
			st.setString(3, customer.getGender());
			st.setString(4, customer.getPhone());
			st.setString(5, customer.getEmail());
			st.setString(6, customer.getDescription());
			
			int num = st.executeUpdate();
			if (num > 0) {
				System.out.println("add_success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, st, rs);
		}
		
	}
	
	
	public Customer findById(String id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Customer customer = new Customer();
		System.out.println("this is dao");
		
		try {
			conn =JdbcUtil.getConnection();
			String sql = "select * from t_customer where id =" + id;
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setPhone(rs.getString("phone"));
				customer.setEmail(rs.getString("email"));
				customer.setDescription(rs.getString("description"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {

			JdbcUtil.close(conn, st, rs);
		}
		return customer;
	
	}
	
	public List<Customer> fingAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn =JdbcUtil.getConnection();
			String sql = "select * from t_customer";
			st = conn.createStatement();

			rs = st.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setPhone(rs.getString("phone"));
				customer.setEmail(rs.getString("email"));
				customer.setDescription(rs.getString("description"));
				
				list.add(customer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, st, rs);
		}
		return list;
		
	}
	
	public QueryResult pageQuery(int startIndex, int pageSize) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		QueryResult qr = new QueryResult();
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from t_customer limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, startIndex);
			st.setInt(2, pageSize);
			rs = st.executeQuery();
			List list = new ArrayList();
		
			
			while (rs.next()) {
				Customer customer = new Customer();
				
				customer.setId(rs.getString("Id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setPhone(rs.getString("phone"));
				customer.setEmail(rs.getString("email"));
				customer.setDescription(rs.getString("description"));
				
			
				list.add(customer);
			}
			qr.setList(list);
			
			String sqlcount = "select * from t_customer";
			st = conn.prepareStatement(sqlcount);
			rs = st.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}
			qr.setTotalRecord(count);	
			return qr;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, st, rs);
		}
		return qr;	
	}
	
	
}
