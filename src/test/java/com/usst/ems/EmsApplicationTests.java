package com.usst.ems;

import com.usst.ems.mapper.DepartmentMapper;
import com.usst.ems.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmsApplicationTests {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Test
    void contextLoads() {

        List<Department> departments = departmentMapper.selectList(null);
        for (Department department : departments) {
            System.out.println(department);
        }
    }

}
