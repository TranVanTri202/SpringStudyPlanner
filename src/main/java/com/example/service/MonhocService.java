package com.example.service;

import java.util.List;

import com.example.model.MonHoc;

public interface MonhocService {
	List<MonHoc> getAllMonhoc();
	public void deleteMonhoc(Integer id);
	public void updateMonhoc(MonHoc monhoc);
	public void saveMonhoc(MonHoc monhoc);
	MonHoc getMonhocbyId(Integer id);
	public MonHoc getMonHocByTenMonHoc(String tenMH);
}
