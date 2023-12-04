package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.implement;

import fit.se.week7.backend.models.Employee;
import fit.se.week7.backend.repositories.EmployeeRepository;
import fit.se.week7.backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmpImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }
}
