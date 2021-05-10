package com.usst.ems.service;

import com.usst.ems.pojo.Employee;
import com.usst.ems.pojo.vo.EmpAndDepName;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    int getUserByUsername(String username, String password);

    List<EmpAndDepName> getAllEmp();

    Employee getUserById(int id);

    int updateemp(String lastname, String email, int gender, int department);

    String getEmpDepartmentNameById(int id);

    int editOneEmp(Integer id, String lastname, String email, Integer gender, Integer department, Date birth);

    int deleteemp(int id);
}
