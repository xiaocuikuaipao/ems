package com.usst.ems.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usst.ems.pojo.Employee;
import com.usst.ems.pojo.vo.EmpAndDepName;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Select("SELECT e.id,last_name,email,gender,birth,d.department_name FROM employee e ,department d  WHERE e.department=d.id;")
    public List<EmpAndDepName> getEmpInfo();

    @Select("SELECT d.department_name FROM employee e ,department d  " +
            "WHERE e.department=d.id and e.id=#{id};")
    String getEmpDepartNameById(int id);
}
