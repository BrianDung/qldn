package com.qlda.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nhiemvu")
public class NhiemVu {

	@Id // Đánh dấu trường này là primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ten;
	private String noidung;
	private String trangthai;
	private Date ngaytao;
	private Date hannop;
	private String filehd;
	private String filebt;

	@OneToOne
	@JoinColumn(name = "iddetai", referencedColumnName = "id")
	private DeTai detai;

}
