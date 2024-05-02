package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "thoikhoabieu")
public class ThoiKhoaBieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "monhoc")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "giaovien")
    private Giaovien giaoVien;

    @Column(name = "phong")
    private String phong;	
    
    @Column(name = "thu")
    private String thu;

    @Column(name = "giobatdau")
    private String gioBatDau;

    @Column(name = "gioketthuc")
    private String gioKetThuc;
}
