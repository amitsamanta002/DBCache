package org.learning.cache.dao;

import org.learning.cache.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeDAO {

    public Employee fetchEmployeebyId(int id);
}
