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
@Table(name = "sinhvien")
public class SinhVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int mssv;
	private String ten;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date namsinh;
	private String sodienthoai;

	@OneToOne
	@JoinColumn(name = "idtaikhoan", referencedColumnName = "id") // Liên kết với khóa ngoài của bảng tài khôản
	private TaiKhoan taikhoan;

	@OneToOne
	@JoinColumn(name = "idgiangvien", referencedColumnName = "id")
	private GiangVien giangvien;

	public SinhVien(Long id, int mssv, String ten, Date namsinh, String sodienthoai) {
		super();
		this.id = id;
		this.mssv = mssv;
		this.ten = ten;
		this.namsinh = namsinh;
		this.sodienthoai = sodienthoai;
	}

	public SinhVien() {
		super();
	}

}
