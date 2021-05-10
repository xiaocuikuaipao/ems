package com.usst.ems.service.impl;

import com.usst.ems.mapper.DepartmentMapper;
import com.usst.ems.pojo.Department;
import com.usst.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper mapper;
    @Override
    public List<Department> findAll() {
        return mapper.selectList(null);
    }
}
