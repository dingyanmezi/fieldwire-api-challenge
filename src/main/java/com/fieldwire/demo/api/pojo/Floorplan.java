package com.fieldwire.demo.api.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Floorplan {
    @Id
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private int id;
    /** The name of the floorplan. Defaults to the name of the uploaded file */
    private String name;
    /** The project the floorplan belongs to */
    private String project_id;
    /** Original uploaded image of the floorplan */
    private String original;
    /** 100x100 resized image of the floorplan */
    private String thumb;
    /** 2000x2000 resized image of the floorplan */
    private String large;


}
