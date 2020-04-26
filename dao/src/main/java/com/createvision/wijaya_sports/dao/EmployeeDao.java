package com.createvision.wijaya_sports.dao;

import com.createvision.wijaya_sports.model.Employee;

import java.util.List;

public interface EmployeeDao extends AbstractDao<Employee,Long> {
    List<Employee> getAllEmployee()throws Exception;
}
