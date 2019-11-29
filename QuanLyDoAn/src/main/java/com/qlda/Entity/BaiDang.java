package com.qlda.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "baidang")
public class BaiDang {

	@Id // Đánh dấu trường này là primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ten;
	private String noidung;
	private Date ngaytao;
	private String file;

	@OneToOne
	@JoinColumn(name = "iddetai", referencedColumnName = "id")
	private DeTai detai;

	@OneToOne
	@JoinColumn(name = "idTaiKhoan", referencedColumnName = "id")
	private TaiKhoan taiKhoan;

	public BaiDang(Long id, String ten, String noidung, Date ngaytao, String file) {
		super();
		this.id = id;
		this.ten = ten;
		this.noidung = noidung;
		this.ngaytao = ngaytao;
		this.file = file;
	}

}
