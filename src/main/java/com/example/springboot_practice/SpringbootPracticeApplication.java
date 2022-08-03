package com.example.springboot_practice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class SpringbootPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootPracticeApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper (){
        return  new ModelMapper();
    }

}
