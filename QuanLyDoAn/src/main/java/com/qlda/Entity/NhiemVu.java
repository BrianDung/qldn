package com.qlda.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "nhiemvu")
public class NhiemVu {

	@Id // Đánh dấu trường này là primary key
	@GeneratedValue // Tự động tăng giá trị id
	private Long id;
	private String ten;
	private String noidung;
	private String trangthai;
	private Date ngaytao;
	private byte[] filehd;
	private byte[] filebt;
	
	@OneToOne
	@JoinColumn(name = "iddetai", referencedColumnName = "id")
	private Detai detai;
	
	public byte[] getFilehd() {
		return filehd;
	}

	public void setFilehd(byte[] filehd) {
		this.filehd = filehd;
	}

	public byte[] getFilebt() {
		return filebt;
	}

	public void setFilebt(byte[] filebt) {
		this.filebt = filebt;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}


	public Detai getDetai() {
		return detai;
	}

	public void setDetai(Detai detai) {
		this.detai = detai;
	}
}
