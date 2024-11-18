package com.dpmg.first_spring_app.controllers;

import com.dpmg.first_spring_app.domain.User;
import com.dpmg.first_spring_app.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return helloWorldService.helloWorld(name);
    }

    @PostMapping("/{unitCode}/{id}")
    public String helloWorldPost(@PathVariable("unitCode") String unitCode, @PathVariable("id") String id, @RequestBody User body) {
        return "unitCode: " + unitCode + " id: " + id + " " + body.getName();
    }
}
