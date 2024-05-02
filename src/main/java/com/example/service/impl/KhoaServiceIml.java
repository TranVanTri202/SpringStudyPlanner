package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Khoa;
import com.example.repository.KhoaRepository;
import com.example.service.KhoaService;
@Service
public class KhoaServiceIml implements KhoaService {
	@Autowired
	private KhoaRepository khoaRepo;
	@Override
	public List<Khoa> getAllKhoa() {
		
		return khoaRepo.findAll();
	}

	@Override
	public void deleteKhoa(Integer id) {
		khoaRepo.deleteById(id);
		
	}

	@Override
	public void saveKHoa(Khoa khoa) {
		khoaRepo.save(khoa);
		
	}

	@Override
	public void updateKhoa(Khoa khoa) {
		khoaRepo.save(khoa);
		
	}

	@Override
	public Khoa getKhoabyId(Integer id) {
		
		return khoaRepo.findById(id).orElse(null);
	}

	@Override
	public Khoa getKhoaBymaKhoa(String makhoa) {		
		return khoaRepo.findByMaKhoa(makhoa);
	}

	

}
