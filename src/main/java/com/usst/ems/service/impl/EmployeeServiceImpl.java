package com.usst.ems.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.usst.ems.mapper.EmployeeMapper;
import com.usst.ems.pojo.Employee;
import com.usst.ems.pojo.vo.EmpAndDepName;
import com.usst.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper mapper;
    @Override
    public int getUserByUsername(String username, String password) {
        QueryWrapper<Employee> employeeQueryWrapper = new QueryWrapper<>();
        employeeQueryWrapper.isNotNull("username")
                .eq("username",username)
                .eq("password",password);
        List<Employee> employees = mapper.selectList(employeeQueryWrapper);
        if (employees.size()==1){
//            System.out.println(
//                    employees
//            );
            return 1;
        }
        return 0;
    }

    /**
     * 获取所有员工
     * @return
     */
    @Override
    public List<EmpAndDepName> getAllEmp() {
        List<EmpAndDepName> empInfo = mapper.getEmpInfo();
        return empInfo;
    }

    /**
     * 通过id获取员工信息
     */
    @Override
    public Employee getUserById(int id) {
        return mapper.selectById(id);
    }

    /**
     * 新增一个员工
     * @param lastname
     * @param email
     * @param gender
     * @param department
     * @return
     */
    @Override
    public int updateemp(String lastname, String email, int gender, int department) {

        Employee employee=new Employee();
        employee.setDepartment(department);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setLastName(lastname);
        int update = mapper.insert(employee);
        System.out.println(update);
        return update;
    }

    @Override
    public String getEmpDepartmentNameById(int id) {
        return mapper.getEmpDepartNameById(id);
    }

    /**
     * 更新一名员工信息
     *
     * @param id
     * @param lastname
     * @param email
     * @param gender
     * @param department
     * @param birth
     * @return
     */
    @Override
    public int editOneEmp(Integer id, String lastname, String email, Integer gender, Integer department, Date birth) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setLastName(lastname);
        employee.setGender(gender);
        employee.setEmail(email);
        employee.setDepartment(department);

        return mapper.updateById(employee);
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @Override
    public int deleteemp(int id) {

        int i = mapper.deleteById(id);
        return i;
    }
}
