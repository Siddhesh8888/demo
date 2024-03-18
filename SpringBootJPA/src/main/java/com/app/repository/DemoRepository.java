package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Demo;

public interface DemoRepository extends JpaRepository<Demo, Integer>{

}
