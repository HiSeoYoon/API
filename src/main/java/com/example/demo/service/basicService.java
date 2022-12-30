package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("basicService")
public class basicService implements basicServiceI{

    protected static final Logger log = LoggerFactory.getLogger(basicService.class);

    @Override
    public HashMap<String, Object> doService(String param) {
        return null;
    }
}
