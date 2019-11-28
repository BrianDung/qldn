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
@Table(name = "sinhvien")
public class SinhVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int mssv;
	private String ten;
	private Date namsinh;
	private String sodienthoai;
	
	@OneToOne
	@JoinColumn(name = "idtaikhoan", referencedColumnName = "id")
	private TaiKhoan taikhoan;
	
	@OneToOne
	@JoinColumn(name = "idgiangvien", referencedColumnName = "id")
	private GiangVien giangvien;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(Date namsinh) {
		this.namsinh = namsinh;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	public GiangVien getGiangvien() {
		return giangvien;
	}

	public void setGiangvien(GiangVien giangvien) {
		this.giangvien = giangvien;
	}

	public SinhVien(Long id, int mssv, String ten, Date namsinh, String sodienthoai) {
		super();
		this.id = id;
		this.mssv = mssv;
		this.ten = ten;
		this.namsinh = namsinh;
		this.sodienthoai = sodienthoai;
	}
	
	
}
