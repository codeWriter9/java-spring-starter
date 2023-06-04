package kata.eight.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("HelloWorldController")
@Slf4j
@CrossOrigin
public class HelloWorldController {

    @GetMapping("/hello")
    public @ResponseBody String employees() {
        return "Hello World!";
    }
}
