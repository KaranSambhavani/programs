package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class EmpDaoImpl implements EmpDao {

	@Autowired
	JdbcTemplate template;
	
	public String save(final Emp e) {
		
		final String insert="insert into emp(empNo,name,city,salary) values(?,?,?,?)";
		int row=template.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				
			
				PreparedStatement pst=con.prepareStatement(insert);
				pst.setInt(1,e.getEmpId());
				pst.setString(2,e.getName());
				pst.setString(3,e.getCity());
				pst.setDouble(4,e.getSalary());
				return pst;
				
				
			}
		});
		
		 if(row>=1)
		 {
			 return "Data inserted";
		 }
		 else
		 {
			 return "Data is not inserted";
		 }
	}

	public Emp findById(int id) {
		
		Emp emp=template.queryForObject("select * from emp where empno="+id,new RowMapper<Emp>() {

			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}
		
			
		});
		return emp;
	}

	public List<Emp> getAll() {
		
		List<Emp> l=template.query("select * from emp",new RowMapper<Emp>() {
			
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}
		
		});
		
		return l;
	}

	public String deleteById(final int id) {
		
		final String sql="delete from emp where empno=?";
		
		int ans=template.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setInt(1,id);
				return pst;
			}
		});
		
		 if(ans>=1)
		 {
			 return "Data deleted";
		 }
		 else
		 {
			 return "Data is not deleted";
		 }
	}

	public String UpdateById(final int id) {
	
		final String sql="update emp set name=? where empNo=?";
	        
		int ans=template.update(new PreparedStatementCreator() {
				
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1,"Karan Sambhavani");
					pst.setInt(2, id);
					return pst;
				}
			});
		
		 if(ans>=1)
		 {
			 return "Data updated";
		 }
		 else
		 {
			 return "Data is not updated";
		 }
		
	
	}

}
