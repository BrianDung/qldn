package com.qlda.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.GiangVien;
import com.qlda.Entity.QuanLy;
import com.qlda.Entity.SinhVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.SinhVienDetail;
import com.qlda.Repository.QuanLyRepository;

@Service
public class QuanLyService {
	@Autowired
	QuanLyRepository quanlyrepository;

	// Lay thong tin cua 1 quan ly
//	public Optional<QuanLy> getInfQuanLy(Long id) {
//		Optional<QuanLy> quanly = quanlyrepository.findById(id);
//		return quanly;
//	}
	// Lay danh sách sinh vien
	public List<SinhVienDetail> getAllSinhVien() {
		return quanlyrepository.getAllListStudentDoAn();
	}

	public SinhVienDetail getInfoSv(Long id) {
		for (SinhVienDetail sv : quanlyrepository.getListInfo()) {
			if (sv.getIdSv() == id) {
				return sv;
			}
		}
		return null;
	}

	public List<GiangVienDetail> getAllGiangVien() {
		return quanlyrepository.getAllListGv();
	}

	public GiangVienDetail getInfoGv(Long id) {
		for (GiangVienDetail gv : quanlyrepository.getAllListGv()) {
			if (gv.getId() == id) {
				return gv;
			}
		}

		return null;
	}

	public List<SinhVienDetail> getStudentOfTeacher(Long id) {
		List<SinhVienDetail> list = new ArrayList<SinhVienDetail>();
		for (SinhVienDetail sv : quanlyrepository.getAllListStudentDoAn()) {
			if (sv.getIdGv() == id) {
				list.add(sv);
			}
		}
		return list;
	}
	
	
}
