package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Controller
public class basicController {

    @PostMapping("/test")
    ResponseEntity<?> getRequest()
    {
        HashMap<String, Object> reqMap = new HashMap<>();
        reqMap.put("resCode", 0);
        reqMap.put("resMsg", "OK");
        return new ResponseEntity<>(reqMap, HttpStatus.OK);
    }
}
