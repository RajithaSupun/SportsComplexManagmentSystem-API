package com.createvision.wijaya_sports.controller;

import com.createvision.wijaya_sports.service.EmployeeService;
import com.createvision.wijaya_sports.valuesObject.EmployeeVO;
import com.createvision.wijaya_sports.valuesObject.PaymentVO;
import com.createvision.wijaya_sports.valuesObject.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeVO employeeVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            EmployeeVO insertedEmployee = employeeService.createEmployee(employeeVO);
            returnVO.setResult(insertedEmployee);
            returnVO.setSuccess(true);
            returnVO.setStatusCode(200);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }

    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getEmployee() throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            List<EmployeeVO> insertedEmployee = employeeService.getAllEmployee();
            returnVO.setResult(insertedEmployee);
            returnVO.setSuccess(true);
            returnVO.setStatusCode(200);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }

    }
    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> deletePayment(@PathVariable("employeeId") Long paymentId) throws Exception {

        ReturnVO returnVO = new ReturnVO();
        try {
            employeeService.deleteEmployee(paymentId);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }


    @RequestMapping(value = "/employeeUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeVO employeeVO) throws Exception {

        ReturnVO returnVO = new ReturnVO();
        try {
            EmployeeVO employee = employeeService.updateEmployee(employeeVO);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(employee);
            return ResponseEntity.ok(returnVO);

        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getEmployeeById(@PathVariable("employeeId") Long employeeId) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            EmployeeVO insertedEmployee = employeeService.getEmployeeBtId(employeeId);
            returnVO.setResult(insertedEmployee);
            returnVO.setSuccess(true);
            returnVO.setStatusCode(200);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }

    }
}
