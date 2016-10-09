package com.imooc.ssh.dao;

import com.imooc.ssh.domain.Department;

import java.util.List;

/**
 * 部门管理Dao层接口
 */
public interface DepartmentDao {

    int findCount();

    List<Department> findByPage(int begin, int pageSize);

    void saveDepartment(Department department);

    Department findDepartmentByDid(int did);

    void updateDepartment(Department department);

    void deleteDepartment(Department department);

    List<Department> findAll();
}
