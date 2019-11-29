package com.qlda.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TroChuyenDetail {
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
	private Date ngayTao;
	private String tenBaiDang;
	private String noiDung;
	private Long idDeTai;
	private Long idBaiDang;
	private String tenSv;
	private String tenGv;

	public TroChuyenDetail() {
		super();
	}

	public TroChuyenDetail(Date ngayTao, String tenBaiDang, String noiDung, Long idDeTai, Long idBaiDang, String tenSv,
			String tenGv) {
		super();
		this.ngayTao = ngayTao;
		this.tenBaiDang = tenBaiDang;
		this.noiDung = noiDung;
		this.idDeTai = idDeTai;
		this.idBaiDang = idBaiDang;
		this.tenSv = tenSv;
		this.tenGv = tenGv;
	}

}
