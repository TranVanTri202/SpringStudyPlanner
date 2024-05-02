package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.model.MonHoc;
import com.example.service.MonhocService;

@Controller
@RequestMapping("/monhoc")
public class MonhocController {
	@Autowired
	private MonhocService monhocService;
	
	@GetMapping("/delete")
	public String deleteMonhoc(@RequestParam("id") Integer id) {
		monhocService.deleteMonhoc(id);
		return "redirect:/admin/listMonHoc";
	}
	
	@PostMapping("/add")
	public String saveMonhoc(@ModelAttribute MonHoc monhoc) {
		monhocService.saveMonhoc(monhoc);
    	return "redirect:/admin/listMonHoc";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @Param("id") Integer id) {
		MonHoc monhoc =monhocService.getMonhocbyId(id);
		model.addAttribute("monhoc", monhoc);
		return "admin/edit/editMonhoc";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute("user") MonHoc monhoc) {
		monhocService.updateMonhoc(monhoc);
		return "redirect:/admin/listMonHoc";
	}
}
