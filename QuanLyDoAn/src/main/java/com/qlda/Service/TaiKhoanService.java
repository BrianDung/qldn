package com.qlda.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.TaiKhoanDetails;
import com.qlda.Repository.TaiKhoanRepository;

@Service
public class TaiKhoanService implements UserDetailsService  {
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	
	//Start - Tìm tài khoản trong db phân quyền security
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taikhoan = taiKhoanRepository.findByEmail(username);
		if(taikhoan == null) {
			throw new UsernameNotFoundException("Không tìm thấy tài khoản");
			
		}
		String role = taikhoan.getRole();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        grantedAuthorities.add(authority);
        return new org.springframework.security.core.userdetails.User(
        		taikhoan.getEmail(), taikhoan.getPassword(), grantedAuthorities);
	}
	
	//End - Tìm tài khoản trong db phân quyền security
	
	
	

	// Them 1 tai khoan
	public TaiKhoan addTaiKhoan(TaiKhoan taikhoan) {
		boolean check = checkEmail(taikhoan);
		if (check == true)
			return taiKhoanRepository.save(taikhoan);
		else
			return null;

	}

	// Check thong tin Email
	public boolean checkEmail(TaiKhoan taikhoan) {
		if (taikhoan.getEmail() == null || taikhoan.getPassword() == null || taikhoan.getRole() == null) {
			return false;
		} else {
			for (TaiKhoan tk : taiKhoanRepository.findAll()) {
				if (tk.getEmail() == taikhoan.getEmail()) {
					return false;
				}
			}
			return true;
		}
	}

	public TaiKhoan getById(int id) {
		for (TaiKhoan taikhoan : taiKhoanRepository.findAll()) {
			if (taikhoan.getId() == id) {
				return taikhoan;
			}
		}
		return null;
	}

	public void deleteTaiKhoan(Long id) {
		taiKhoanRepository.deleteById(id);
	}

	public void updateTaiKhoan(TaiKhoan taikhoan, Long id) {

		for (TaiKhoan tk : taiKhoanRepository.findAll()) {
			if (tk.getId() == id) {
				tk.setEmail(taikhoan.getEmail());
				tk.setPassword(taikhoan.getPassword());
				tk.setRole(taikhoan.getRole());
				TaiKhoan updateTaiKhoan = taiKhoanRepository.save(tk);
			}
		}

	}

	
}
