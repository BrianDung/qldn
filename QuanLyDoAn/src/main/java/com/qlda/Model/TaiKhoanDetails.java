package com.qlda.Model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.qlda.Entity.TaiKhoan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaiKhoanDetails implements UserDetails {
	TaiKhoan taikhoan;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idGiangVien;
	private Long idTaiKhoan;
	private String email;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Collections.singleton(new SimpleGrantedAuthority("SinhVien"));
	}

	@Override
	public String getPassword() {
		return taikhoan.getPassword();
	}

	@Override
	public String getUsername() {
		return taikhoan.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public TaiKhoanDetails() {
		super();
	}

	public TaiKhoanDetails(Long idGiangVien, Long idTaiKhoan, String email) {
		super();
		this.idGiangVien = idGiangVien;
		this.idTaiKhoan = idTaiKhoan;
		this.email = email;
	}

}
