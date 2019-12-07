package com.qlda.Model;

import lombok.Data;

@Data
public class DanhGiaDetail {
	private String tenDanhGia;
	private String noiDung;

	private int tieuChi1;
	private int tieuChi2;
	private int tieuChi3;
	private String file;
	private Long idNhiemVu;

	public DanhGiaDetail() {
		super();
	}

}
