package com.example.service;

import java.util.List;

import com.example.model.Khoa;

public interface KhoaService {
	List<Khoa> getAllKhoa();
	public void deleteKhoa(Integer id);
	public void saveKHoa(Khoa khoa);
	public void updateKhoa(Khoa khoa);
	Khoa getKhoabyId(Integer id);
	public Khoa getKhoaBymaKhoa(String makhoa);
}
