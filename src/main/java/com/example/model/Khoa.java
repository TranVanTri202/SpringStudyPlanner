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
@Table(name = "khoa")
public class Khoa {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    @Column(name = "makhoa")
	    private String maKhoa;

	    @Column(name = "tenkhoa")
	    private String tenKhoa;
}
