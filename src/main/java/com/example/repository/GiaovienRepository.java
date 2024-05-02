package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Giaovien;

public interface GiaovienRepository extends JpaRepository<Giaovien, Integer> {
	Giaovien  findByTenGV(String tenGV);
}
