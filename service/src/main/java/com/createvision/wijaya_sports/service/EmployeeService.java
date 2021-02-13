package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.valuesObject.EmployeeVO;

import java.util.List;

public interface EmployeeService {
    EmployeeVO createEmployee(EmployeeVO employeeVO) throws Exception;
    List<EmployeeVO> getAllEmployee() throws Exception;
    public void deleteEmployee(Long employeeId) throws Exception;
    EmployeeVO updateEmployee(EmployeeVO employeeVO) throws Exception;
}
