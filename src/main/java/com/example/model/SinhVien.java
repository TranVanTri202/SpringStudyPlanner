package com.example.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sinhvien")
public class SinhVien {

	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    @Column(name = "masv")
	    private String maSV;

	    @Column(name = "tensv")
	    private String tenSV;

	    @Column(name = "gioitinh")
	    private String gioiTinh;

	    @Column(name = "ngaysinh")
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date ngaySinh;
	    
	    @Column(name = "anh")
	    private String anh;

	    @Column(name = "diachi")
	    private String diaChi;	
	    
	    @Column(name = "sodienthoai")
	    private String soDienthoai;
	    
	    @Column(name = "dantoc")
	    private String danToc;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "nienkhoa")
	    private String nienKhoa;
	    
	    @Column(name = "cmnd")
	    private String cmnd;
	    
	    @Column(name = "pass")
	    private String pass;
	    
	    @Column(name = "role")
	    private String role;
	    
	    @Column(name = "allow")
	    private Boolean allow ;
	    
	    @ManyToOne
	    @JoinColumn(name = "malop")
	    private Lop lop;
	    
	    @ManyToOne
	    @JoinColumn(name = "tenmonhoc")
	    private MonHoc monHoc;
}
