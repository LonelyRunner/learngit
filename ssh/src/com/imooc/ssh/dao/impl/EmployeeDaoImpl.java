package com.imooc.ssh.dao.impl;

import com.imooc.ssh.dao.EmployeeDao;
import com.imooc.ssh.domain.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by ZH on 2016/8/29.
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

    //员工登录
    public Employee findEmployeeByUsernameAndPassword(Employee employee){
        String hql = "from Employee e where e.username=? and e.password=?";
        List<Employee> employees = (List<Employee>)this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
        if(employees.size()>0){
            return employees.get(0);
        }
        return null;
    }

    //员工分页管理
    //1. 查询员工总记录数
    public int findCount() {
        String hql = "select count(*) from Employee";
        List<Long> list = (List<Long>)this.getHibernateTemplate().find(hql);
        if(list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    //查询每页显示的员工信息集合
    public List<Employee> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        List<Employee> list = (List<Employee>)this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    //dao层保存员工信息的方法
    public void saveEmployee(Employee employee){
        this.getHibernateTemplate().save(employee);
    }

    //dao层根据员工id查询员工的相关信息
    public Employee findEmployeeById(int eid){
        return this.getHibernateTemplate().get(Employee.class,eid);
    }

    //dao层更新员工信息的方法
    public void updateEmployee(Employee employee){
        this.getHibernateTemplate().update(employee);
    }

    public void deleteEmployee(Employee employee){
        this.getHibernateTemplate().delete(employee);
    }
}
