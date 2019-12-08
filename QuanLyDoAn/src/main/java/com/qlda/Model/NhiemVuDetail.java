package com.qlda.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NhiemVuDetail {
	private Long idSinhVien;
	private String tenSinhVien;
	private Long idGiangVien;
	private String tenNhiemVu;
	private String noiDungNhiemVu;
	private String trangThai;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayTao;
	private String fileHd;
	private String fileBt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hanNop;
	private Long idDeTai;

	public NhiemVuDetail() {
		super();
	}

	public NhiemVuDetail(Long idSinhVien, String tenSinhVien, Long idGiangVien, String tenNhiemVu,
			String noiDungNhiemVu, String trangThai, Date ngayTao, String fileHd, String fileBt, Date hanNop,
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

}
