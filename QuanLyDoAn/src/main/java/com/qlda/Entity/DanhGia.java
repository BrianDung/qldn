package com.qlda.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "danhgia")
@Data
public class DanhGia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "idNhiemVu", referencedColumnName = "id")
	private NhiemVu nhiemVu;
	//
	private String noiDung;
	
	private String tieuChi1;
	private String tieuChi2;
	private String tieuChi3;
	private String tieuChi4;
	private String trungBinh;
	private String file;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public NhiemVu getNhiemVu() {
		return nhiemVu;
	}
	public void setNhiemVu(NhiemVu nhiemVu) {
		this.nhiemVu = nhiemVu;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getTieuChi1() {
		return tieuChi1;
	}
	public void setTieuChi1(String tieuChi1) {
		this.tieuChi1 = tieuChi1;
	}
	public String getTieuChi2() {
		return tieuChi2;
	}
	public void setTieuChi2(String tieuChi2) {
		this.tieuChi2 = tieuChi2;
	}
	public String getTieuChi3() {
		return tieuChi3;
	}
	public void setTieuChi3(String tieuChi3) {
		this.tieuChi3 = tieuChi3;
	}
	public String getTieuChi4() {
		return tieuChi4;
	}
	public void setTieuChi4(String tieuChi4) {
		this.tieuChi4 = tieuChi4;
	}
	public String getTrungBinh() {
		return trungBinh;
	}
	public void setTrungBinh(String trungBinh) {
		this.trungBinh = trungBinh;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
}
