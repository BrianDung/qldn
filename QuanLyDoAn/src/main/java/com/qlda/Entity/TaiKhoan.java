package com.qlda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "taikhoan")
@Data
public class TaiKhoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String role;

	public TaiKhoan(String email, String password, String role) {
		super();

		this.email = email;
		this.password = password;
		this.role = role;
	}

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(Long id, String email, String password, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}

}
