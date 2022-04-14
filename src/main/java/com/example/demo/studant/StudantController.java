package com.example.demo.studant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/studant")
public class StudantController {

    private final StudantService studantService;

    @Autowired
    public StudantController(StudantService studantService) {
        this.studantService = studantService;
    }

    @GetMapping
    public List<Studant> getStudants(){
        return studantService.getStudants();
    }
}
