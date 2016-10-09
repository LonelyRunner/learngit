package com.imooc.ssh.action;

import com.imooc.ssh.domain.Department;
import com.imooc.ssh.domain.PageBean;
import com.imooc.ssh.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 部门管理Action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

    private DepartmentService departmentService;
    private Department department = new Department();
    //分页显示部门  当前页数
    private int currpage;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    @Override
    public Department getModel() {
        return department;
    }

    //分页显示查询部门数据
    public String findAll(){
        PageBean<Department> pageBean = departmentService.findByPage(currpage);
        //将pageBean存放到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    //跳转到新增页面
    public String redirectAddJsp(){
        return "skipAddSuccess";
    }

    //保存新增部门
    public String saveDepartment(){
        departmentService.saveDepartment(department);
        return "saveSuccess";
    }

    //跳转到编辑页面
    public String redirectEditJsp(){
        department = departmentService.findDepartmentByDid(department.getDid());
        return "skipEditSuccess";
    }

    //执行更新操作
    public String updateDepartment(){
        departmentService.updateDepartment(department);
        return "updateSuccess";
    }

    //执行删除操作
    public String deleteDepartment(){
        department = departmentService.findDepartmentByDid(department.getDid());
        //直接删除一个对象会产生级联效果
        departmentService.deleteDepartment(department);
        return "deleteSuccess";
    }
}
