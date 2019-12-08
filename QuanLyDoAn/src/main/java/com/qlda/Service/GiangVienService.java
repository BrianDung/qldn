package com.qlda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.SinhVienDetail;
import com.qlda.Repository.DeTaiRepository;
import com.qlda.Repository.GiangVienRepository;
import com.qlda.Repository.TaiKhoanRepository;

@Service
public class GiangVienService {

	@Autowired
	GiangVienRepository giangVienRepository;
	@Autowired
	DeTaiRepository detairepository;

	public GiangVien addGiangVien(GiangVien giangvien) { // Them 1 gv
		return giangVienRepository.save(giangvien);
	}

	public List<GiangVien> getAllGv() { // lay ra danh sach giang vien
		return giangVienRepository.findAll();
	}

	public GiangVien getOne(Long id) { // lay ra 1 gv
		return giangVienRepository.getOne(id);
	}

	public List<SinhVienDetail> getAllSinhVienHuongDan() { // danh sach sv ma gv huong dan
		return giangVienRepository.getAllSinhVienHuongDan();
	}

	public SinhVienDetail getSinhVienById(Long id) { // lay ra thong tin cua 1 sv ma gv huong dan
		for (SinhVienDetail sv : getAllSinhVienHuongDan()) {
			if (sv.getIdSv() == id) {
				return sv;
			}
		}
		return null;
	}

	// Lay r chi tiet 1 de tai cua sinh vien trong gv huong dan
	public DeTai getDeTaiById(Long id) {
		for (DeTai dt : giangVienRepository.getAllDeTai()) {
			if (dt.getId() == id) {
				return dt;
			}
		}
		return null;
	}

	
}
