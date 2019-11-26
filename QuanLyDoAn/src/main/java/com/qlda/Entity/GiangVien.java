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
@Table(name = "giangvien")
public class GiangVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ten;
	private String sodienthoai;
	private Date namsinh;
	
	@OneToOne
	@JoinColumn(name = "idtaikhoan", referencedColumnName = "id")
	private TaiKhoan taikhoan;

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

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public Date getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(Date namsinh) {
		this.namsinh = namsinh;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
	
}
