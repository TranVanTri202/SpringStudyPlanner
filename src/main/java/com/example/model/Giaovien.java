package com.example.model;


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
@Table(name = "giaovien")

public class Giaovien {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
		
	    @Column(name = "magv")
	    private String maGV;

	    @Column(name = "tengv")
	    private String tenGV;

	    @Column(name = "chuyennghanh")
	    private String chuyenNghanh;
	    
	    @Column(name = "diachi")
	    private String diaChi;
	    
	    @Column(name = "gioitinh")
	    private String gioiTinh;
	    
	    @ManyToOne
	    @JoinColumn(name = "makhoa")
	    private Khoa khoa;
}
