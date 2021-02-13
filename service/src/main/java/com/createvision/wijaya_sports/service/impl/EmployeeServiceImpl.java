package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.EmployeeDao;
import com.createvision.wijaya_sports.dao.GenderDao;
import com.createvision.wijaya_sports.model.Employee;
import com.createvision.wijaya_sports.model.Gender;
import com.createvision.wijaya_sports.model.Payment;
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
            List<Employee> employeeList = employeeDao.getAll();
            for (Employee employee : employeeList) {
                EmployeeVO employeeVO = new EmployeeVO();

                employeeVO.setId(employee.getId());
                employeeVO.setFirstName(employee.getFirstName());
                employeeVO.setLastName(employee.getLastName());
                employeeVO.setAddress(employee.getAddress());
                employeeVO.setDateOfBirth(commonFunction.convertDateToString(employee.getDateOfBirth()));
                employeeVO.setNic(employee.getNic());
                employeeVO.setJoinedDate(commonFunction.convertDateToString(employee.getJoin_Date()));
                employeeVO.setMobileNumber(employee.getMobile_Number());
                employeeVO.setLandPhoneNumber(employee.getLandphone_Number());
                Gender gender = genderDao.get(employee.getGender().getId());
                employeeVO.setGenderName(gender.getGenderName());

                employeeVOList.add(employeeVO);

            }
            return employeeVOList;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) throws Exception {
        try {
            Employee employee = employeeDao.get(employeeId);
            employeeDao.delete(employee);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmployeeVO updateEmployee(EmployeeVO employeeVO) throws Exception {
        try {
            Employee employee = employeeDao.get(employeeVO.getId());
            employee.setAddress(employeeVO.getAddress());
            employee.setGender(genderDao.get(employeeVO.getGenderId()));
            employee.setFirstName(employeeVO.getFirstName());
            employee.setLastName(employeeVO.getLastName());
            employee.setDateOfBirth(commonFunction.getCurrentDateAndTimeByTimeZone(employeeVO.getDateOfBirth()));
            employee.setNic(employeeVO.getNic());
            employee.setLandphone_Number(employeeVO.getMobileNumber());
            employeeDao.save(employee);
            return employeeVO;
        } catch (Exception e) {
            throw e;
        }
    }
}
