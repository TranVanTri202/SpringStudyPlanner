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
import com.example.model.Lop;
import com.example.model.MonHoc;
import com.example.model.SinhVien;
import com.example.model.ThoiKhoaBieu;
import com.example.repository.SinhvienRepository;
import com.example.service.GiaovienService;
import com.example.service.KhoaService;
import com.example.service.LopService;
import com.example.service.MonhocService;
import com.example.service.SinhvienService;
import com.example.service.ThoikhoabieuService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sinhvien")
public class SinhvienController {
	@Autowired
	private SinhvienRepository sinhvienRepo;
	@Autowired
	private SinhvienService service;
	@Autowired
	private LopService lopService;
	@Autowired
	private GiaovienService giaovienService;
	@Autowired
	private KhoaService khoaService;
	@Autowired
	private MonhocService monhocService;
	@Autowired
	private ThoikhoabieuService tkbService;
	
	 @GetMapping("/login")
	    public String showLoginPage() {
	        return "login/login"; 
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
	     session.removeAttribute("loggedInUser"); //xóa sinh viên khỏi session khi đăng xuất
	     return "redirect:/sinhvien/login";
	 }
	 
	 @PostMapping("/login")
	 public String processLogin(@RequestParam("maSV") String username, @RequestParam("pass") String password, HttpSession session, Model model) {
	     String trimUsername = username.trim(); //xóa khoảng trống
	     String trimPassword = password.trim(); // xóa khoảng trống

	     if (trimUsername.isEmpty() || trimPassword.isEmpty()) {
	         model.addAttribute("error5", "Chưa nhập tên hoặc mã sinh viên");
	         return "login/login";
	     }

	     SinhVien sinhVien = sinhvienRepo.findByMaSVAndPass(trimUsername, trimPassword);
	     if (sinhVien != null) {
	         session.setAttribute("loggedInUser", sinhVien);
	         if (sinhVien.getRole().equals("admin")) {
	             return "redirect:/sinhvien/adminhome";
	         } else {
	             if (sinhVien.getLop() != null) {
	                 session.setAttribute("maLop", sinhVien.getLop().getMaLop());
	                 session.setAttribute("tenMH", sinhVien.getMonHoc().getTenMH());
	             }
	             return "redirect:/sinhvien/home";
	         }
	     } else {
	         model.addAttribute("error", "Sai mật khẩu hoặc tên đăng nhập");
	         return "login/login";
	     }
	 }

	 	 
	@GetMapping("/adminhome") //trang home của admin, hiện tổng số các danh sách
	public String getAllSinhVien(Model model) {
	List<SinhVien> sinhvienList=service.getAllSinhVien();
	List<Lop> lopList = lopService.getAllLop();
	List<MonHoc> monhocList = monhocService.getAllMonhoc();
	List<Giaovien> giaovienList = giaovienService.getAllGiaovien();
	List<Khoa> khoaList = khoaService.getAllKhoa();
	model.addAttribute("khoaList", khoaList);
	model.addAttribute("monhocList",monhocList);
	model.addAttribute("giaovienList", giaovienList);
	model.addAttribute("lopList", lopList);
	model.addAttribute("sinhvienList",sinhvienList);
		return "admin/home";		
	}
	
	
	@PostMapping("/add") //thêm sinh viên
	public String saveSinhvien(@ModelAttribute SinhVien sinhVien, Model model, @RequestParam("maLop") String maLop,@RequestParam("tenMH") String tenMH) {
	if (sinhVien.getAllow() == null) { //xét nếu allow kh null, tất là checkbox được quyèn chỉnh sửa thông tin được click
	sinhVien.setAllow(false);
	}
	boolean allow = sinhVien.getAllow();
	sinhVien.setAllow(allow);
	MonHoc monhoc = monhocService.getMonHocByTenMonHoc(tenMH);
	Lop lop = lopService.getLopByMaLop(maLop);
	sinhVien.setMonHoc(monhoc);
	sinhVien.setLop(lop);
	List<Lop> lopList = lopService.getAllLop();
	model.addAttribute("lopList", lopList);
	service.insertSinhvien(sinhVien);
	return "redirect:/admin/listSinhVien";
	}		

	@GetMapping("/delete")
	public String deleteSinhvien(@RequestParam("id") Integer id) {
		service.deleteSinhvien(id);
		return "redirect:/admin/listSinhVien";
	}
		 
	 @GetMapping("/edit")
	 public String edit(Model model, @Param("id") Integer id) {
	     SinhVien sinhvien = service.findAllById(id);
	     List<Lop> lopList = lopService.getAllLop();
	     List<MonHoc> monhoc = monhocService.getAllMonhoc();
		 model.addAttribute("monhocList",monhoc);
	     model.addAttribute("lopList", lopList);
	     model.addAttribute("sinhvien", sinhvien);
	     return "admin/edit/editSinhvien";
	 }

	 @PostMapping("/edit")
	 public String edit(@ModelAttribute("sinhvien") SinhVien sinhvien) {
	     Lop lop = lopService.getLopByMaLop(sinhvien.getLop().getMaLop());
	     MonHoc monhoc = monhocService.getMonHocByTenMonHoc(sinhvien.getMonHoc().getTenMH());
	     sinhvien.setMonHoc(monhoc);
	     sinhvien.setLop(lop);
	     service.updateSinhvien(sinhvien);
	     return "redirect:/admin/listSinhVien";
	 }
	 
