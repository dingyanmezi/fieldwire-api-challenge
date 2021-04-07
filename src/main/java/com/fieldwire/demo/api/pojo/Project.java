package com.fieldwire.demo.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {
    @Id
    @Column(name = "project_id", nullable=false)
    private int id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Floorplan> floorplanList;

    public List<Floorplan> getFloorplanList() {
        return floorplanList;
    }

    public void addFloorplan(Floorplan f){
        floorplanList.add(f);
    }

    public void setFloorplanList(List<Floorplan> floorplanList) {
        this.floorplanList = floorplanList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
