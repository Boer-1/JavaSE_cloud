package com.mhl.service;

import com.mhl.dao.EmployeeDAO;
import com.mhl.domain.MHL_Emp;

//业务层
public class EmployeeService {
    //持有EmployeeDAO
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    //根据用户输入，返回相应员工对象，若不存在，返回空
    public MHL_Emp getEmpById_Pwd(String id ,String pwd){
        MHL_Emp mhl_emp = employeeDAO.querySingle
                ("select * from mhl_emp where empId = ? and pwd = md5(?)", MHL_Emp.class, id, pwd);
        return mhl_emp;
    }
}
