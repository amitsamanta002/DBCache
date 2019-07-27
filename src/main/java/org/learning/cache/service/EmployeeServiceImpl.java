package org.learning.cache.service;

import org.learning.cache.dao.IEmployeeDAO;
import org.learning.cache.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDAO iEmployeeDAO;


    @Cacheable(value = "employeeCache",key = "#id")
    @Override
    public Employee getEmployeeDetail(int id) {
        return iEmployeeDAO.fetchEmployeebyId(id);
    }
}
