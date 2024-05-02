package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Khoa;

public interface KhoaRepository extends JpaRepository<Khoa, Integer> {
	Khoa findByMaKhoa(String maKhoa);
}
