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

import com.qlda.Entity.GiangVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Repository.GiangVienRepository;
import com.qlda.Service.GiangVienService;

@Controller
public class GiangVienController {
	@Autowired
	GiangVienRepository giangvienrepository;
	

}
