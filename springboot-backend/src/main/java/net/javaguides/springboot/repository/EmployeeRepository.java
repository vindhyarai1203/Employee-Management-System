package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Employee;

// spring jpa data provides internally  @repository jpa so we no need to add
//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
