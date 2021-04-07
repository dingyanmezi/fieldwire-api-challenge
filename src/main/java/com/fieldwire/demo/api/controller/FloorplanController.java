package com.fieldwire.demo.api.controller;

import com.fieldwire.demo.api.ProjectRepository;
import com.fieldwire.demo.api.pojo.Floorplan;
import com.fieldwire.demo.api.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class FloorplanController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping(value="/projects/{pid}/floorplans")
    public ResponseEntity<List<Floorplan>> getAllFloorplans(@PathVariable("pid") String pid){
        return new ResponseEntity<>(projectRepository.getOne(Integer.parseInt(pid)).getFloorplanList(), HttpStatus.OK);
    }

//    @GetMapping(value="/projects/{pid}/floorplans/{fid}")
//    public ResponseEntity<Floorplan> getFloorplan(@PathVariable("pid") String pid, @PathVariable("fid") String fid){
//
//    }
//
//    @PostMapping(value="/projects/{pid}/floorplans")
//    public ResponseEntity<Project> createNewFloorplan(@PathVariable("pid") String pid){
//
//    }
//
//    @PatchMapping(value="/projects/{pid}/floorplans/{fid}")
//    public ResponseEntity<Project> updateFloorplan(@PathVariable("pid") String pid, @PathVariable("fid") String fid){
//
//    }
//
//    @DeleteMapping(value="/projects/{pid}/floorplans/{fid}")
//    public ResponseEntity<Project> deleteFloorplan(@PathVariable("pid") String pid, @PathVariable("fid") String fid){
//
//    }
}
