package com.qlda.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/Trangchu-sinhvien")
public class SinhVienController {

	// GET: Hiển thị trang login
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(Model model) {

		return "giangvien/TrangChu";
	}

	@RequestMapping(value = { "/sinhvien" }) // lay danh sach sinh vien
	public String students(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/sinhvien/{id}" }) // lay chi tiet sinh vien
	public String studentDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/giangvien" }) // lay ra danh sach giang vien
	public String giangViens(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/giangvien/{id}" }) // lay ra chi tiet giang vien
	public String giangVienDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/baitap" }) // lay ra danh sach bai tap
	public String baiTaps(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/baitap/{id}" }) // lay ra chi tiet bai tap
	public String baiTapDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/danhgia" }) // lay ra danh sach danh gia
	public String danhGias(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/danhgia/{id}" }) // lay ra chi tiet danh gia
	public String danhGiaDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/thongke" }) // lay ra danh sach thong ke
	public String thongKes(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/thongke/{id}" }) // lay ra chi tiet thong ke
	public String thongKeDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/trochuyen" }) // lay ra danh sach tro chuyen
	public String troChuyens(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/trochuyen/{id}" }) // lay ra chi tiet tro chuyen
	public String troChuyenDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/baitap" }, method = RequestMethod.POST) // Tao bai tap
	public String taoBaiTap(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/trochuyen" }, method = RequestMethod.POST) // Tao tro chuyen
	public String taoTroChuyen(Model model) {

		return "giangvien/GiangVien";
	}
}
