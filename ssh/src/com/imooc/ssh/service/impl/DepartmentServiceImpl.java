package com.imooc.ssh.service.impl;

import com.imooc.ssh.dao.DepartmentDao;
import com.imooc.ssh.domain.Department;
import com.imooc.ssh.domain.PageBean;
import com.imooc.ssh.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门管理业务层实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    //分页查询部门的方法
    public PageBean<Department> findByPage(int currentPage){
        PageBean<Department> pageBean = new PageBean<>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //封装每页显示的条数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //封装总条数
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //封装每页显示的数据
        int begin = (currentPage-1)*pageSize;
        List<Department> list = departmentDao.findByPage(begin,currentPage);
        pageBean.setList(list);

        return pageBean;
    }

    //业务层中保存部门的方法
    public void saveDepartment(Department department){
        departmentDao.saveDepartment(department);
    }

    //业务层中根据部门id查询部门相关信息
    public Department findDepartmentByDid(int did) {
        return departmentDao.findDepartmentByDid(did);
    }

    //业务层中更新部门操作
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    //业务层删除操作
    public void deleteDepartment(Department department){
        departmentDao.deleteDepartment(department);
    }

    //查询所有部门信息
    public List<Department> findAll(){
        return departmentDao.findAll();
    }
}
