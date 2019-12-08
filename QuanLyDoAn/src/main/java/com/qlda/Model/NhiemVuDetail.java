package com.qlda.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NhiemVuDetail {
	private Long idSinhVien;
	private String tenSinhVien;
	private Long idGiangVien;
	private Long idNhiemVu;
	private String tenNhiemVu;
	private String noiDungNhiemVu;
	private String trangThai;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayTao;
	private MultipartFile fileHd;
	private MultipartFile fileBt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hanNop;
	private Long idDeTai;
	private String tenDeTai;

	public NhiemVuDetail() {
		super();
	}

	public NhiemVuDetail(Long idSinhVien, String tenSinhVien, Long idGiangVien, String tenNhiemVu,
			String noiDungNhiemVu, String trangThai, Date ngayTao, MultipartFile fileHd, MultipartFile fileBt, Date hanNop,
			Long idDeTai) {
		super();
		this.idSinhVien = idSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.idGiangVien = idGiangVien;
		this.tenNhiemVu = tenNhiemVu;
		this.noiDungNhiemVu = noiDungNhiemVu;
		this.trangThai = trangThai;
		this.ngayTao = ngayTao;
		this.fileHd = fileHd;
		this.fileBt = fileBt;
		this.hanNop = hanNop;
		this.idDeTai = idDeTai;
	}

	// View danh sach nhiem vu
	public NhiemVuDetail(String tenNhiemVu, String tenSinhVien, String trangThai, Date ngayTao, Date hanNop, Long idDeTai, String tenDeTai,
			Long idGiangVien, Long idNhiemVu) {
		super();
		this.tenSinhVien = tenSinhVien;
		this.trangThai = trangThai;
		this.ngayTao = ngayTao;
		this.hanNop = hanNop;
		this.idDeTai = idDeTai;
		this.tenDeTai = tenDeTai;
		this.idGiangVien = idGiangVien;
		this.idNhiemVu = idNhiemVu;
		this.tenNhiemVu = tenNhiemVu;
		
	}

}
