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
import com.example.model.Khoa;
import com.example.service.GiaovienService;
import com.example.service.KhoaService;

@Controller
@RequestMapping("/giaovien")
public class GiaovienController {
	@Autowired
	private GiaovienService giaovienservice;
	@Autowired
	private KhoaService khoaservice;
	@GetMapping("/delete")
	public String deleteGiaovien(@RequestParam("id") Integer id) {
		giaovienservice.deleteGiaovien(id);
		return "redirect:/admin/listGiaoVien";
	}
	
	@PostMapping("/add")
	public String saveSinhvien(@ModelAttribute Giaovien giaovien,Model model, @RequestParam("makhoa") String makhoa) {
		Khoa khoa = khoaservice.getKhoaBymaKhoa(makhoa);
		giaovien.setKhoa(khoa);
		giaovienservice.saveGiaovien(giaovien);
    	return "redirect:/admin/listGiaoVien";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @Param("id") Integer id) {
		Giaovien giaovien = giaovienservice.getGiaovienbyId(id);
		List<Khoa> Khoa = khoaservice.getAllKhoa();
		model.addAttribute("khoaList",Khoa);
		model.addAttribute("giaovien", giaovien);
		return "admin/edit/editGiaovien";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute("user") Giaovien giaovien) {
		Khoa khoa = khoaservice.getKhoaBymaKhoa(giaovien.getKhoa().getMaKhoa());
		giaovien.setKhoa(khoa);
		giaovienservice.updateGiaovien(giaovien);
		return "redirect:/admin/listGiaoVien";
	}
	
}
