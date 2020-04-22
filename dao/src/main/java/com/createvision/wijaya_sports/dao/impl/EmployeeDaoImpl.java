package com.createvision.wijaya_sports.dao.impl;


import com.createvision.wijaya_sports.dao.EmployeeDao;
import com.createvision.wijaya_sports.model.Employee;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee, Long> implements EmployeeDao {
}
