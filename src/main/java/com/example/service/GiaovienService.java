package com.example.service;

import java.util.List;

import com.example.model.Giaovien;


public interface GiaovienService {
	List<Giaovien> getAllGiaovien();
	public void deleteGiaovien(Integer id);
	public void saveGiaovien(Giaovien giaovien);
	public void updateGiaovien(Giaovien giaovien);
	Giaovien getGiaovienbyId(Integer id);	
	public Giaovien getGiaovienByTenGiaovien(String tenGV);
}
