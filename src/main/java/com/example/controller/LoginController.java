//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.model.SinhVien;
//import com.example.repository.SinhvienRepository;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class LoginController {
//	@Autowired
//	private SinhvienRepository sinhvienRepo;
//	 @GetMapping("/login")
//	    public String showLoginPage() {
//	        return "login/login.html"; // Trả về view login.html
//	 }
//	 
//	 @PostMapping("/login")
//	    public String processLogin(@RequestParam("maSV") String username, @RequestParam("pass") String password, HttpSession session,Model model) {
//	        SinhVien sinhVien = sinhvienRepo.findByMaSVAndPass(username, password);
//	        
//	        if (sinhVien != null) {
//	            session.setAttribute("loggedInUser", sinhVien);
//	            if(sinhVien.getRole().equals("admin")) {
//	            	return "redirect://sinhvien/list";
//	            } else {
//	            	return "redirect:/sinhvien/home";	            	
//	            }
//	        } else {
//	        	 model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
//	            return "login/login";
//	        }
//	    }
//}
