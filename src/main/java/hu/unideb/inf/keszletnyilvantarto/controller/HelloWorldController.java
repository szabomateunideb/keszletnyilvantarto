package hu.unideb.inf.keszletnyilvantarto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    //http GET localhost:9090/hello/world
    @GetMapping("/world")
    public String hello(){
        return "Hello World";
    }
}
