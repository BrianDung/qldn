package com.qlda.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.QuanLy;
import com.qlda.Entity.SinhVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.BaiTapDetail;
import com.qlda.Model.DoAnDetail;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.QuanLyDetail;
import com.qlda.Model.SinhVienDetail;
import com.qlda.Model.TroChuyenDetail;
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

	// Get Info SV by Email
	public SinhVienDetail getInfoSVbyEmail(String email) {
		for (SinhVienDetail sv : quanlyrepository.getListInfo()) {
			if (sv.getEmailSv().equals(email)) {
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

	public DeTai getInfDeTai(Long id) {
		for (DeTai dt : quanlyrepository.getAllDeTai()) {
			if (dt.getId() == id) {
				return dt;
			}
		}
		return null;
	}

	public QuanLyDetail getInfQuanLy(Long id) {
		for (QuanLyDetail ql : quanlyrepository.getAllQuanLy()) {
			if (ql.getId() == id) {
				return ql;
			}
		}
		return null;
	}

	public QuanLyDetail getInfQuanLybyEmail(String email) {
		for (QuanLyDetail ql : quanlyrepository.getAllQuanLy()) {
			if (ql.getEmail().equals(email)) {
				return ql;
			}
		}
		return null;
	}

	public List<DoAnDetail> getAllDoAnDetail() {
		return quanlyrepository.getAllDoAnDetail();
	}

	public List<BaiTapDetail> getAllBaiTapDetail(Long id) {
		List<BaiTapDetail> list = new ArrayList<BaiTapDetail>();
		for (BaiTapDetail bt : quanlyrepository.getAllBaiTap()) {
			if (bt.getIdDeTai() == id) {
				list.add(bt);
			}
		}
		return list;

	}
	

	public List<BaiTapDetail> getAllBaiTapSV(String email) {

		Long idDetai = this.getInfoSVbyEmail(email).getIdDeTai();
		List<BaiTapDetail> list = new ArrayList<BaiTapDetail>();
		for (BaiTapDetail bt : quanlyrepository.getAllBaiTap()) {
			if (bt.getIdDeTai() == idDetai) {
				list.add(bt);
			}
		}
		return list;

	}

	public BaiTapDetail getBaiTapDanhGia(Long id) {
		for (BaiTapDetail bt : quanlyrepository.getAllDanhGiaBaiTap()) {
			if (bt.getIdNhiemVu() == id) {
				return bt;
			}
		}
		return null;
	}

	public List<TroChuyenDetail> getAllTroChuyen(Long id) {
		List<TroChuyenDetail> list = new ArrayList<TroChuyenDetail>();
		for (TroChuyenDetail tt : quanlyrepository.getAllTroChuyenDetail()) {
			if (tt.getIdDeTai() == id) {
				list.add(tt);
			}
		}

		return list;
	}

	public List<TroChuyenDetail> getAllTroChuyenSV(String email) {
		Long idDetai = this.getInfoSVbyEmail(email).getIdDeTai();
		List<TroChuyenDetail> list = new ArrayList<TroChuyenDetail>();
		for (TroChuyenDetail tt : quanlyrepository.getAllTroChuyenDetail()) {
			if (tt.getIdDeTai() == idDetai) {
				list.add(tt);
			}
		}

		return list;
	}

	public BaiDang getInfoBaiDang(Long id) {
		for (BaiDang bd : quanlyrepository.getAllBaiDang()) {
			if (bd.getId() == id) {
				return bd;
			}
		}
		return null;
	}

}
