package com.qlda.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.BaiTapDetail;
import com.qlda.Model.DoAnDetail;
import com.qlda.Model.TroChuyenDetail;
import com.qlda.Service.BaiDangService;
import com.qlda.Service.DeTaiService;
import com.qlda.Service.QuanLyService;
import com.qlda.Service.SinhVienService;
import com.qlda.Service.TaiKhoanService;

@RequestMapping("/trangchu_sinhvien")
@Controller
public class SinhVienController {

	
	@Autowired
	QuanLyService quanlyservice;
	@Autowired
	SinhVienService sinhvienservice;
	@Autowired
	DeTaiService detaiservice;
	@Autowired
	BaiDangService baidangservice;
	@Autowired
	TaiKhoanService taikhoanservice;
	
	
	// GET: Hiển thị trang login
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(Model model) {

		return "sinhvien/index-SinhVien";
	}

	@RequestMapping(value = { "/sinhvien" }) // lay danh sach sinh vien
	public String students(Model model) {

		return "giangvien/GiangVien";
	}

	@RequestMapping(value = { "/info" }) // lay chi tiet sinh vien
	public String studentDetail(Model model, Principal principal) {
		String email = principal.getName();
		System.out.println(email);
		
		model.addAttribute("sinhvien", quanlyservice.getInfoSVbyEmail(email));
		
		return "sinhvien/ThongTin"; 
	}

	@RequestMapping(value = { "/nhiemvu" }) // lay ra danh sach giang vien
	public String giangViens(Model model, Principal principal) {
		String email = principal.getName();
		System.out.println(email);
		
		model.addAttribute("sinhvien", quanlyservice.getInfoSVbyEmail(email));
		model.addAttribute("listnhiemvu", quanlyservice.getAllBaiTapSV(email));
		return "sinhvien/NhiemVu";
	}

	@RequestMapping(value = { "/nhiemvu/{id}" }) // lay ra chi tiet bai tap
	public String baiTapDetail(Model model, @PathVariable("id") Long id) {
		model.addAttribute("baitapdanhgia", quanlyservice.getBaiTapDanhGia(id));
		
		return "sinhvien/ChiTietDanhGia";
	}

	@RequestMapping(value = { "/giangvien/{id}" }) // lay ra chi tiet giang vien
	public String giangVienDetail(Model model) {

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
	public String troChuyens(Model model, Principal principal) {
		String email = principal.getName();
		System.out.println(email);
		model.addAttribute("sinhvien", quanlyservice.getInfoSVbyEmail(email));
		model.addAttribute("listtrochuyensinhvien", quanlyservice.getAllTroChuyenSV(email));
		return "sinhvien/TroChuyen";
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
	public String taoTroChuyen(Model model,@ModelAttribute TroChuyenDetail tt,Principal principal ) {
		String email = principal.getName();
		DoAnDetail doan =  detaiservice.getDoanbyEmailSv(email);
		DeTai detai = detaiservice.getOne(doan.getIdDeTai());
		
		
		BaiDang bd = new BaiDang();
		bd.setTen(tt.getTenBaiDang());
		bd.setNoidung(tt.getNoiDung());
		bd.setNgaytao(tt.getNgayTao());
		bd.setDetai(detai);
		
		
		
		
		baidangservice.save(bd);
		return "sinhvien/TroChuyen";
	}
}
