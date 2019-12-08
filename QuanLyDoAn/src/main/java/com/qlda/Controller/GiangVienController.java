package com.qlda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlda.Entity.DanhGia;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.NhiemVu;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.DanhGiaDetail;
import com.qlda.Repository.GiangVienRepository;
import com.qlda.Service.DanhGiaService;
import com.qlda.Service.GiangVienService;
import com.qlda.Service.NhiemVuService;
import com.qlda.Service.QuanLyService;

@Controller
public class GiangVienController {
	@Autowired
	GiangVienService giangvienservice;
	@Autowired
	QuanLyService quanlyservice;
	@Autowired
	NhiemVuService nhiemvuservice;
	@Autowired
	DanhGiaService danhgiaservice;

	@GetMapping("/trangchu_giangvien")
	public String home() {
		return "TrangChu";
	}
	
	// View Danh sach sinh vien
	@GetMapping("trangchu_giangvien/sinhvien")
	public String getAllSinhVienHuongDan(Model model) {
		
		model.addAttribute("listsinhvienhuongdan", giangvienservice.getAllSinhVienHuongDan());
		return "giangvien/DanhSachSinhVien";
	}

	// Chi tiết 1 sv
	@GetMapping("trangchu_giangvien/sinhvien/{id}")
	public String getSinhVienById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("sinhvien", quanlyservice.getInfoSv(id));
		return "giangvien/ThongTinSinhVien";
	}

	// Chi tiết đề tài của sinh vien
	@GetMapping("trangchu_giangvien/detai/{id}")
	public String getDeTaiById(@PathVariable("id") Long id, Model model) {
		DeTai dt = quanlyservice.getInfDeTai(id);
		model.addAttribute("detai", dt);
		
		return "giangvien/ChiTietDoAn";
	}

	// Danh sach bai tap truyen theo id de tai
	@GetMapping("trangchu_giangvien/sinhvien/baitap/{id}")
	public String getAllBaiTap(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listnhiemvu", quanlyservice.getAllBaiTapDetail(id));
		return "giangvien/DanhSachNhiemVuCuaSinhVien";
	}

	// CHi tiet bai tap cua sinh vien
	@GetMapping("trangchu_giangvien/baitap/{id}")
	public String getBaiTap(@PathVariable("id") Long id, Model model) {
		model.addAttribute("baitapdanhgia", quanlyservice.getBaiTapDanhGia(id));
		return "giangvien/ChiTietNhiemVu";

	}

	// View cua form danh gia
	@GetMapping("trangchu_giangvien/formdanhgia")
	public String formDanhGia(Model model) {
		model.addAttribute("listnhiemvu", nhiemvuservice.getAllNhiemVu());
		model.addAttribute("danhgia", new DanhGiaDetail());
		return "FormDanhGia_GiangVien";
	}

	// Luu danh gia cho bai tap
	@PostMapping("trangchu_giangvien/danhgia")
	public String danhGia(Model model, @ModelAttribute DanhGiaDetail danhgia) {
		DanhGia dg = new DanhGia();
		dg.setTen(danhgia.getTenDanhGia());
		dg.setNoidung(danhgia.getNoiDung());
		dg.setTieuchi1(danhgia.getTieuChi1());
		dg.setTieuchi2(danhgia.getTieuChi2());
		dg.setTieuchi3(danhgia.getTieuChi3());
		NhiemVu nv = new NhiemVu();
		nv.setId(danhgia.getIdNhiemVu());
		dg.setNhiemvu(nv);
		model.addAttribute("danhgia", danhgiaservice.save(dg));
		return "ThongBaoDanhGia_GiangVien";

	}
}
