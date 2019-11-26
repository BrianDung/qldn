package com.qlda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qlda.Entity.TaiKhoan;
import com.qlda.Repository.TaiKhoanRepository;

@Service
public class TaiKhoanService {
	@Autowired
	TaiKhoanRepository taiKhoanRepository;

	public List<TaiKhoan> getAllTaiKhoan() {
		return taiKhoanRepository.findAll();
	}

	public TaiKhoan getById(int id) {
		for (TaiKhoan taikhoan : taiKhoanRepository.findAll()) {
			if (taikhoan.getId() == id) {
				return taikhoan;
			}
		}
		return null;
	}

	public TaiKhoan addTaiKhoan(TaiKhoan taikhoan) {
		taiKhoanRepository.save(taikhoan);
		return taikhoan;
	}

	public void deleteTaiKhoan(Long id) {
		taiKhoanRepository.deleteById(id);
	}

	public void updateTaiKhoan(TaiKhoan taikhoan) {
		for (TaiKhoan tk : taiKhoanRepository.findAll()) {
			if (tk.getId() == taikhoan.getId()) {
				tk.setEmail(taikhoan.getEmail());
				tk.setPassword(taikhoan.getPassword());
				tk.setRole(taikhoan.getRole());
				taiKhoanRepository.save(tk);
			}
		}

	}
}
