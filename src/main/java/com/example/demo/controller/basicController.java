package com.example.demo.controller;

import com.example.demo.model.dataSet;
import com.example.demo.service.basicServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Controller
public class basicController {
    protected static final Logger log = LoggerFactory.getLogger(basicController.class);

    @Autowired
    basicServiceI basicService;

    @PostMapping("/test")
    @ResponseBody
    public ResponseEntity<?> getRequest(@RequestBody dataSet camInfo)
    {
        log.info("/test Request Mapping" + camInfo.getCamName());
        //basicService.doService("test");


        HashMap<String, Object> reqMap = new HashMap<>();
        reqMap.put("resCode", 0);
        reqMap.put("resMsg", "OK");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        return new ResponseEntity<>(reqMap,headers, HttpStatus.OK);
    }
}
