package com.imooc.ssh.service.impl;

import com.imooc.ssh.dao.EmployeeDao;
import com.imooc.ssh.domain.Employee;
import com.imooc.ssh.domain.PageBean;
import com.imooc.ssh.service.EmployeeService;

import java.util.List;

/**
 * 业务层员工实现类
 */
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    //业务层员工登录
    public Employee login(Employee employee){
        Employee employee1 = employeeDao.findEmployeeByUsernameAndPassword(employee);
        return employee1;
    }

    //员工的分页信息查询
    public PageBean<Employee> findByCurrentPage(int currentPage){
        PageBean<Employee> pageBean = new PageBean<>();
        //封装当前页
        pageBean.setCurrPage(currentPage);
        //封装每页显示条数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = employeeDao.findCount();
        pageBean.setTotalCount(totalCount);
        //封装当前页
        double tc = totalCount;
        Double totalPage = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(totalPage.intValue());
        //封装当前页显示的数据
        int begin = (currentPage-1)*pageSize;
        List<Employee> list = employeeDao.findByPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    //员工信息保存方法
    public void saveEmployee(Employee employee){
        employeeDao.saveEmployee(employee);
    }

    //跳转到员工编辑页面  根据员工id查询员工相关信息
    public Employee findEmployeeById(int eid){
        return employeeDao.findEmployeeById(eid);
    }

    //业务层更新员工信息的方法
    public void updateEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee){
        employeeDao.deleteEmployee(employee);
    }
}
