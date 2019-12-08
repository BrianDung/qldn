package com.qlda.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TroChuyenDetail {
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
	private Date ngayTao;
	private String tenBaiDang;
	private String noiDung;
	private Long idDeTai;
	private Long idBaiDang;
	private Long idTaiKhoan;
	private String tenSv;
	private String tenGv;
	private String tenDeTai;
	private String emailTaiKhoan;
	private MultipartFile file;

	public TroChuyenDetail() {
		super();
	}

	public TroChuyenDetail(Date ngayTao, String tenBaiDang, String noiDung, Long idDeTai, Long idBaiDang, String tenSv,
			String tenGv, String tenDeTai) {
		super();
		this.ngayTao = ngayTao;
		this.tenBaiDang = tenBaiDang;
		this.noiDung = noiDung;
		this.idDeTai = idDeTai;
		this.idBaiDang = idBaiDang;
		this.tenSv = tenSv;
		this.tenGv = tenGv;
		this.tenDeTai = tenDeTai;
	}

	public TroChuyenDetail(Date ngayTao, String tenBaiDang, String noiDung, MultipartFile file) {
		super();
		this.ngayTao = ngayTao;
		this.tenBaiDang = tenBaiDang;
		this.noiDung = noiDung;

		this.file = file;
	}

}
