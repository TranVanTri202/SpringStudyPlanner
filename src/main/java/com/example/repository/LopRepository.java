package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Lop;

public interface LopRepository extends JpaRepository<Lop, Integer> {
	Lop findByMaLop(String maLop);
}
