package uz.pdp.springbootwithdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/greet")
    public String hello() {
        return "So guys, We did it.";
    }
}
