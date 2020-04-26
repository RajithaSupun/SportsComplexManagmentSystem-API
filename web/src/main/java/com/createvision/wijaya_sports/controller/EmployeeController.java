package com.createvision.wijaya_sports.controller;

import com.createvision.wijaya_sports.service.EmployeeService;
import com.createvision.wijaya_sports.valuesObject.EmployeeVO;
import com.createvision.wijaya_sports.valuesObject.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            EmployeeVO deletedEmployee = employeeService.deleteEmployee(id);
            returnVO.setResult(deletedEmployee);
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
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> editEmployee(@RequestBody EmployeeVO employeeVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            EmployeeVO deletedEmployee = employeeService.editEmployee(employeeVO);
            returnVO.setResult(deletedEmployee);
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
