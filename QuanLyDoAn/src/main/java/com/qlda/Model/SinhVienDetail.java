package com.qlda.Model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SinhVienDetail { // Giao dien danh sach sinh vien lam do an
	// Sinh vien
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idSv;
	private String tenSv;
	private int mssv;
	private String soDienThoaiSv;
	private String emailSv;
	private String password;
	private String role;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date namSinhSv;
	private Long idTaiKhoanSv;
	// Giang vien
	private Long idGv;
	private String tenGv;
	private String soDienThoaiGv;
	private String emailGv;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date namSinhGv;
	private Long idTaiKhoanGv;
	// De tai
	private Long idDeTai;
	private String tenDeTai;

	// Nhiem vu
	private Long idNhiemVu;
	private String tenNhiemVu;

	// Contructor cho view Danh sach sinh vien lam do an
	public SinhVienDetail(Long idSv, String tenSv, int mssv, String emailSv, Long idGv, String tenGv, Long idDeTai,
			String tenDeTai) {
		super();
		this.idSv = idSv;
		this.tenSv = tenSv;
		this.mssv = mssv;
		this.emailSv = emailSv;
		this.idGv = idGv;
		this.tenGv = tenGv;
		this.idDeTai = idDeTai;
		this.tenDeTai = tenDeTai;
	}

	// Contructor cho view chi tiet sinh vien lam do an
	public SinhVienDetail(Long idSv, String tenSv, int mssv, String soDienThoaiSv, String emailSv, Date namSinhSv,
			String tenGv, String soDienThoaiGv, String tenDeTai) {
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

	public SinhVienDetail() {
		super();
	}

	public SinhVienDetail(Long idSv, String tenSv, int mssv, String soDienThoaiSv, String emailSv, Long idDeTai,
			String tenDeTai, Long idNhiemVu, String tenNhiemVu) {
		super();
		this.idSv = idSv;
		this.tenSv = tenSv;
		this.mssv = mssv;
		this.soDienThoaiSv = soDienThoaiSv;
		this.emailSv = emailSv;
		this.idDeTai = idDeTai;
		this.tenDeTai = tenDeTai;
		this.idNhiemVu = idNhiemVu;
		this.tenNhiemVu = tenNhiemVu;
	}

}
