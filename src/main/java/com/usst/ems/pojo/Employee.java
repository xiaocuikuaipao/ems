package com.usst.ems.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    @TableField(fill = FieldFill.INSERT)
    private Date birth;
    private int department;
    private String username;
    private String password;
}
