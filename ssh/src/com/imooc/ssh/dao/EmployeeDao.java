package com.imooc.ssh.dao;

import com.imooc.ssh.domain.Employee;
import org.springframework.jdbc.support.lob.TemporaryLobCreator;

import java.util.List;

/**
 * Dao层员工接口
 */
public interface EmployeeDao {

    Employee findEmployeeByUsernameAndPassword(Employee employee);

    int findCount();

    List<Employee> findByPage(int begin,int pageSize);

    void saveEmployee(Employee employee);

    Employee findEmployeeById(int eid);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
