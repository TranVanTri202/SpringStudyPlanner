package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Giaovien;
import com.example.model.MonHoc;
import com.example.model.ThoiKhoaBieu;
import com.example.service.GiaovienService;
import com.example.service.MonhocService;
import com.example.service.ThoikhoabieuService;

@Controller
@RequestMapping("/tkb")
public class ThoikhoabieuController {
	@Autowired
	private ThoikhoabieuService tkbService;
	@Autowired
	private GiaovienService giaovienService;
	@Autowired
	private MonhocService monhocService;
	
	@PostMapping("/add")
	public String savetkb(@ModelAttribute ThoiKhoaBieu tkb,Model model, @RequestParam("tenGV") String tenGV,@RequestParam("tenMH") String tenMH) {
		Giaovien giaovien = giaovienService.getGiaovienByTenGiaovien(tenGV);
		MonHoc monhoc = monhocService.getMonHocByTenMonHoc(tenMH);
		tkb.setGiaoVien(giaovien);
		tkb.setMonHoc(monhoc);
		tkbService.saveThoikhoabieu(tkb);
    	return "redirect:/admin/listThoikhoabieu";
	}
	
	@GetMapping("/delete")
	public String deletetkb(@RequestParam("id") Integer id) {
		tkbService.deleteThoikhoabieu(id);
		return "redirect:/admin/listThoikhoabieu";
	}
	
	@GetMapping("/edit")
	public String editTKB(Model model, @Param("id") Integer id) {
		ThoiKhoaBieu tkb = tkbService.getThoikhoabieuById(id);
		List<Giaovien> giaovien = giaovienService.getAllGiaovien();
		List<MonHoc> monhoc = monhocService.getAllMonhoc();
		model.addAttribute("giaovienList", giaovien);
		model.addAttribute("monhocList",monhoc);
		model.addAttribute("tkb", tkb);
		return "admin/edit/editTKB";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute("user") ThoiKhoaBieu tkb) {
		Giaovien giaovien = giaovienService.getGiaovienByTenGiaovien(tkb.getGiaoVien().getTenGV());
		MonHoc monhoc = monhocService.getMonHocByTenMonHoc(tkb.getMonHoc().getTenMH());
		tkb.setGiaoVien(giaovien);
		tkb.setMonHoc(monhoc);
		tkbService.updateThoikhoabieu(tkb);
		return  "redirect:/admin/listThoikhoabieu";
	}
}
