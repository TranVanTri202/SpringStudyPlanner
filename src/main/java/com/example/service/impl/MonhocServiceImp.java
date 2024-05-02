package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.MonHoc;
import com.example.repository.MonhocRepository;
import com.example.service.MonhocService;

@Service
public class MonhocServiceImp implements MonhocService{
	@Autowired
	private MonhocRepository monhocRepo;
	@Override
	public List<MonHoc> getAllMonhoc() {
		
		return monhocRepo.findAll();
	}

	@Override
	public void deleteMonhoc(Integer id) {
		monhocRepo.deleteById(id);
		
	}

	@Override
	public void updateMonhoc(MonHoc monhoc) {
		monhocRepo.save(monhoc);
		
	}

	@Override
	public void saveMonhoc(MonHoc monhoc) {
		monhocRepo.save(monhoc);
		
	}

	@Override
	public MonHoc getMonhocbyId(Integer id) {
		
		return monhocRepo.findById(id).orElse(null);
	}

	@Override
	public MonHoc getMonHocByTenMonHoc(String tenMH) {
		
		return monhocRepo.findByTenMH(tenMH);
	}
	
}
