package com.example.springboot_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootPracticeApplication.class, args);
    }

    @GetMapping
    public String HelloWorld(){
        Runnable r = () -> {
            int i=1;
            for (int j = 0; j < 100000000; j++) {
                i+=1;
            }

        };
        new Thread(r).start();
        return "Hello World";
    }
}
