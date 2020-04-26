package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.EmployeeDao;
import com.createvision.wijaya_sports.dao.GenderDao;
import com.createvision.wijaya_sports.model.Employee;
import com.createvision.wijaya_sports.model.Gender;
import com.createvision.wijaya_sports.service.EmployeeService;
import com.createvision.wijaya_sports.valuesObject.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CommonFunctionImpl commonFunction;
    @Autowired
    GenderDao genderDao;

    @Override
    public EmployeeVO createEmployee(EmployeeVO employeeVO) throws Exception {
        try {
            Employee employee = new Employee();
            Gender gender = genderDao.get(employeeVO.getGenderId());
            employee.setFirstName(employeeVO.getFirstName());
            employee.setLastName(employeeVO.getLastName());
            employee.setAddress(employeeVO.getAddress());
            employee.setDateOfBirth(commonFunction.getDateTimeByDateString(employeeVO.getDateOfBirth()));
            employee.setNic(employeeVO.getNic());
            employee.setJoin_Date(commonFunction.getDateTimeByDateString(employeeVO.getJoinedDate()));
            employee.setMobile_Number(employeeVO.getMobileNumber());
            employee.setLandphone_Number(employeeVO.getLandPhoneNumber());
            employee.setGender(gender);
            employeeDao.save(employee);
            return employeeVO;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EmployeeVO> getAllEmployee() throws Exception {
        List<EmployeeVO> employeeVOList = new ArrayList<>();
        try {
            List<Employee> employeeList = employeeDao.getAllEmployee();
            for (Employee employee : employeeList) {
                EmployeeVO employeeVO = new EmployeeVO();
                employeeVO.setFirstName(employee.getFirstName() == null ? "" : employee.getFirstName());
                employeeVO.setLastName(employee.getLastName() == null ? "" : employee.getLastName());
                employeeVO.setAddress(employee.getAddress() == null ? "" : employee.getAddress());
                employeeVO.setDateOfBirth(employee.getDateOfBirth() == null ? "" : commonFunction.convertDateToString(employee.getDateOfBirth()));
                employeeVO.setNic(employee.getNic() == null ? "" : employee.getNic());
                employeeVO.setJoinedDate(employee.getJoin_Date() == null ? "" : commonFunction.convertDateToString(employee.getJoin_Date()));
                employeeVO.setMobileNumber(employee.getMobile_Number() == null ? "" : employee.getMobile_Number());
                employeeVO.setLandPhoneNumber(employee.getLandphone_Number() == null ? "" : employee.getLandphone_Number());
                if (employee.getGender() != null) {
                    Gender gender = genderDao.get(employee.getGender().getId());
                    employeeVO.setGenderName(gender == null ? null : gender.getGenderName());
                    employeeVO.setGenderId(gender.getId());
                } else {
                    employeeVO.setGenderName("");
                }
                employeeVOList.add(employeeVO);
            }
            return employeeVOList;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmployeeVO deleteEmployee(Long id) throws Exception {
        try {
            EmployeeVO employeeVO = new EmployeeVO();
            Employee employee =employeeDao.get(id);
            employee.setDelete(true);
            Long deleteId =employeeDao.save(employee);
            employeeVO.setEmployeeId(deleteId);

            return employeeVO;
        } catch (Exception e) {
            throw e;
        }
    }
}
