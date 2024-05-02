package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MonHoc;

public interface MonhocRepository extends JpaRepository<MonHoc, Integer>{
	MonHoc findByTenMH(String tenMH);
}
