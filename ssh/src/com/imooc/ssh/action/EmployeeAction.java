package com.imooc.ssh.action;

import com.imooc.ssh.domain.Department;
import com.imooc.ssh.domain.Employee;
import com.imooc.ssh.domain.PageBean;
import com.imooc.ssh.service.DepartmentService;
import com.imooc.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 员工Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
    private Employee employee = new Employee();

    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private Integer currPge = 1;

    public void setCurrPge(Integer currPge) {
        this.currPge = currPge;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public Employee getModel() {
        return employee;
    }

    //员工登录方法
    public String login(){
        Employee exitEmployee = employeeService.login(employee);
        if(exitEmployee==null){
            //登录失败
            this.addActionError("用户名或密码错误！");
            return INPUT;
        }else{
            //登录成功
            ActionContext.getContext().getSession().put("exitEmployee",exitEmployee);
            return SUCCESS;
        }
    }

    //查询所有员工信息  并分页显示
    public String findAllEmployee(){
        PageBean<Employee> pageBean = employeeService.findByCurrentPage(currPge);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAllSuccess";
    }

    //点击添加跳转到新增员工页面
    public String skipSaveJsp(){
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return "skipSaveJsp";
    }

    //新增员工页面点击完成  跳转至员工信息首页
    public String saveEmployee(){
        employeeService.saveEmployee(employee);
        return "saveSuccess";
    }

    //点击编辑跳转至编辑页面
    public String eidtEmployee(){
        employee = employeeService.findEmployeeById(employee.getEid());
        List<Department> list = departmentService.findAll();
        //值栈的方法  set和push的区别  set一个集合   push一个对象
        ActionContext.getContext().getValueStack().set("list",list);
        return "editSuccess";
    }

    //编辑完成之后点击保存  保存修改后的员工信息
    public String updateEmployee(){
        employeeService.updateEmployee(employee);
        return "saveSuccess";
    }

    //员工删除方法
    public String deleteEmployee(){
        employee = employeeService.findEmployeeById(employee.getEid());
        employeeService.deleteEmployee(employee);
        return "deleteSuccess";
    }
}
