package com.qlda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlda.Service.QuanLyService;

@RequestMapping("/trangchu_quanly")
@Controller
public class QuanLyController {
	@Autowired
	QuanLyService quanlyservice;

	// Giao dien Thong tin Quan ly - Chi tiết của quản lý
	@GetMapping("/quanly/{id}")
	public String quanLyDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("quanly", quanlyservice.getInfQuanLy(id));
		return "giaovu/information";
	}

	// Giao dien Danh sach sinh vien - Lấy ra danh sách các model SinhVienDetail
	@GetMapping("/sinhvien")
	public String sinhViens(Model model) {
		model.addAttribute("listsinhvien", quanlyservice.getAllSinhVien());
		return "giaovu/listStudent";
	}

	// Giao diện thông tin chi tiết sinh viên
	@GetMapping("/sinhvien/{id}")
	public String sinhVienDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("sinhvien", quanlyservice.getInfoSv(id));
		return "giaovu/infoStudent";
	}

	// Giao diện thông tin chi tiết của 1 đề tài (đồ án)
	@GetMapping("doan/{id}")
	public String doanDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("detai", quanlyservice.getInfDeTai(id));
		return "giaovu/ChiTietDoAn";
	}

	// Giao diện thông tin chi tiết của 1 giảng viên
	@GetMapping("/giangvien/{id}")
	public String giangvienDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("giangvien", quanlyservice.getInfoGv(id));
		return "giaovu/infoTeacher";
	}

	// Giao diện danh sách giảng viên
	@GetMapping("/giangvien")
	public String giangviens(Model model) {
		model.addAttribute("listgiangvien", quanlyservice.getAllGiangVien());
		return "giaovu/DanhSachGiangVien";
	}

	// Giao diện sinh viên của giảng viên
	@GetMapping("/giangvien/sinhvien/{id}")
	public String listStudenOfTeacher(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listsinhvien", quanlyservice.getStudentOfTeacher(id));
		return "giaovu/listStudent";

	}

	// Giao diện danh sách đồ án
	@GetMapping("/doan")
	public String listDoAn(Model model) {
		model.addAttribute("listdoan", quanlyservice.getAllDoAnDetail());
		return "test4";
	}
	
	// Giao dien danh sach bai tap truyen vao id cua detai
	@GetMapping("sinhvien/baitap/{id}")
	public String listTaskOfStudent(@PathVariable("id") Long id ,Model model) {
		
		return "test4";
	}

	@RequestMapping(value = { "/baitap/{id}" }) // chi tiet bai tap
	public String baiTapDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/thongke" }) // danh sach thong ke
	public String thongkes(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/thongke/{id}" }) // chi tiet thong ke
	public String thongkeDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/trochuyen" }) // danh sach tro chuyen
	public String troChuyens(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/trochuyen/{id}" }) // chi tiet tro chuyen
	public String troChuyenDetail(Model model) {

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

	@RequestMapping(value = { "/taikhoan/sinhvien/{id}" }, method = RequestMethod.POST) // Tao tai khoan sinh vien
	public String taoTaiKhoanSinhVien(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/detai" }, method = RequestMethod.POST) // tao de tai
	public String taoDeTai(Model model) {

		return "giangvien/GiangVien";

	}

}
