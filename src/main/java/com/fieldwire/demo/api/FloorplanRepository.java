package com.fieldwire.demo.api;

import com.fieldwire.demo.api.pojo.Floorplan;
import com.fieldwire.demo.api.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface FloorplanRepository extends JpaRepository<Floorplan, Integer> {
    List<Floorplan> findFloorplansByProject(Project project);

    @Modifying
    @Transactional
    @Query("delete from Floorplan where floorplan_id = :fid and project.id = :pid")
    void deleteByPidAndFid(int pid, int fid);

    @Modifying
    @Transactional
    @Query("update Floorplan set original = :original, thumb = :thumb, large = :large where floorplan_id = :fid and project.id = :pid")
    void updateBypidAndFid(int pid, int fid, String original, String thumb, String large);

    @Transactional
    @Query("select f from Floorplan f where f.floorplan_id = :fid and f.project.id = :pid")
    Floorplan getFloorplanByPidandFid(int pid, int fid);
}
