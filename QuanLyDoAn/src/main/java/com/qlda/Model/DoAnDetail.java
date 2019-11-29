package com.qlda.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayTao;
	private String trangThai;

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

}
