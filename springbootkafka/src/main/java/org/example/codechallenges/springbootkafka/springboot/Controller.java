package org.example.codechallenges.springbootkafka.springboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class Controller {
    private static final Logger LOG = LogManager.getFormatterLogger(Controller.class);

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        if(name == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Empty name");
        return String.format("Hello %s!", name);
    }

}
