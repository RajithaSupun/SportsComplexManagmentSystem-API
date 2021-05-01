package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.EmployeeDao;
import com.createvision.wijaya_sports.dao.GenderDao;
import com.createvision.wijaya_sports.dao.UserDao;
import com.createvision.wijaya_sports.model.Employee;
import com.createvision.wijaya_sports.model.Gender;
import com.createvision.wijaya_sports.model.Payment;
import com.createvision.wijaya_sports.model.User;
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
    @Autowired
    UserDao userDao;

    @Override
    public EmployeeVO createEmployee(EmployeeVO employeeVO) throws Exception {
        try {
            Employee employee = new Employee();
            User user = new User();
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
            employee.setDesignation(employeeVO.getDesignation());


            user.setUserName(employeeVO.getUserName());
            user.setPassword(employeeVO.getPassword());
            Long userId = userDao.save(user);
            employee.setUser(userDao.get(userId));
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
                employeeVO.setUserName(employee.getUser().getUserName() != null ? employee.getUser().getUserName() : "");
                employeeVO.setPassword(employee.getUser().getPassword() != null ? employee.getUser().getPassword() : "");
                employeeVO.setDesignation(employee.getDesignation() != null ? employee.getDesignation() : "");
                employeeVO.setUserId(employee.getUser().getId());


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
//            employee.setGender(genderDao.get(employeeVO.getGenderId()));
            employee.setFirstName(employeeVO.getFirstName());
            employee.setLastName(employeeVO.getLastName());
            employee.setDateOfBirth(commonFunction.getDateTimeByDateString(employeeVO.getDateOfBirth()));
            employee.setNic(employeeVO.getNic());
            employee.setLandphone_Number(employeeVO.getMobileNumber());
            employeeDao.save(employee);
            return employeeVO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmployeeVO getEmployeeBtId(Long employeeId) throws Exception {
        EmployeeVO employeeVO = new EmployeeVO();
        try {
            Employee employee = employeeDao.get(employeeId);
            if (employee != null) {
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
                employeeVO.setUserName(employee.getUser().getUserName() != null ? employee.getUser().getUserName() : "");
                employeeVO.setPassword(employee.getUser().getPassword() != null ? employee.getUser().getPassword() : "");
            }

            return employeeVO;
        } catch (Exception e) {
            throw e;
        }
    }
}