	 @GetMapping("/home") //dô trang thông tin sinh viên
	    public String showProfile(HttpSession session, Model model) {
	        SinhVien sinhVien = (SinhVien) session.getAttribute("loggedInUser");// gọi thông tin sinh viên trong session ra
	        String maLop = (String) session.getAttribute("maLop");
	        if (sinhVien != null) {
	            model.addAttribute("sinhVien", sinhVien);
	            model.addAttribute("maLop", maLop); 
	            return "sinhvien/home";
	        } else {
	            return "login/login";
	        }
	    }
	 
	 @GetMapping("/doimatkhau") //đổi mật khẩu bên trang sinh viên
	    public String showDoiMatKhau(HttpSession session, Model model) {
	        SinhVien sinhVien = (SinhVien) session.getAttribute("loggedInUser");
	        if (sinhVien != null) {
	            model.addAttribute("sinhVien", sinhVien);
	            return "sinhvien/doimatkhau";
	        } else {
	            return "login/login";
	        }
	    }

	 @PostMapping("/doimatkhau")
	 public String doiMatKhau(@RequestParam("pass") String currentPass, @RequestParam("newPass") String newPass, @RequestParam("newPass2") String newPass2, HttpSession session, Model model) {
	     SinhVien sinhVien = (SinhVien) session.getAttribute("loggedInUser");
	     if (sinhVien != null) {
	         if (!sinhVien.getPass().equals(currentPass)) {
	             model.addAttribute("error", "Mật khẩu hiện tại không chính xác");
	             return "sinhvien/doimatkhau";
	         } else if (!newPass.equals(newPass2)) {
	             model.addAttribute("error2", "Mật khẩu mới chưa khớp");
	             return "sinhvien/doimatkhau";
	         } else {
	             sinhVien.setPass(newPass);
	             sinhvienRepo.save(sinhVien);
	             model.addAttribute("error3", "Thay đổi mật khẩu thành công");
	              return "sinhvien/doimatkhau";
	         }
	     } else {
	         return "login/login";
	     }
	 } 
	 
	@GetMapping("/doithongtin")
	public String doithongtin(Model model,  HttpSession session) {
		SinhVien sinhVien = (SinhVien) session.getAttribute("loggedInUser");
		 if (sinhVien != null) {
	            model.addAttribute("sinhVien", sinhVien);
	            return "sinhvien/doithongtincanhan";
	        } else {
	            return "login/login";
	        }

	
	}
	@PostMapping("/doithongtin")
	public String processDoiThongTin(@ModelAttribute("sinhVien") SinhVien sinhVienForm, HttpSession session) {
	    // Lấy thông tin sinh viên từ session
	    SinhVien sinhVien = (SinhVien) session.getAttribute("loggedInUser");	    
	    // Cập nhật thông tin chỉnh sửa
	    sinhVien.setMaSV(sinhVienForm.getMaSV());
	    sinhVien.setTenSV(sinhVienForm.getTenSV());
	    sinhVien.setGioiTinh(sinhVienForm.getGioiTinh());
	    sinhVien.setNgaySinh(sinhVienForm.getNgaySinh());
	    sinhVien.setEmail(sinhVienForm.getEmail());
	    sinhVien.setSoDienthoai(sinhVienForm.getSoDienthoai());
	    sinhVien.setDiaChi(sinhVienForm.getDiaChi());
	    sinhVien.setDanToc(sinhVienForm.getDanToc());
	    sinhVien.setCmnd(sinhVienForm.getCmnd());
	    if (sinhVienForm.getAnh() == null) {
	        sinhVien.setAnh(sinhVien.getAnh());
	    } else {
	        sinhVien.setAnh(sinhVienForm.getAnh());
	    }	    // Lưu lại sinh viên đã chỉnh sửa vào session
	    session.setAttribute("loggedInUser", sinhVien);	    
	    service.insertSinhvien(sinhVien);  
	    return "redirect:/sinhvien/home";
	}
	
	@GetMapping("/danhsachGV")
	public String danhsachGiaovien(Model model) {
		List<Giaovien> gv = giaovienService.getAllGiaovien();
		model.addAttribute("listgv", gv);
		return "sinhvien/danhsachGiaovien";
	}
	
	@GetMapping("/danhsachMH")
	public String danhsachMonhoc(Model model) {
		List<MonHoc> mh = monhocService.getAllMonhoc();
		model.addAttribute("listmh", mh);
		return "sinhvien/danhsachMonhoc";
	}
	
	@GetMapping("/thoikhoabieu")
	public String xemtkb(Model model) {
		List<ThoiKhoaBieu> tkb = tkbService.getAllThoikhoabieu();
		model.addAttribute("tkbList", tkb);
		return "sinhvien/danhsachThoikhoabieu";
	}
	
	@GetMapping("/thoikhoabieuCanhan")
	public String xemtkbCanhan(Model model,HttpSession session) {
		SinhVien sinhVien = (SinhVien) session.getAttribute("loggedInUser");
	    String tenMH = "";
	    if (sinhVien != null && sinhVien.getMonHoc() != null) {
	        tenMH = sinhVien.getMonHoc().getTenMH();
	    }
	    model.addAttribute("sinhVien", sinhVien);
	    model.addAttribute("tenMH", tenMH);
	    
	    List<ThoiKhoaBieu> tkb = tkbService.getAllThoikhoabieu();
	    model.addAttribute("tkbList", tkb);
	    
	    return "sinhvien/thoikhoabieuCanhan";
	}
	
	
	@GetMapping("/tintuc")
	public String tintuc() {
		return "sinhvien/tintuc";
	}
 }
