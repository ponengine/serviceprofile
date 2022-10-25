package th.co.serviceprofile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/")
    public String getmsg(){
        return "<h1>This Service Profile</h1>";
    }
}
