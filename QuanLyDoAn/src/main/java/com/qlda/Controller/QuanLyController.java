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

	@GetMapping("/")
	public String index(Model model) {
		return "giaovu/index";
	}

	@RequestMapping(value = { "/quanly" }) // danh sach quan ly
	public String quanLys(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/quanly/{id}" }) // chi tiet quan ly
	public String quanLyDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@GetMapping("/sinhvien") // danh sach sinh vien
	public String sinhViens(Model model) {
		model.addAttribute("listsinhvien", quanlyservice.getAllSinhVien());
		return "listStudent";

	}

	@GetMapping("/sinhvien/{id}") // chi tiet sinh vien
	public String sinhVienDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("sinhvieninf", quanlyservice.getInfoSv(id));
		return "infsv";
	}

	@RequestMapping(value = { "/giangvien" }) // danh sach giang vien
	public String giangviens(Model model) {
		model.addAttribute("listgiangvien", quanlyservice.getAllGiangVien());
		return "listGiangVien";
	}

	@RequestMapping(value = { "/giangvien/{id}" }) // chi tiet giang vien
	public String giangvienDetail(@PathVariable("id") Long id,Model model) {

		return "giangvien/GiangVien";
	}
	@GetMapping("/giangvien/sinhvien/{id}")
	public String listStudenOfTeacher(@PathVariable("id") Long id,Model model) {
		
		model.addAttribute("listsinhvien", quanlyservice.getStudentOfTeacher(id));
		return "listStudent";
		
	}
	
	
	@RequestMapping(value = { "/doan" }) // danh sach do an
	public String doans(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/doan/{id}" }) // chi tiet do an
	public String doanDetail(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/baitap" }) // danh sach bai tap
	public String baiTaps(Model model) {

		return "giangvien/GiangVien";
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
