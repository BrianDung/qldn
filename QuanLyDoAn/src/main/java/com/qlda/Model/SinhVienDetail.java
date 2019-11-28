package com.qlda.Model;

import java.util.Date;

import lombok.Data;
@Data
public class SinhVienDetail { // Giao dien danh sach sinh vien lam do an
	// Sinh vien
	private Long idSv;
	private String tenSv;
	private int mssv;
	private String soDienThoaiSv;
	private String emailSv;
	private Date namSinhSv;
	private Long idTaiKhoanSv;
	// Giang vien
	private Long idGv;
	private String tenGv;
	private String soDienThoaiGv;
	private String emailGv;
	private Date namSinhGv;
	private Long idTaiKhoanGv;
	// De tai
	private Long idDetai;
	private String tenDeTai;
	// Contructor cho view Danh sach sinh vien lam do an
	public SinhVienDetail(Long idSv, String tenSv, int mssv, String emailSv, Long idGv, String tenGv, Long idDetai,
			String tenDeTai) {
		super();
		this.idSv = idSv;
		this.tenSv = tenSv;
		this.mssv = mssv;
		this.emailSv = emailSv;
		this.idGv = idGv;
		this.tenGv = tenGv;
		this.idDetai = idDetai;
		this.tenDeTai = tenDeTai;
	}
	// Contructor cho view chi tiet sinh vien lam do an
	public SinhVienDetail(Long idSv, String tenSv, int mssv, String soDienThoaiSv, String emailSv, Date namSinhSv, String tenGv,
			String soDienThoaiGv, String tenDeTai) {
		super();
		this.idSv = idSv;
		this.tenSv = tenSv;
		this.mssv = mssv;
		this.soDienThoaiSv = soDienThoaiSv;
		this.emailSv = emailSv;
		this.namSinhSv = namSinhSv;
		this.tenGv = tenGv;
		this.soDienThoaiGv = soDienThoaiGv;
		this.tenDeTai = tenDeTai;
	}
	
	
	
	
	
}
