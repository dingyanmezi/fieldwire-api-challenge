package com.fieldwire.demo.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Floorplan {
    @Id
    private int floorplan_id;
    /** The name of the floorplan. Defaults to the name of the uploaded file */
    private String name;
    /** The project the floorplan belongs to */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    @JsonIgnore
    private Project project;
    /** Original uploaded image of the floorplan */
    private String original;
    /** 100x100 resized image of the floorplan */
    private String thumb;
    /** 2000x2000 resized image of the floorplan */
    private String large;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getFloorplan_id() {
        return floorplan_id;
    }

    public void setFloorplan_id(int floorplan_id) {
        this.floorplan_id = floorplan_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
