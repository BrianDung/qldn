package com.qlda.Model;

import java.util.Date;

import lombok.Data;

@Data
public class GiangVienDetail {
	private String ten;
	private Date namSinh;
	private String email;
	private String soDienThoai;
	private Long id;

	public GiangVienDetail(String ten, Date namSinh, String email, String soDienThoai, Long id) {
		super();
		this.ten = ten;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.id = id;
	}

	
}
