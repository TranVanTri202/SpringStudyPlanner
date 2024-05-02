package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Giaovien;
import com.example.repository.GiaovienRepository;
import com.example.service.GiaovienService;
@Service
public class GiaovienServiceIml implements GiaovienService {
	@Autowired
	private GiaovienRepository giaovienRepo;
	@Override
	public List<Giaovien> getAllGiaovien() {
		return giaovienRepo.findAll();	
	}

	@Override
	public void deleteGiaovien(Integer id) {
		giaovienRepo.deleteById(id);
	}

	@Override
	public void saveGiaovien(Giaovien giaovien) {
		giaovienRepo.save(giaovien);		
	}

	@Override
	public void updateGiaovien(Giaovien giaovien) {
		giaovienRepo.save(giaovien);		
	}

	@Override
	public Giaovien getGiaovienbyId(Integer id) {		
		return giaovienRepo.findById(id).orElse(null);
	}

	@Override
	public Giaovien getGiaovienByTenGiaovien(String tenGV) {
	
		return giaovienRepo.findByTenGV(tenGV);
	}

}
