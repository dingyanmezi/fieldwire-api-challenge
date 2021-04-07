package com.fieldwire.demo.api;

import com.fieldwire.demo.api.pojo.Project;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Project where id = :id")
    void deleteByPid(int id);
}
