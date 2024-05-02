package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Lop;
import com.example.repository.LopRepository;
import com.example.service.LopService;

@Service
public class LopServiceImp implements LopService {
	@Autowired
	private LopRepository lopRepo;

	@Override
	public List<Lop> getAllLop() {
		
		return lopRepo.findAll();
	}

	@Override
	public void deleteLop(Integer id) {
		lopRepo.deleteById(id);
		
	}

	@Override
	public void saveLop(Lop lop) {
		lopRepo.save(lop);
		
	}

	@Override
	public void updateLop(Lop lop) {
		lopRepo.save(lop);
	}

	@Override
	public Lop getLopbyId(Integer id) {
		// TODO Auto-generated method stub
		return lopRepo.findById(id).orElse(null);
	}

	@Override
	public Lop getLopByMaLop(String maLop) {
		
		return lopRepo.findByMaLop(maLop);
	}
	
	
}
