package org.learning.cache.controller;


import org.learning.cache.model.Employee;
import org.learning.cache.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @RequestMapping("/employee/{id}")
    public Employee getEmployeeByID(@PathVariable("id") int id){

        System.out.println("Employee details fetch:"+id);
        return iEmployeeService.getEmployeeDetail(id);
    }
}
