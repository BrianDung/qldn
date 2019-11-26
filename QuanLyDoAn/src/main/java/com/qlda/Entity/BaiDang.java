package com.qlda.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Detai detai;

	@OneToOne
	@JoinColumn(name = "idTaiKhoan", referencedColumnName = "id")
	private TaiKhoan taiKhoan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Detai getDetai() {
		return detai;
	}

	public void setDetai(Detai detai) {
		this.detai = detai;
	}
}
