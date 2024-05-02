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

import com.example.model.Khoa;
import com.example.model.Lop;
import com.example.service.KhoaService;
import com.example.service.LopService;

@Controller
@RequestMapping("/lop")
public class LopController {
	@Autowired
	private LopService lopService;
	@Autowired
	private KhoaService khoaservice;
	@GetMapping("/delete")
	public String deleteMonhoc(@RequestParam("id") Integer id) {
		lopService.deleteLop(id);
		return "redirect:/admin/listLop";
	}
	
	@PostMapping("/add")
	public String saveMonhoc(@ModelAttribute Lop lop,Model model, @RequestParam("makhoa") String makhoa) {
		Khoa khoa = khoaservice.getKhoaBymaKhoa(makhoa);
		lop.setKhoa(khoa);
		lopService.saveLop(lop);
    	return "redirect:/admin/listLop";
	}
	@GetMapping("/edit")
	public String edit(Model model, @Param("id") Integer id) {
		Lop lop = lopService.getLopbyId(id);
		List<Khoa> Khoa = khoaservice.getAllKhoa();
		model.addAttribute("khoaList",Khoa);
		model.addAttribute("lop", lop);
		return "admin/edit/editLop";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute("user") Lop lop) {
		Khoa khoa = khoaservice.getKhoaBymaKhoa(lop.getKhoa().getMaKhoa());
		lop.setKhoa(khoa);
		lopService.updateLop(lop);
		return "redirect:/admin/listLop";
	}
}
