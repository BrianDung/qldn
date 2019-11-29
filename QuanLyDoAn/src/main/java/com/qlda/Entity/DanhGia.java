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
	private Long id;

	@OneToOne
	@JoinColumn(name = "idnhiemvu", referencedColumnName = "id")
	private NhiemVu nhiemvu;
	//
	private String ten;
	private String noidung;

	private int tieuchi1;
	private int tieuchi2;
	private int tieuchi3;
	private String file;

	public DanhGia() {
		super();
	}

	public DanhGia(long id, NhiemVu nhiemvu, String ten, String noidung, int tieuchi1, int tieuchi2,
			int tieuchi3, String file) {
		super();
		this.id = id;
		this.nhiemvu = nhiemvu;
		this.ten = ten;
		this.noidung = noidung;
		this.tieuchi1 = tieuchi1;
		this.tieuchi2 = tieuchi2;
		this.tieuchi3 = tieuchi3;
		this.file = file;
	}

}
