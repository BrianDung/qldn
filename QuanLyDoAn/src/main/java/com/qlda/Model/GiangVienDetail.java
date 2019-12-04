package com.qlda.Model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class GiangVienDetail {
	private String ten;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date namSinh;
	private String email;
	private String soDienThoai;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String password;
	private String role;
	
	public GiangVienDetail(String ten, Date namSinh, String email, String soDienThoai, Long id) {
		super();
		this.ten = ten;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.id = id;
	}

	public GiangVienDetail(String ten, Date namSinh, String email, String soDienThoai, String password,
			String role) {
		super();
		this.ten = ten;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
	
		this.password = password;
		this.role = role;
	}

	public GiangVienDetail() {
		super();
	}

}
