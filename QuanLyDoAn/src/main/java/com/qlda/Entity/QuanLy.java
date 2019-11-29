package com.qlda.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
@Entity
@Table(name = "quanly")
public class QuanLy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ten;
	private String sodienthoai;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date namsinh;
	
	@OneToOne
	@JoinColumn(name = "idtaikhoan", referencedColumnName = "id")
	private TaiKhoan taikhoan;

	public QuanLy(Long id, String ten, String sodienthoai, Date namsinh, TaiKhoan taikhoan) {
		super();
		this.id = id;
		this.ten = ten;
		this.sodienthoai = sodienthoai;
		this.namsinh = namsinh;
		this.taikhoan = taikhoan;
	}
	
	
	
}
