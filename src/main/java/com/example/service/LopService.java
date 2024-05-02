package com.example.service;

import java.util.List;

import com.example.model.Lop;

public interface LopService {
	List<Lop> getAllLop();
	public void deleteLop(Integer id);
	public void saveLop(Lop lop);
	public void updateLop(Lop lop);
	Lop getLopbyId(Integer id);
	public Lop getLopByMaLop(String maLop);
}
