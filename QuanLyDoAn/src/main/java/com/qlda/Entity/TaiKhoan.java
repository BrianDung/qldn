package com.qlda.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "taikhoan")
//@SecondaryTable(name = "giangvien", pkJoinColumns = @PrimaryKeyJoinColumn(name = "idtaikhoan"))
public class TaiKhoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	public TaiKhoan() {
		super();
	}

}
