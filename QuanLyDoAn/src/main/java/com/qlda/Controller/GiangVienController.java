package com.qlda.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DanhGia;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.NhiemVu;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.DanhGiaDetail;
import com.qlda.Model.NhiemVuDetail;
import com.qlda.Model.TroChuyenDetail;
import com.qlda.Repository.GiangVienRepository;
import com.qlda.Service.DanhGiaService;
import com.qlda.Service.DeTaiService;
import com.qlda.Service.GiangVienService;
import com.qlda.Service.NhiemVuService;
import com.qlda.Service.QuanLyService;
import com.qlda.Service.TaiKhoanService;
import com.qlda.Service.TroChuyenService;

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
	@Autowired
	DeTaiService detaiservice;
	@Autowired
	TroChuyenService trochuyenservice;
	@Autowired
	TaiKhoanService taikhoanservice;

	@GetMapping("/trangchu_giangvien")

	public String index() {
		return "index";
	}

	// View Danh sach sinh vien
	@GetMapping("trangchu_giangvien/sinhvien")
	public String getAllSinhVienHuongDan(Model model, Principal principal) {
		String email = principal.getName();// Email GV
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("listsinhvien", quanlyservice.getStudentOfTeacher(idGv));
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

	// View tao nhiem vu
	@GetMapping("trangchu_giangvien/nhiemvu")
	public String formNhiemVu(Model model) {
		model.addAttribute("listdetai", detaiservice.getAllDeTai());
		model.addAttribute("nhiemvu", new NhiemVuDetail());
		return "FormNhiemVu_GiangVien";
	}

	// Luu 1 nhiem vu
	@PostMapping("trangchu_giangvien/nhiemvu")
	public String nhiemVu(@ModelAttribute NhiemVuDetail nhiemvudetail, Model model) {
		NhiemVu nhiemvu = new NhiemVu();
		nhiemvu.setTen(nhiemvudetail.getTenNhiemVu());
		nhiemvu.setNoidung(nhiemvudetail.getNoiDungNhiemVu());
		nhiemvu.setFilebt(nhiemvudetail.getFileBt());
		nhiemvu.setFilehd(nhiemvudetail.getFileHd());
		nhiemvu.setHannop(nhiemvudetail.getHanNop());
		nhiemvu.setNgaytao(nhiemvudetail.getNgayTao());
		nhiemvu.setTrangthai(nhiemvudetail.getTrangThai());
		nhiemvu.setDetai(giangvienservice.getDeTaiById(nhiemvudetail.getIdDeTai())); // save de tai
		nhiemvuservice.save(nhiemvu);
		return "ThongBaoNhiemVu_GiangVien";
	}

	// View tao tro chuyen
	@GetMapping("trangchu_giangvien/trochuyen")
	public String formTroChuyen(Model model) {
		model.addAttribute("listdetai", detaiservice.getAllDeTai());
		model.addAttribute("trochuyen", new TroChuyenDetail());
		return "FormTroChuyen_GiangVien";
	}

	// Luu 1 bai dang
	@PostMapping("trangchu_giangvien/trochuyen")
	public String troChuyen(@ModelAttribute TroChuyenDetail trochuyendetail, Model model) {
		BaiDang tt = new BaiDang();
		tt.setTen(trochuyendetail.getTenBaiDang());
		tt.setNoidung(trochuyendetail.getNoiDung());
		tt.setNgaytao(trochuyendetail.getNgayTao());
//		tt.setFile(trochuyendetail.getFile());
		tt.setDetai(giangvienservice.getDeTaiById(trochuyendetail.getIdDeTai()));// Truyen id de tai
		trochuyenservice.save(tt);

		return "ThongBaoBaiDang_GiangVien";
	}

	// View Danh sach nhiem vu cua sinh vien dc gv huong dan
	@GetMapping("trangchu_giangvien/listnhiemvu")
	public String listNhiemVu(Model model, Principal principal) {
		String email = principal.getName();// Email GV
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("listnhiemvu", giangvienservice.getAllNhiemVuSinhVienOfGiangVien(idGv));
		return "DanhSachNhiemVu_GiangVien";
	}

	// View chi tiet nhiem vu
	@GetMapping("trangchu_giangvien/nhiemvu/{id}")
	public String nhiemVu(@PathVariable("id") Long id, Model model) {
		model.addAttribute("nhiemvu", nhiemvuservice.GetNhiemVu(id));
		return "ChiTietNhiemVu_GiangVien";
	}

	// View danh sach cuoc tro chuyen
	@GetMapping("trangchu_giangvien/listtrochuyen")
	public String listTroChuyen(Model model, Principal principal) {
		String email = principal.getName();// Email GV
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("listtrochuyen", giangvienservice.getAllTroChuyenSinhVienOfGiangVien(idGv));
		return "DanhSachTroChuyen_GiangVien";
	}

	@GetMapping("trangchu_giangvien/trochuyen/{id}")
	public String troChuyenDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("trochuyen", trochuyenservice.getTroChuyen(id));
		return "ChiTietTroChuyen_GiangVien";
	}
}
