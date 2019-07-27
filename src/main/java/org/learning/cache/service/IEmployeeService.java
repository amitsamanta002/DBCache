package org.learning.cache.service;

import org.learning.cache.model.Employee;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeService {

    public Employee getEmployeeDetail(int id);
}
