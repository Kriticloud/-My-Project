package com.org.java_project.controller;

import com.org.java_project.model.Employee;
import com.org.java_project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable UUID id) {
        return employeeRepository.findById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable UUID id, @RequestBody Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setSkills(updatedEmployee.getSkills());
            employee.setTotalExperience(updatedEmployee.getTotalExperience());
            employee.setBenchStartDate(updatedEmployee.getBenchStartDate());
            employee.setTagged(updatedEmployee.isTagged());
            employee.setPositionFilled(updatedEmployee.isPositionFilled());
            employee.setDemandClosed(updatedEmployee.isDemandClosed());
            employee.setInterviewStatus(updatedEmployee.getInterviewStatus());
            employee.setProjectAllocation(updatedEmployee.getProjectAllocation());
            return employeeRepository.save(employee);
        })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable UUID id) {
        employeeRepository.deleteById(id);
    }
}
