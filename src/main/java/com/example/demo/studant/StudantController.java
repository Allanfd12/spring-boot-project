package com.example.demo.studant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewStudant(@RequestBody  Studant studant){
        studantService.addNewStudant(studant);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudant(@PathVariable("studentID") Long id){
        studantService.deleteStudant(id);

    }

    @PutMapping(path = "{studentID}")
    public void updateStudant(@PathVariable("studentID") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email
                              ) {
    studantService.updateStudant(id, name, email);
    }
}
