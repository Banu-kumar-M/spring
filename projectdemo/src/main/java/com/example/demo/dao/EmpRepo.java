package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.emp;

public interface EmpRepo extends JpaRepository<emp, Integer>{


}