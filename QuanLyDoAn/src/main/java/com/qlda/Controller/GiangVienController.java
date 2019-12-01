package com.qlda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/trangchu_giangvien")
@Controller
public class GiangVienController {

	// GET: Hiển thị trang login
	@GetMapping("/")
	public String index(Model model) {

		return "giangvien/TrangChu";
	}

	@RequestMapping(value = { "/sinhvien" }) // list sinh vien
	public String sinhViens(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/sinhvien/{id}" }) // chi tiet sinh vien
	public String sinhVienDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/giangvien" }) // list giang vien
	public String giangViens(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/giangvien/{id}" }) // chi tiet giang vien
	public String giangVienDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/baitap" }) // list bai tap
	public String baiTaps(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/baitap/{id}" }) // chi tiet bai tap
	public String baiTapdetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/thongke" }) // list thong ke
	public String thongKes(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/thongke/{id}" }) //chi tiet thong ke
	public String thongKeDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/trochuyen" }) // list tro chuyen
	public String troChuyens(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/trochuyen/{id}" }) // chi tiet tro chuyen
	public String troChuyenDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/danhgia" }, method = RequestMethod.POST) // Tao danh gia bai tap
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

}
