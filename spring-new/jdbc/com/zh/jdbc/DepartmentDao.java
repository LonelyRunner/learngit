package com.zh.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Department getDepartmentByName(String name){
		
		String sql = "select dept_id deptId,name name from department where name = ?";
		RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
		Department department = jdbcTemplate.queryForObject(sql, rowMapper,name);
		return department;
	}
}
