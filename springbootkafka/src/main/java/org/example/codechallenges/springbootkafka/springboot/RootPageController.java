package org.example.codechallenges.springbootkafka.springboot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootPageController {
    @RequestMapping("/")
    public String rootPage(Model model) {
        return "";
    }
}
