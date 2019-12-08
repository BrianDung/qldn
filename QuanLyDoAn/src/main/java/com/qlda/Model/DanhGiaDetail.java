package com.qlda.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DanhGiaDetail {
	private String tenDanhGia;
	private String noiDung;

	private int tieuChi1;
	private int tieuChi2;
	private int tieuChi3;
	private String file;
	private String trangThai;

	private Long idNhiemVu;
	private Long idSinhVien;
	private Long idGiangVien;
	private Long idDanhGia;
	private Long idDeTai;
	private Long idBaiDang;
	private String tenDeTai;
	private String tenSinhVien;
	private String tenNhiemVu;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hanNop;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayTao;

	public DanhGiaDetail() {
		super();
	}

	public DanhGiaDetail(Long idNhiemVu, Long idSinhVien, Long idGiangVien, Long idDanhGia, Long idDeTai,
			String tenDeTai, String tenSinhVien, String trangThai, String file, int tieuChi1, int tieuChi2,
			int tieuChi3, Date hanNop, Date ngayTao, String tenNhiemVu) {
		super();
		this.idNhiemVu = idNhiemVu;
		this.idSinhVien = idSinhVien;
		this.idGiangVien = idGiangVien;
		this.idDanhGia = idDanhGia;
		this.idDeTai = idDeTai;
		this.tenDeTai = tenDeTai;
		this.tenSinhVien = tenSinhVien;
		this.trangThai = trangThai;
		this.file = file;
		this.tieuChi1 = tieuChi1;
		this.tieuChi2 = tieuChi2;
		this.tieuChi3 = tieuChi3;
		this.hanNop = hanNop;
		this.ngayTao = ngayTao;
		this.tenNhiemVu = tenNhiemVu;

	}
}
