package com.techacademy.service;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.Employee;
import com.techacademy.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    // 全件を検索して返す
    public List<Employee> getEmployeeList() {
        // リポジトリのfindAllメソッドを呼び出す
        return employeeRepository.findAll();
    }

    //Employeeを1件検索して返す
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).get();
    }

    // 新規登録を行なう
    @Transactional
    public Employee saveEmployee(Employee employee) {

        employee.setDelete_flag(0);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        employee.setCreated_at(timestamp);
        employee.setUpdated_at(timestamp);
        employee.getAuthentication().setEmployee(employee);

        return employeeRepository.save(employee);
    }



}


