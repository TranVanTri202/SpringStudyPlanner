package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.model.SinhVien;

public interface SinhvienRepository extends JpaRepository<SinhVien, Integer>{
	 SinhVien findByMaSVAndPass(String maSV, String pass);
	
}
