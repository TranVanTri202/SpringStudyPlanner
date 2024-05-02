package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "monhoc")
public class MonHoc {
	 	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    @Column(name = "mamh")
	    private String maMH;

	    @Column(name = "tenmh")
	    private String tenMH;

	    @Column(name = "sogio")
	    private Integer soGio;
}
