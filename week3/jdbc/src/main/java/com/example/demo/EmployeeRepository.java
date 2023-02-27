package com.example.demo;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EmployeeRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        String sqlQuery = "CREATE DATABASE IF NOT EXISTS Demo;";
        this.namedParameterJdbcTemplate.execute(sqlQuery, new HashMap<>(), PreparedStatement::execute);
        sqlQuery = "USE Demo;";
        this.namedParameterJdbcTemplate.execute(sqlQuery, new HashMap<>(), PreparedStatement::execute);
        sqlQuery = "CREATE TABLE IF NOT EXISTS Employee(\n" +
                "    id int(11) unsigned NOT NULL,\n" +
                "    name varchar(20) DEFAULT NULL,\n" +
                "    role varchar(20) DEFAULT NULL,\n" +
                "    PRIMARY KEY (id)\n" +
                ")";
        this.namedParameterJdbcTemplate.execute(sqlQuery, new HashMap<>(), PreparedStatement::execute);
    }

    public void insertEmployee(Employee employee) {
        String sqlQuery = "INSERT INTO employee VALUES(:id, :name, :role)";
        Map<String, Object> employeeMap = createEmployeeMap(employee);
        namedParameterJdbcTemplate.execute(sqlQuery, employeeMap, PreparedStatement::executeUpdate);
    }

    public List<Employee> getEmployees() {
        String sqlQuery = "SELECT * FROM employee";
        return namedParameterJdbcTemplate.query(sqlQuery, (rs, rowNumber) -> new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("role")));
    }

    public void clearDatabase(){
        String sqlQuery = "DELETE FROM employee";
        Map<String, Object> emptyMap = new HashMap<>();
        namedParameterJdbcTemplate.execute(sqlQuery, emptyMap, PreparedStatement::execute);
    }

    private Map<String, Object> createEmployeeMap(Employee employee) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", employee.getId());
        map.put("name", employee.getName());
        map.put("role", employee.getRole());
        return map;
    }
}