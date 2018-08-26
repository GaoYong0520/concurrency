package com.gaoyong.concurrency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "hello spring boot.";
    }
}
