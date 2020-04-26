package com.createvision.wijaya_sports.service;
import com.createvision.wijaya_sports.valuesObject.EmployeeVO;

import java.util.List;

public interface EmployeeService {
    EmployeeVO createEmployee(EmployeeVO employeeVO) throws Exception;
    List<EmployeeVO> getAllEmployee() throws Exception;
    EmployeeVO deleteEmployee(Long id) throws Exception;
    EmployeeVO editEmployee(EmployeeVO employeeVO)throws Exception;
}
