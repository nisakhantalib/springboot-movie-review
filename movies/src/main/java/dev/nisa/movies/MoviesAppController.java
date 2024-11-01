package dev.nisa.movies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesAppController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Movies Application!";
    }

    @GetMapping("/root")
    public String apiRoot(){
        return "Hello, World!";

    }


}
