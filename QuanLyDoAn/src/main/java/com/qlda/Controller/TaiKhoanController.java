package com.qlda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.qlda.Entity.TaiKhoan;
import com.qlda.Repository.TaiKhoanRepository;
import com.qlda.Service.TaiKhoanService;

@Controller
public class TaiKhoanController {

	@Autowired
	TaiKhoanService taiKhoanService;

	@GetMapping("/taikhoan")
	public String taiKhoan(Model model) {
		model.addAttribute("taikhoan", taiKhoanService.getAllTaiKhoan());
		return "test";
	}

	@GetMapping("/taikhoan/{id}")
	public String taiKhoanDetail(@PathVariable("id") int id, Model model) {

		model.addAttribute("onlytk", taiKhoanService.getById(id));
		return "test2";
	}

	@GetMapping("/addtaikhoan") // Tao 1 object tai khoan hien thi toi view
	public String formTaiKhoan(Model model) {
		model.addAttribute("newTaiKhoan", new TaiKhoan());
		return "test3";
	}

	@PostMapping("/taikhoan")
	public String submitTaiKhoan(@ModelAttribute TaiKhoan taikhoan, Model model) {
		model.addAttribute("taikhoan", taiKhoanService.addTaiKhoan(taikhoan));
		return "test4";
	}
}
