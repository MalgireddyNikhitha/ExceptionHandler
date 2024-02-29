package com.example.Studentprojectinfo.controller;

import com.example.Studentprojectinfo.dto.Projectrequest;
import com.example.Studentprojectinfo.exception.UserNotFoundException;
import com.example.Studentprojectinfo.model.Project;
import com.example.Studentprojectinfo.service.Projectservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class Projectcontroller {
    @Autowired
    private Projectservice projectservice;
    @PostMapping("/addproject")
    public ResponseEntity<Project>saveproject(@RequestBody @Valid Projectrequest projectrequest){
        return new ResponseEntity<>(projectservice.saveproject(projectrequest), HttpStatus.CREATED);
    }
    @GetMapping("/getproject")
    public List<Project> getproject() {
        return projectservice.getproject();
    }
    @GetMapping("/{id}")
    public Project getProjects(@PathVariable int id){
        return projectservice.getProjects(id);
    }
    @GetMapping("/{rollno}")
    public ResponseEntity<Project> getProjectByRollNo(@PathVariable String rollno) throws UserNotFoundException {
        return ResponseEntity.ok(projectservice.getProjectByRollno(rollno));
    }
    @DeleteMapping("/{id}")
    public void deleteProjects(@PathVariable int id){
        projectservice.deleteProjects(id);
    }
    @PutMapping("/{id}")
    public Project updateProjects(@PathVariable int id, @RequestBody Project project){
        return projectservice.updateProjects(id,project);
    }
    @PostMapping("/addprojects")
    public List<Project> saveprojects(@RequestBody List<Project> projects) {
        return projectservice.saveprojects(projects);
    }
}
