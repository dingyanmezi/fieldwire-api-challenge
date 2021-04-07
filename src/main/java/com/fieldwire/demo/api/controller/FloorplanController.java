package com.fieldwire.demo.api.controller;

import com.fieldwire.demo.api.FloorplanRepository;
import com.fieldwire.demo.api.ProjectRepository;
import com.fieldwire.demo.api.pojo.Floorplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class FloorplanController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private FloorplanRepository floorplanRepository;

    @GetMapping(value="/projects/{pid}/floorplans")
    public ResponseEntity<List<Floorplan>> getAllFloorplans(@PathVariable("pid") String pid){
        return new ResponseEntity<>(floorplanRepository.findFloorplansByProject(projectRepository.getOne(Integer.parseInt(pid))), HttpStatus.OK);
    }

    @GetMapping(value="/projects/{pid}/floorplans/{fid}")
    public ResponseEntity<Floorplan> getFloorplan(@PathVariable("pid") String pid, @PathVariable("fid") String fid){
        return new ResponseEntity<>(floorplanRepository.getFloorplanByPidandFid(Integer.parseInt(pid), Integer.parseInt(fid)), HttpStatus.NOT_FOUND);
    }
//
    @PostMapping(value="/projects/{pid}/floorplans")
    public ResponseEntity<Floorplan> createNewFloorplan(@PathVariable("pid") String pid, @RequestBody Floorplan floorplan){
        floorplan.setProject(projectRepository.getOne(Integer.parseInt(pid)));
        floorplanRepository.save(floorplan);
        return new ResponseEntity<>(floorplan, HttpStatus.OK);
    }
//
    @PatchMapping(value="/projects/{pid}/floorplans/{fid}")
    public ResponseEntity<Floorplan> updateFloorplan(@PathVariable("pid") String pid, @PathVariable("fid") String fid, @RequestBody Floorplan floorplan){
        floorplanRepository.updateBypidAndFid(Integer.parseInt(pid), Integer.parseInt(fid), floorplan.getOriginal(), floorplan.getThumb(), floorplan.getLarge());
        return new ResponseEntity<>(floorplanRepository.getFloorplanByPidandFid(Integer.parseInt(pid), Integer.parseInt(fid)), HttpStatus.NOT_FOUND);
    }
//
    @DeleteMapping(value="/projects/{pid}/floorplans/{fid}")
    public ResponseEntity<String> deleteFloorplan(@PathVariable("pid") String pid, @PathVariable("fid") String fid){
        floorplanRepository.deleteByPidAndFid(Integer.parseInt(pid), Integer.parseInt(fid));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
