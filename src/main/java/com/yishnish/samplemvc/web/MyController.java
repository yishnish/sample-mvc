package com.yishnish.samplemvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    @RequestMapping(value = "/")
    public Map<String, String> getHello() {
        HashMap<String, String> responseBody = new HashMap<>();
        responseBody.put("name", "my name");

        return responseBody;
    }
}
