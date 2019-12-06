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

import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Repository.GiangVienRepository;
import com.qlda.Service.GiangVienService;

@Controller
public class GiangVienController {
	@Autowired
	GiangVienService giangvienservice;

	// View Danh sach sinh vien
	@GetMapping("trangchu_giangvien/sinhvien")
	public String getAllSinhVienHuongDan(Model model) {
		model.addAttribute("listsinhvienhuongdan", giangvienservice.getAllSinhVienHuongDan());
		return "DanhSachSinhVien_GiangVien";
	}
	// Chi tiết 1 sv
	@GetMapping("trangchu_giangvien/sinhvien/{id}")
	public String getSinhVienById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("sinhvien", giangvienservice.getSinhVienById(id));
		return "ChiTietSinhVien_GiangVien";
	}
	//Chi tiết đề  tài của sinh vien
	@GetMapping("trangchu_giangvien/detai/{id}")
	public String getDeTaiById(@PathVariable("id") Long id , Model model) {
		DeTai dt = giangvienservice.getDeTaiById(id);
		model.addAttribute("detai", dt);
		System.out.println(dt);
		return "ChiTietDeTai_GiangVien";
	}

}
