package com.imooc.ssh.service;

import com.imooc.ssh.domain.Department;
import com.imooc.ssh.domain.PageBean;

import java.util.List;

/**
 * 部门管理业务层接口
 */
public interface DepartmentService {
    PageBean<Department> findByPage(int currPage);

    void saveDepartment(Department department);

    Department findDepartmentByDid(int did);

    void updateDepartment(Department department);

    void deleteDepartment(Department department);

    List<Department> findAll();
}
