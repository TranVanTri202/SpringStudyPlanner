package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Giaovien;
import com.example.model.Khoa;
import com.example.model.Lop;
import com.example.model.MonHoc;
import com.example.model.SinhVien;
import com.example.model.ThoiKhoaBieu;
import com.example.service.GiaovienService;
import com.example.service.KhoaService;
import com.example.service.LopService;
import com.example.service.MonhocService;
import com.example.service.SinhvienService;
import com.example.service.ThoikhoabieuService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private SinhvienService sinhvienservice;
	@Autowired
	private GiaovienService giaovienservice;
	@Autowired
	private MonhocService monhocService;
	@Autowired
	private LopService lopService;
	@Autowired
	private KhoaService khoaService;
	@Autowired
	private ThoikhoabieuService tkbService;
	
	//trang này chủ yếu hiển thị các danh sách bên trong admin
	
	@GetMapping("/listSinhVien")
	public String getAllSinhVien(Model model) {
	List<SinhVien> sinhvienList=sinhvienservice.getAllSinhVien();
	List<Lop> lopList=lopService.getAllLop();
	List<MonHoc> monhocList=monhocService.getAllMonhoc();
	model.addAttribute("monhocList",monhocList);
	model.addAttribute("lopList",lopList);
	model.addAttribute("sinhvienList",sinhvienList);
		return "admin/sinhvien_list";		
	}
	
	@GetMapping("/listGiaoVien")
	public String getAllGiaoVien(Model model) {
	List<Giaovien> giaovienList=giaovienservice.getAllGiaovien();
	List<Khoa> Khoa = khoaService.getAllKhoa();
	model.addAttribute("khoaList",Khoa);
	model.addAttribute("giaovienList",giaovienList);
		return "admin/giaovien_list";		
	}
	
	@GetMapping("/listMonHoc")
	public String getAllMonhoc(Model model) {
	List<MonHoc> monhocList=monhocService.getAllMonhoc();
	model.addAttribute("monhocList",monhocList);
		return "admin/monhoc_list";		
	}
	
	@GetMapping("/listLop")
	public String getAllLop(Model model) {
	List<Lop> lopList=lopService.getAllLop();
	List<Khoa> Khoa = khoaService.getAllKhoa();
	model.addAttribute("khoaList",Khoa);
	model.addAttribute("lopList",lopList);
		return "admin/lop_list";		
	}

	@GetMapping("/listKhoa")
	public String getAllKhoa(Model model) {
		List<Khoa> Khoa = khoaService.getAllKhoa();
		model.addAttribute("khoaList",Khoa);
		return "admin/khoa_list";	
	}
	
	@GetMapping("/listThoikhoabieu")
	public String getAlltkb(Model model) {
		List<Giaovien> giaovienList=giaovienservice.getAllGiaovien();
		List<MonHoc> monhocList=monhocService.getAllMonhoc();
		List<ThoiKhoaBieu> tkb = tkbService.getAllThoikhoabieu();
		model.addAttribute("giaovienList",giaovienList);
		model.addAttribute("monhocList",monhocList);	
		model.addAttribute("tkbList", tkb);
		return "admin/thoikhoabieu";
	}
	
}
