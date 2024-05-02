package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ThoiKhoaBieu;
import com.example.repository.ThoikhoabieuRepository;
import com.example.service.ThoikhoabieuService;

@Service
public class ThoikhoabieuServiceIml implements ThoikhoabieuService {
	@Autowired
	private ThoikhoabieuRepository tkbRepo;
	@Override
	public List<ThoiKhoaBieu> getAllThoikhoabieu() {
		
		return tkbRepo.findAll();
	}

	@Override
	public void deleteThoikhoabieu(Integer id) {
		tkbRepo.deleteById(id);
		
	}

	@Override
	public void saveThoikhoabieu(ThoiKhoaBieu thoikhoabieu) {
	tkbRepo.save(thoikhoabieu);
		
	}

	@Override
	public void updateThoikhoabieu(ThoiKhoaBieu thoikhoabieu) {
		tkbRepo.save(thoikhoabieu);
		
	}

	@Override
	public ThoiKhoaBieu getThoikhoabieuById(Integer id) {
		
		return tkbRepo.findById(id).orElse(null);
	}
	
}
