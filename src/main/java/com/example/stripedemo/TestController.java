package com.example.stripedemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * https://www.baeldung.com/spring-rest-docs
 * https://github.com/eugenp/tutorials/tree/master/spring-5/src/main
 */
@RestController
public class TestController {

    @GetMapping(value = "hello")
    public Map hello() {
        Map map = new HashMap<>();
        map.put("hello", "john");
        return map;
    }
}
