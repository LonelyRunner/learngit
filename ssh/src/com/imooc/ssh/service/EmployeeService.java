package com.imooc.ssh.service;

import com.imooc.ssh.domain.Employee;
import com.imooc.ssh.domain.PageBean;

/**
 * 业务层员工接口
 */
public interface EmployeeService {

    Employee login(Employee employee);

    PageBean<Employee> findByCurrentPage(int currentPage);

    void saveEmployee(Employee employee);

    Employee findEmployeeById(int eid);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
