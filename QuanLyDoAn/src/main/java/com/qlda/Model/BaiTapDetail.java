package com.qlda.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BaiTapDetail {
	private Long idNhiemVu;
	private Long idDeTai;
	private String tenNhiemVu;
	private String fileBaiTap;
	private String fileHuongDan;
	private String tenSinhVien;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayTao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hanNop;
	private String noiDungNhiemVu;
	private String noiDungDanhGia;
	private String fileDanhGia;
	private int tieuChi1;
	private int tieuChi2;
	private int tieuChi3;
	private Long idDanhGia;
	private Long idGv;
	public BaiTapDetail() {
		super();
	}

	// View danh sach bai tap
	public BaiTapDetail(Long idDeTai, String tenNhiemVu, String fileBaiTap, String fileHuongDan, String tenSinhVien,
			Date ngayTao, int tieuChi1, int tieuChi2, int tieuChi3, Long idDanhGia, Long idNhiemVu) {
		super();
		this.idDeTai = idDeTai;
		this.tenNhiemVu = tenNhiemVu;
		this.fileBaiTap = fileBaiTap;
		this.fileHuongDan = fileHuongDan;
		this.tenSinhVien = tenSinhVien;
		this.ngayTao = ngayTao;
		this.tieuChi1 = tieuChi1;
		this.tieuChi2 = tieuChi2;
		this.tieuChi3 = tieuChi3;
		this.idDanhGia = idDanhGia;
		this.idNhiemVu = idNhiemVu;
	}
	
	
	public BaiTapDetail(Long idDeTai, String tenNhiemVu, String fileBaiTap, String fileHuongDan, String tenSinhVien,
			Date ngayTao, int tieuChi1, int tieuChi2, int tieuChi3, Long idDanhGia, Long idNhiemVu, Long idGv) {
		super();
		this.idDeTai = idDeTai;
		this.tenNhiemVu = tenNhiemVu;
		this.fileBaiTap = fileBaiTap;
		this.fileHuongDan = fileHuongDan;
		this.tenSinhVien = tenSinhVien;
		this.ngayTao = ngayTao;
		this.tieuChi1 = tieuChi1;
		this.tieuChi2 = tieuChi2;
		this.tieuChi3 = tieuChi3;
		this.idDanhGia = idDanhGia;
		this.idNhiemVu = idNhiemVu;
		this.idGv = idGv;
	}
	
	

	// View Chi tiet bai tap va danh gia
	public BaiTapDetail(Long idNhiemVu, String tenNhiemVu, String fileHuongDan, Date hanNop, String noiDungNhiemVu,
			String noiDungDanhGia, String fileDanhGia, int tieuChi1, int tieuChi2, int tieuChi3) {
		super();
		this.idNhiemVu = idNhiemVu;
		this.tenNhiemVu = tenNhiemVu;
		this.fileHuongDan = fileHuongDan;
		this.hanNop = hanNop;
		this.noiDungNhiemVu = noiDungNhiemVu;
		this.noiDungDanhGia = noiDungDanhGia;
		this.fileDanhGia = fileDanhGia;
		this.tieuChi1 = tieuChi1;
		this.tieuChi2 = tieuChi2;
		this.tieuChi3 = tieuChi3;
	}

	public BaiTapDetail(Long idNhiemVu, Long idDeTai, String tenNhiemVu, String fileBaiTap, String fileHuongDan,
			String tenSinhVien, Date ngayTao, Date hanNop, String noiDungNhiemVu, Long idGv) {
		super();
		this.idNhiemVu = idNhiemVu;
		this.idDeTai = idDeTai;
		this.tenNhiemVu = tenNhiemVu;
		this.fileBaiTap = fileBaiTap;
		this.fileHuongDan = fileHuongDan;
		this.tenSinhVien = tenSinhVien;
		this.ngayTao = ngayTao;
		this.hanNop = hanNop;
		this.noiDungNhiemVu = noiDungNhiemVu;
		this.idGv = idGv;
	}
	
	

}
