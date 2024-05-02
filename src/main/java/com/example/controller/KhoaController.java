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
import com.example.model.Khoa;
import com.example.service.KhoaService;

@Controller
@RequestMapping("/khoa")
public class KhoaController {
	@Autowired
	private KhoaService khoaService;
	
	@GetMapping("/delete")
	public String deleteKhoa(@RequestParam("id") Integer id) {
		khoaService.deleteKhoa(id);
		return "redirect:/admin/listKhoa";
	}
	
	@PostMapping("/add")
	public String saveMonhoc(@ModelAttribute Khoa khoa) {
		khoaService.saveKHoa(khoa);
    	return "redirect:/admin/listKhoa";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, @Param("id") Integer id) {
		Khoa khoa =khoaService.getKhoabyId(id);
		model.addAttribute("khoa", khoa);
		return "admin/edit/editKhoa";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute("user") Khoa khoa) {
		khoaService.updateKhoa(khoa);
		return "redirect:/admin/listKhoa";
	}
}
