package com.ncs.empconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.empconsole.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
