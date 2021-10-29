package nl.novi.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping (value = "/hello")
    public String sayHello() {
        return "Hello world!";
    }
    @GetMapping(value = "/goodbye")
    public String goodbye() {
        return "Goodbye, have a nice day!";
    }
}
