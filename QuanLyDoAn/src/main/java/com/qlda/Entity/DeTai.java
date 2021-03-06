package com.qlda.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "detai")
public class DeTai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ten;
	private String mota;
	private String noidung;
	private String thongtin;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaytao;
	private String file;
	private String trangthai;

	@OneToOne
	@JoinColumn(name = "idsinhvien", referencedColumnName = "id")
	private SinhVien sinhvien;

	public DeTai(long id, String ten, String mota, String noidung, String thongtin, Date ngaytao, String file,
			String trangthai) {
		super();
		this.id = id;
		this.ten = ten;
		this.mota = mota;
		this.noidung = noidung;
		this.thongtin = thongtin;
		this.ngaytao = ngaytao;
		this.file = file;
		this.trangthai = trangthai;

	}

	public DeTai() {
		super();
	}

}
