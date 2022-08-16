package com.ncs.empconsole.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Project;

@Service
public interface ProjectService {

	public Project addProject(Project project);
	public Project getProject(int projectId);
	public Set<Employee> allocateProject(Project p,Employee e);
	public Set<Employee> getProjectResource(int projectId);
	
	
}
