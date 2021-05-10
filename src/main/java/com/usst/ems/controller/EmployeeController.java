package com.usst.ems.controller;

import com.usst.ems.pojo.Department;
import com.usst.ems.pojo.Employee;
import com.usst.ems.pojo.vo.EmpAndDepName;
import com.usst.ems.service.DepartmentService;
import com.usst.ems.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("/list")
    public String list(Model model){
        List<EmpAndDepName> employeeList=employeeService.getAllEmp();
        Map<String, Object> map = new HashMap<>();

        map.put("emps",employeeList);
//        System.out.println(employeeList);
        model.addAllAttributes(map);
        return "list";
    }

    /**
     * 跳转到编辑员工页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toedit/{id}")
    public String editEmp(@PathVariable("id") int id,Model model){

        String departmentName=employeeService.getEmpDepartmentNameById(id);
        model.addAttribute("departmentName" ,departmentName);
        List<Department> list=departmentService.findAll();
        model.addAttribute("departmentNameList",list);
        Employee employee=employeeService.getUserById(id);
        System.out.println(id);
        model.addAttribute("changeemp",employee);
        return "editemp";

    }

    /**
     * 编辑员工
     * @param
     * @param
     * @return
     */
    @RequestMapping("/edit")
    public String editEmp1(@Param("id") Integer id, @Param("lastname")String lastname,@Param("email") String email,@Param("gender") Integer gender,
                           @Param("department") Integer department,@Param("birth") Date birth){

        int tag=employeeService.editOneEmp(id,lastname,email,gender,department,birth);
        return "redirect:/emp/list";

    }

    /**
     * 跳转到添加员工的界面
     * @return
     */
    @RequestMapping("/addemp")
    public String toAddEmp(Model model){

        List<Department> list=departmentService.findAll();
        System.out.println(list);
        model.addAttribute("list",list);
        return "addemp";
    }

    /**
     * 进行添加
     * @param lastname
     * @param email
     * @param gender
     * @param department
     * @return
     */
    @RequestMapping("/add")
    public String addEmp(String lastname,String email,int gender, int department){

        int tag=employeeService.updateemp(lastname,email,gender,department);
        if (tag==1){
            return "redirect:/emp/list";
        }
        return "emp/addemp";
    }

    /**
     * 跳转到确定删除页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/todelete/{id}")
    public String toDelete(@PathVariable("id") Integer id,Model model){
//        System.out.println(id);
        Employee userById = employeeService.getUserById(id);
//        System.out.println(userById);
        String empDepartmentNameById = employeeService.getEmpDepartmentNameById(id);
//        System.out.println(empDepartmentNameById);
        model.addAttribute("id",id);
        model.addAttribute("departmentName",empDepartmentNameById);
        model.addAttribute("changeemp",userById);
        return "confirmdelete";
    }

    /**
     * 删除员工
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        System.out.println(id);
        int deleteemp = employeeService.deleteemp(id);
        return "redirect:/emp/list";
    }


}
