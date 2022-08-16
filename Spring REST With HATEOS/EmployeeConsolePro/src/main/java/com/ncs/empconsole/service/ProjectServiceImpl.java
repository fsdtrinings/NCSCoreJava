package com.ncs.empconsole.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Project;
import com.ncs.empconsole.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	@Transactional
	public Project addProject(Project project) {
		
		return projectRepository.save(project);
	}

	@Override
	public Project getProject(int projectId) {
		
		return projectRepository.findById(projectId).get();
	}

	@Override
	@Transactional
	public Set<Employee> allocateProject(Project p, Employee e) {
		
			System.err.println(" -------- Project Inside Service Impl ------------");
			System.err.println("p :- "+p+" & e "+e);
			Set<Employee> allWorkingEmployees = p.getAllEmployees();
			System.err.println(" 1:- "+allWorkingEmployees);
			
			if(allWorkingEmployees !=null)
			{
				System.err.println("--->> inside if ");
				allWorkingEmployees.add(e);
				System.err.println("--->> Employee added in Set  "+allWorkingEmployees.size());
				p.setAllEmployees(allWorkingEmployees);
				System.err.println("--->> set All Employees called "+p.getAllEmployees());
				projectRepository.saveAndFlush(p);
				System.err.println("--->> Data Saved");
				return allWorkingEmployees;
			}
			else
			{
				System.err.println(" -->> inside else ");
				Set<Employee> set = new HashSet<>();
				set.add(e);
				p.setAllEmployees(set);
				projectRepository.save(p);
				System.err.println(" --->> inside else 2 :- "+p);
				return set;
			}
		
	}

	@Override
	public Set<Employee> getProjectResource(int projectId) {
		
		Project p = getProject(projectId);
		
		if(p != null)
		{
			Set<Employee> allWorkingEmployees = p.getAllEmployees();
			
			if(allWorkingEmployees !=null)
			{
				return allWorkingEmployees;
			}
			else return null;
		}
		else return null;
	}

	
}//end of class
