package com.qlda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.qlda.Entity.TaiKhoan;
import com.qlda.Repository.TaiKhoanRepository;

@Service
public class TaiKhoanService {
	@Autowired
	TaiKhoanRepository taiKhoanRepository;

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
