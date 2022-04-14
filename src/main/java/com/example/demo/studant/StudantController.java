package com.example.demo.studant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/studant")
public class StudantController {


    @GetMapping
    public List<Studant> getStudants(){
        return List.of(
                new Studant("Nome","email", LocalDate.of(1999,9,30), 21)

        );
    }
}
