package com.ncs.empconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.empconsole.model.Employee;

@Repository
public interface EmployeeRepository extends 
   JpaRepository<Employee, Integer>,
   CustomEmployeeRepository
{

}
