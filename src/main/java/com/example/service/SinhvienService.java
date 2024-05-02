package com.example.service;

import java.util.List;

import com.example.model.SinhVien;

public interface SinhvienService {

	List<SinhVien> getAllSinhVien();

	void insertSinhvien(SinhVien sinhvien);

	void deleteSinhvien(int id);

	SinhVien findAllById(Integer id);

	void updateSinhvien(SinhVien sinhvien);

	SinhVien findByMasv(String masv);


}
