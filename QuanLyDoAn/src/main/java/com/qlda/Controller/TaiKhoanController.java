package com.qlda.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qlda.Entity.GiangVien;
import com.qlda.Entity.TaiKhoan;

import com.qlda.Repository.TaiKhoanRepository;
import com.qlda.Service.GiangVienService;
import com.qlda.Service.TaiKhoanService;

@Controller
public class TaiKhoanController {

	@Autowired
	TaiKhoanService taiKhoanService;

	// View tao 1 tai khoan
	@GetMapping("trangchu_quanly/formtaikhoan")
	public String formTaiKhoan(Model model) {
		model.addAttribute("taikhoan", new TaiKhoan());
		return "test3";
	}

	// Luu 1 tai khoan vao database
	@PostMapping("trangchu_quanly/taikhoan") // Tao 1 oject luu tren database
	public String submitTaiKhoan(@ModelAttribute TaiKhoan taikhoan, Model model) {
		model.addAttribute("taikhoan", taiKhoanService.addTaiKhoan(taikhoan));
		return "test4";
	}

	@GetMapping("trangchu_quanly/update/{id}")
	public String taiKhoanDetail(@PathVariable("id") int id, Model model) {
		model.addAttribute("taikhoan", taiKhoanService.getById(id));
		return "test2";
	}

	@DeleteMapping("trangchu_quanly/taikhoan/{id}") // xoa do an
	public String deleteTaiKhoan(@PathVariable("id") Long id, Model model) {
		taiKhoanService.deleteTaiKhoan(id);
		model.addAttribute("taikhoan", id);
		return "test5";
	}

	@PostMapping("trangchu_quanly/update/{id}")
	public String updateTaiKhoan(@PathVariable("id") Long id, @ModelAttribute TaiKhoan taikhoan, Model model) {
		taiKhoanService.updateTaiKhoan(taikhoan, id);
		return "redirect:/taikhoan"; // Chuyen tiep toi trang /{dich}
	}

}
