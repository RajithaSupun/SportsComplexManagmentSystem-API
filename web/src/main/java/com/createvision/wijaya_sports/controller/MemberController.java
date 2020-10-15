package com.createvision.wijaya_sports.controller;

import com.createvision.wijaya_sports.service.MemberService;
import com.createvision.wijaya_sports.valuesObject.MemberVO;
import com.createvision.wijaya_sports.valuesObject.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/member")
public class MemberController {
@Autowired
    MemberService memberService;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> createEmployee(@RequestBody MemberVO memberVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            MemberVO insertedMember = memberService.createNewMember(memberVO);
            returnVO.setResult(insertedMember);
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
