package org.learning.cache.dao;

import org.learning.cache.dao.mapper.EmployeeRowMapper;
import org.learning.cache.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;


@Service
public class EmployeeDAOImplementation implements IEmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee fetchEmployeebyId(int id) {

        String sqlStatement = "SELECT ID,NAME,ADDR FROM EMPLOYEE WHERE ID = ?";

        Employee employee = (Employee)jdbcTemplate.queryForObject(sqlStatement,new Object[]{id},new EmployeeRowMapper());
        System.out.println("Log from DB:"+employee.toString());
        return employee;
    }
}
