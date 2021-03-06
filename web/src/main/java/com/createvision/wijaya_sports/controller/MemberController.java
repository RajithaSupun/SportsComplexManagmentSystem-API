package com.createvision.wijaya_sports.controller;

import com.createvision.wijaya_sports.model.Member;
import com.createvision.wijaya_sports.service.MemberService;
import com.createvision.wijaya_sports.valuesObject.EmployeeVO;
import com.createvision.wijaya_sports.valuesObject.MemberVO;
import com.createvision.wijaya_sports.valuesObject.ReturnVO;
import com.createvision.wijaya_sports.valuesObject.UserDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/member")
public class MemberController {
@Autowired
    MemberService memberService;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> createMember(@RequestBody MemberVO memberVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            MemberVO insertedMember = memberService.createNewMember(memberVO);
            returnVO.setResult(insertedMember);
            returnVO.setSuccess(true);
            returnVO.setStatusCode(200);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            e.printStackTrace();
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }

    }

    @RequestMapping(value = "/{memberId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> deleteMember(@PathVariable("memberId") Long memberId) throws Exception {

        ReturnVO returnVO = new ReturnVO();
        try {
            memberService.deleteMember(memberId);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            return ResponseEntity.ok(memberId);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> updateMember(@RequestBody MemberVO memberVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            MemberVO memberVO1 = memberService.updateMember(memberVO);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(memberVO1);
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
    public ResponseEntity<Object> getMember() throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            List<MemberVO> memberList = memberService.getAllMember();
            returnVO.setResult(memberList);
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

    @RequestMapping(value = "/AllMemberDetails/",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getAllMemberDetails() throws Exception{
        ReturnVO returnVO = new ReturnVO();
        try {
            List<MemberVO> memberList = memberService.getAllMemberDetails();
            returnVO.setResult(memberList);
            returnVO.setSuccess(true);
            returnVO.setStatusCode(200);
            return ResponseEntity.ok(returnVO);

        }catch (Exception e){
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }

    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getMemberById(@PathVariable("memberId") Long memberId) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            MemberVO member = memberService.getMemberById(memberId);
            returnVO.setResult(member);
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

    @RequestMapping(value = "/loginUser/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> loginUser(@RequestBody UserDetailVO userDetailVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            UserDetailVO userLogin = memberService.userLogin(userDetailVO);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(userLogin);
            return ResponseEntity.ok(returnVO);

        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }


}
