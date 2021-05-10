package com.usst.ems.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpAndDepName {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Date birth;
    private String departmentName;
}
