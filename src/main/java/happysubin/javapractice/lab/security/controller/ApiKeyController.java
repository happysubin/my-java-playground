package happysubin.javapractice.lab.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/key")
public class ApiKeyController {

    @GetMapping("/test")
    public String test() {
        return "hihihihihi";
    }

}
