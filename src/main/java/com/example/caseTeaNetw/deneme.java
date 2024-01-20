package com.example.caseTeaNetw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deneme {
    @GetMapping(path= "/hello-world")
    public String helloworld(){
        return "HelloWorld";

    }
    @GetMapping(path= "/hello-world-bean")
    public HelloWorldBean helloworldbean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path= "/hello-world/path-variable/{name}")
    public HelloWorldBean helloworldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello,%s", name));
    }


}
