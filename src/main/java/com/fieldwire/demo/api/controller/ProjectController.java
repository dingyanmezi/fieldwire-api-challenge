package com.fieldwire.demo.api.controller;

import com.fieldwire.demo.api.ProjectRepository;
import com.fieldwire.demo.api.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping(value="/projects")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project){
        return new ResponseEntity<>(projectRepository.save(project), HttpStatus.OK);
    }


    @GetMapping(value="/projects")
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> result = projectRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value="/projects/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") String id){

        return new ResponseEntity<>(projectRepository.getOne(Integer.parseInt(id)), HttpStatus.OK);
    }

    @PatchMapping(value="/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") String id, @RequestBody Project project){
        projectRepository.getOne(Integer.parseInt(id)).setName(project.getName());
        return new ResponseEntity<>(projectRepository.getOne(Integer.parseInt(id)), HttpStatus.OK);
    }

    @DeleteMapping(value="/projects/{id}")

    public ResponseEntity<String> deleteProject(@PathVariable("id") String id){
        projectRepository.deleteByPid(Integer.parseInt(id));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
