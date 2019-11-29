package com.qlda.Model;

import java.util.Date;

import lombok.Data;

@Data
public class QuanLyDetail {
	private Long id;
	private String ten;
	private String soDienThoai;
	private Date namSinh;
	private String email;

	public QuanLyDetail(Long id, String ten, String soDienThoai, Date namSinh, String email) {
		super();
		this.id = id;
		this.ten = ten;
		this.soDienThoai = soDienThoai;
		this.namSinh = namSinh;
		this.email = email;
	}

}
