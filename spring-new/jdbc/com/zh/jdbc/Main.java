package com.zh.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class Main {

	private ApplicationContext ctx;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
		employeeDao = (EmployeeDao) ctx.getBean("employeeDao");
		departmentDao = (DepartmentDao) ctx.getBean("departmentDao");
	}

	/**
	 * 测试dataSource
	 * @throws SQLException
	 */
	@Test
	public void testConn() throws SQLException{
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

	/* ~~~~~~~~ insert ~~~~~~~ */

	/**
	 * 使用spring自带的JdbcTemplate来向数据库插入一条数据
	 */
	@Test
	public void testInsertARecord(){
		String sql = "insert into t_employee(employee_id,employee_name,employee_salary,employee_dept_id)"
				+ " values(7,?,?,?)";
		jdbcTemplate.update(sql,"jack",30000,3);
	}

	/**
	 * 使用spring自带的JdbcTemplate来向数据库插入多条数据
	 */
	@Test
	public void testInsertSomeRecords(){
		String sql = "insert into t_employee(employee_id,employee_name,employee_salary,employee_dept_id)"
				+ " values(?,?,?,?)";
		List<Object[]> batchArgs =  new ArrayList<Object[]>();

		batchArgs.add(new Object[]{8,"Lily",3000,4});
		batchArgs.add(new Object[]{9,"Mike",3000,1});
		batchArgs.add(new Object[]{10,"james",3000,2});

		jdbcTemplate.batchUpdate(sql,batchArgs);
	}

	/* ~~~~~~~~ update ~~~~~~~~ */

	/**
	 * 更新数据  插入时对应字段为string  --> 改为number
	 */
	@Test
	public void testUpdate(){
		String sql = "update t_employee set employee_salary=? where employee_id=?";

		jdbcTemplate.update(sql,3000,7);
	}


	/* ~~~~~~~~~ select ~~~~~~~~*/
	/**
	 * 查询一条数据
	 */
	@Test
	public void testQueryForObject(){
		String sql = "select employee_id employeeId,employee_name employeeName,employee_salary employeeSalary,"
				+ " employee_dept_id employeeDeptId from t_employee where employee_id=?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee e = jdbcTemplate.queryForObject(sql, rowMapper,2);
		System.out.println(e);
	}

	/**
	 * 查询多条数据
	 */
	@Test
	public void testQuery(){
		String sql = "select employee_id employeeId,employee_name employeeName,employee_salary employeeSalary,"
				+ " employee_dept_id employeeDeptId from t_employee where employee_id>?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql,rowMapper,5);
		System.out.println(employees);
	}

	/**
	 * 获取单个列的值
	 */
	@Test
	public void testQueryForObject2(){
		String sql = "select count(employee_id) from t_employee";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}

	/* ~~~~~~~~~~ NamedParameter ~~~~~~~~~ */
	@Test
	public void testNamedParameter1(){
		String sql = "insert into department(dept_id,name) values(:deptId,:name)";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("deptId", 5);
		map.put("name", "商务部");

		namedParameterJdbcTemplate.update(sql,map);
		System.out.println("插入一条数据成功~~~");
	}

	@Test
	public void testNamedParameter2(){
		String sql = "insert into department(dept_id,name) values(:deptId,:name)";
		Department department = new Department();
		department.setDeptId(6);
		department.setName("检验部");

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(department);
		namedParameterJdbcTemplate.update(sql,sqlParameterSource);
		System.out.println("又一条数据插入成功~~~");
	}

	@Test
	public void testEmployeeDao(){
		Employee employee = employeeDao.getEmployeeByid(4);
		System.out.println(employee);
	}

	@Test
	public void testDepartmentDao(){
		Department department = departmentDao.getDepartmentByName("财务部");
		System.out.println(department);
	}
}
