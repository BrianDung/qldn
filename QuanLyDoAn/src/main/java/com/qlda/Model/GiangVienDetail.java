package com.qlda.Model;

import java.util.Date;

public class GiangVienDetail {
	String ten;
	String sodienthoai;
	Date namsinh;
	String email;
	
	
	public GiangVienDetail(String ten, String sodienthoai, Date namsinh, String email) {
	
		this.ten = ten;
		this.sodienthoai = sodienthoai;
		this.namsinh = namsinh;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
