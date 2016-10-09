package com.imooc.ssh.dao.impl;

import com.imooc.ssh.dao.DepartmentDao;
import com.imooc.ssh.domain.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * 部门管理Dao层实现类
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    //dao层查询部门的总记录数
    public int findCount(){
        String hql = "select count(*) from Department";
        List<Long> list = (List<Long>)this.getHibernateTemplate().find(hql);
        if(list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    //dao层查询每页显示的数据集合
    public List<Department> findByPage(int begin,int pageSize){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Department.class);
        List<Department> list = (List<Department>)this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
        return list;
    }

    //dao层保存部门信息的方法
    public void saveDepartment(Department department){
        this.getHibernateTemplate().save(department);
    }

    //dao层根据部门id查询部门信息的方法
    public Department findDepartmentByDid(int did) {
        return this.getHibernateTemplate().get(Department.class,did);
    }

    //dao层中更新部门的方法
    public void updateDepartment(Department department) {
        this.getHibernateTemplate().update(department);
    }

    //dao层中删除部门的方法
    public void deleteDepartment(Department department){
        this.getHibernateTemplate().delete(department);
    }

    //dao层中查询所有部门的信息
    public List<Department> findAll(){
        return (List<Department>)this.getHibernateTemplate().find("from Department");
    }
}
