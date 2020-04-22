package com.createvision.wijaya_sports.controller;

import com.createvision.wijaya_sports.service.ItemService;
import com.createvision.wijaya_sports.valuesObject.ItemVO;
import com.createvision.wijaya_sports.valuesObject.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getAllItems() throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            List<ItemVO> itemVOList = itemService.getAllItems();
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(itemVOList);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }
}
