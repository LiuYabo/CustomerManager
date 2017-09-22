package edu.xidain.cusmang.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import edu.xidian.cusmang.utils.JdbcUtils;
import edu.xidain.cusmang.entity.Customer;

public class CustomerDao {


	public void add(Customer customer) throws Exception {
		Connection conn = null;
		java.sql.PreparedStatement  st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();

 // 			String sql = "insert into t_customer(id, name, gender, phone, email, description) ;
			String sql = "insert into t_customer(id, name, gender, phone, email, description)"
  					+ " values(?,?,?,?,?,?)";

			//String sql = "insert into t_customer (id, name, gender, phone, email, description) values("+customer.getId()+"','"+customer.getName()+"','"+customer.getGender()+"','"+customer.getPhone()+"','"+customer.getEmail()+"','"+customer.getDescription()+"')'";
 			st =  conn.prepareStatement(sql);
 			//st = conn.createStatement();
 			/*
 			st.setString(1, customer.getId());
 			st.setString(2, customer.getName());
 			st.setString(3, customer.getGender());
 			st.setString(4, customer.getPhone());
 			st.setString(5, customer.getEmail());
 			st.setString(6, customer.getDescription());
 			*/
 			
// 			String sql = "insert into t_customer(id, name, gender, phone, email, description)"
// 					+ " values('4','2','3','4','5','6')";
			int num = st.executeUpdate(sql);
		 		
			if (num > 0) {
				System.out.println("成功插入"+ num +"条员工信息");
			}
		} finally {
			JdbcUtils.close(conn, st, rs);
			
		}

	}

	
	public void delete(String id) throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String customerId =id;
			String sql = "delete from t_customer where id = "+customerId;
			int num = st.executeUpdate(sql);
		 		
			if (num > 0) {
				System.out.println("成功删除"+ num +"条员工信息");
			}
		} finally {
			JdbcUtils.close(conn, st, rs);
			
		}
		
	}
	
	public void updata(Customer customer) throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			
			String cid = customer.getId();
			String sql = "update t_customer set name = " +customer.getName()+", gender = " +customer.getGender()+ ", phone = "+customer.getPhone()
					+ "email = "+customer.getEmail()+", description = "+ customer.getDescription() +" where id =" +cid;


			int num = st.executeUpdate(sql);
		 		
			if (num > 0) {
				System.out.println("成功更新"+ num +"条员工信息");
			}
		} finally {
			JdbcUtils.close(conn, st, rs);
			
		}
	}
	
	public Customer findById (String id) throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			
			String sql = "select * from t_customer where id ="+id;
			st = conn.createStatement();

			rs = st.executeQuery(sql);
		 		
			if (rs.next()) {
				Customer customer = new Customer();
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setPhone(rs.getString("phone"));
				customer.setEmail(rs.getString("email"));
				customer.setDescription( rs.getString("description"));

				return customer;
			}
		} finally {
			JdbcUtils.close(conn, st, rs);
			
		}
		
		
		return null;
	}
	

	public List<Customer> findAll() throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		
		try {
			List<Customer> list = new ArrayList<Customer> ();
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "select * from t_customer";
			rs = st.executeQuery(sql);
		
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId((String) rs.getObject("id"));				
				customer.setName((String) rs.getObject("name"));
				customer.setGender((String) rs.getObject("gender"));
				customer.setPhone((String) rs.getObject("phone"));
				customer.setEmail((String) rs.getObject("email"));
				customer.setDescription((String) rs.getObject("description"));

				list.add(customer);
			}
			return list;
			
		} finally {
			
			JdbcUtils.close(conn, st, rs);
			
		}
	}
	
	
	
	
	
	
	
	
	
	

}
