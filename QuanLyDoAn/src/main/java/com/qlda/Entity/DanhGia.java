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
	private String noidung;

	private String tieuchi1;
	private String tieuchi2;
	private String tieuchi3;
	private String file;
	public DanhGia(long id, NhiemVu nhiemVu, String noidung, String tieuchi1, String tieuchi2, String tieuchi3,
			String file) {
		super();
		this.id = id;
		this.nhiemVu = nhiemVu;
		this.noidung = noidung;
		this.tieuchi1 = tieuchi1;
		this.tieuchi2 = tieuchi2;
		this.tieuchi3 = tieuchi3;
		this.file = file;
	}
	public DanhGia() {
		super();
	}

	

}
