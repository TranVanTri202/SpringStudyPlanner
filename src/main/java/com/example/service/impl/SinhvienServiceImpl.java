package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.SinhVien;
import com.example.repository.SinhvienRepository;
import com.example.service.SinhvienService;
@Service
public class SinhvienServiceImpl implements SinhvienService{
	@Autowired
	private SinhvienRepository repo;

	@Override
	public List<SinhVien> getAllSinhVien() {
		
		return repo.findAll();
	}

	@Override
	public void insertSinhvien(SinhVien sinhvien) {
		repo.save(sinhvien);
		
	}

	public void deleteSinhvien(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateSinhvien(SinhVien sinhvien) {
		repo.save(sinhvien);
		
	}

	@Override
	public SinhVien findByMasv(String masv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SinhVien findAllById(Integer id) {
		
		return repo.findById(id).orElse(null);
	}




}
