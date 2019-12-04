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

import com.qlda.Entity.TaiKhoan;
import com.qlda.Service.QuanLyService;
import com.qlda.Service.TaiKhoanService;

@Controller
public class QuanLyController {
	@Autowired
	QuanLyService quanlyservice;


	@GetMapping("trangchu_quanly/")
	public String index() {
		return "giaovu/index";
	}


	// Giao dien Thong tin Quan ly - Chi tiết của quản lý
	@GetMapping("trangchu_quanly/quanly/{id}")
	public String quanLyDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("quanly", quanlyservice.getInfQuanLy(id));
		return "giaovu/information";
	}

	// Giao dien Danh sach sinh vien - Lấy ra danh sách các model SinhVienDetail
	@GetMapping("trangchu_quanly/sinhvien")
	public String sinhViens(Model model) {
		model.addAttribute("listsinhvien", quanlyservice.getAllSinhVien());
		return "giaovu/listStudent";
	}

	// Giao diện thông tin chi tiết sinh viên
	@GetMapping("trangchu_quanly/sinhvien/{id}")
	public String sinhVienDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("sinhvien", quanlyservice.getInfoSv(id));
		return "giaovu/infoStudent";
	}

	// Giao diện thông tin chi tiết của 1 đề tài (đồ án)
	@GetMapping("trangchu_quanly/doan/{id}")
	public String doanDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("detai", quanlyservice.getInfDeTai(id));
		return "giaovu/ChiTietDoAn";
	}

	// Giao diện thông tin chi tiết của 1 giảng viên
	@GetMapping("trangchu_quanly/giangvien/{id}")
	public String giangvienDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("giangvien", quanlyservice.getInfoGv(id));
		return "giaovu/infoTeacher";
	}

	// Giao diện danh sách giảng viên
	@GetMapping("trangchu_quanly/giangvien")
	public String giangviens(Model model) {
		model.addAttribute("listgiangvien", quanlyservice.getAllGiangVien());
		return "giaovu/DanhSachGiangVien";
	}

	// Giao diện sinh viên của giảng viên
	@GetMapping("trangchu_quanly/giangvien/sinhvien/{id}")
	public String listStudenOfTeacher(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listsinhvien", quanlyservice.getStudentOfTeacher(id));
		return "giaovu/listStudent";

	}

	// Giao diện danh sách đồ án
	@GetMapping("trangchu_quanly/doan")
	public String listDoAn(Model model) {
		model.addAttribute("listdoan", quanlyservice.getAllDoAnDetail());
		return "giaovu/DanhSachDoAn";
	}

	// Giao dien danh sach bai tap truyen vao id cua detai
	@GetMapping("trangchu_quanly/sinhvien/baitap/{id}")
	public String listTaskOfStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listnhiemvu", quanlyservice.getAllBaiTapDetail(id));
		return "giaovu/DanhSachBaiTap";
	}

	// Giao dien xem chi tiet va danh gia bai tap
	@GetMapping("trangchu_quanly/baitap/{id}")
	public String baiTapDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("baitapdanhgia", quanlyservice.getBaiTapDanhGia(id));
		return "giaovu/taskDetail";
	}

	// View danh sach tro chuyen cua 1 sinh vien
	@GetMapping("trangchu_quanly/sinhvien/trochuyen/{id}")
	public String troChuyens(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listtrochuyensinhvien", quanlyservice.getAllTroChuyen(id));
		return "giaovu/disscuss";
	}

	// View chi tiet tro chuyen
	@GetMapping("trangchu_quanly/trochuyen/{id}")
	public String troChuyenDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("baidang", quanlyservice.getInfoBaiDang(id));
		return "giaovu/disscussDetail";
	}

	@RequestMapping(value = { "/thongke" }) // danh sach thong ke
	public String thongkes(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/thongke/{id}" }) // chi tiet thong ke
	public String thongkeDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/danhgia" }, method = RequestMethod.POST) // Tao 1 danh gia bai tap
	public String taoDanhGia(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/trochuyen" }, method = RequestMethod.POST) // Tao tro chuyen
	public String taoTroChuyen(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/nhiemvu" }, method = RequestMethod.POST) // Tao nhiem vu
	public String taoNhiemVu(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/taikhoan/giangvien/{id}" }, method = RequestMethod.POST) // Tao tai khoan giang vien
	public String taoTaiKhoanGiangVien(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/detai" }, method = RequestMethod.POST) // tao de tai
	public String taoDeTai(Model model) {

		return "giangvien/GiangVien";

	}

}
