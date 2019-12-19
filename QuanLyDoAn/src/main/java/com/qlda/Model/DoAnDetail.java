package com.qlda.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DoAnDetail {
	private Long idDeTai;
	private String tenDeTai;
	private Long idNhiemVu;
	private String tenNhiemVu;
	private Long idGv;
	private String tenGv;
	private Long idSv;
	private String tenSv;
	private Long idtkSv;
	private String emailSv;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayTao;
	private String moTa;
	private String noiDung;
	private String thongTin;
	private String trangThai;
	private MultipartFile file;

	public DoAnDetail() {
		super();
	}

	public DoAnDetail(Long idDeTai, String tenDeTai, Long idGv, String tenGv, Long idSv, String tenSv, Date ngayTao,
			String trangThai) {
		super();
		this.idDeTai = idDeTai;
		this.tenDeTai = tenDeTai;
		this.idGv = idGv;
		this.tenGv = tenGv;
		this.idSv = idSv;
		this.tenSv = tenSv;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
	}

	public DoAnDetail(Long idDeTai, Long idSv, String tenSv, Long idtkSv, String emailSv, String tenDeTai) {
		super();
		this.idDeTai = idDeTai;

		this.idSv = idSv;
		this.tenSv = tenSv;
		this.idtkSv = idtkSv;
		this.emailSv = emailSv;
		this.tenDeTai = tenDeTai;
	}

}
