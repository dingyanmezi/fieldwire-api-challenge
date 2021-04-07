package com.fieldwire.demo.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {
    @Id
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private int id;
    private String name;
    @OneToMany
    private List<Floorplan> floorplanList;

    public List<Floorplan> getFloorplanList() {
        return floorplanList;
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
