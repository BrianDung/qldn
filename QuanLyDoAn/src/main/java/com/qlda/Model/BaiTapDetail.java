package com.qlda.Model;

import java.util.Date;

import lombok.Data;

@Data
public class BaiTapDetail {
	private Long idNhiemVu;
	private String tenNhiemVu;
	private String trangThai;
	private String fileBaiTap;
	private String fileHuongDan;
	private Date ngayTao;
	private Long idDanhGia;
	private int tieuChi1;
	private int tieuChi2;
	private int tieuChi3;

	public BaiTapDetail(Long idNhiemVu, String tenNhiemVu, String trangThai, String fileBaiTap, String fileHuongDan,
			Date ngayTao, Long idDanhGia, int tieuChi1, int tieuChi2, int tieuChi3) {
		super();
		this.idNhiemVu = idNhiemVu;
		this.tenNhiemVu = tenNhiemVu;
		this.trangThai = trangThai;
		this.fileBaiTap = fileBaiTap;
		this.fileHuongDan = fileHuongDan;
		this.ngayTao = ngayTao;
		this.idDanhGia = idDanhGia;
		this.tieuChi1 = tieuChi1;
		this.tieuChi2 = tieuChi2;
		this.tieuChi3 = tieuChi3;
	}

	public BaiTapDetail() {
		super();
	}

}
