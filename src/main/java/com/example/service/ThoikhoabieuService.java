package com.example.service;

import java.util.List;
import com.example.model.ThoiKhoaBieu;

public interface ThoikhoabieuService {
	List<ThoiKhoaBieu> getAllThoikhoabieu();
	public void deleteThoikhoabieu(Integer id);
	public void saveThoikhoabieu(ThoiKhoaBieu thoikhoabieu);
	public void updateThoikhoabieu(ThoiKhoaBieu thoikhoabieu);
	ThoiKhoaBieu getThoikhoabieuById(Integer id);	
}
