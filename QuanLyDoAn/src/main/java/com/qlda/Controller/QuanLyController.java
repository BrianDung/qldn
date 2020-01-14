package com.qlda.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.api.services.drive.model.File;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.SinhVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.BaiTapDetail;
import com.qlda.Model.DoAnDetail;
import com.qlda.Model.DoAnDetail;
import com.qlda.Service.DeTaiService;
import com.qlda.Service.GiangVienService;
import com.qlda.Service.GoogleDrive;
import com.qlda.Service.NhiemVuService;
import com.qlda.Service.QuanLyService;
import com.qlda.Service.SinhVienService;
import com.qlda.Service.TaiKhoanService;

@Controller
@RequestMapping("/trangchu_quanly")
public class QuanLyController {

	private static String UPLOADED_FOLDER_doan = "..//QuanLyDoAn//src//main//resources//File//doan//";

	@Autowired
	QuanLyService quanlyservice;
	@Autowired
	SinhVienService sinhvienservice;
	@Autowired
	DeTaiService detaiservice;
	@Autowired
	NhiemVuService nhiemvuservice;
	@Autowired
	GiangVienService giangvienservice;
	@GetMapping("/")
	public String index() {
		return "giaovu/index";
	}

	// Giao dien Thong tin Quan ly - Chi tiết của quản lý
	/*
	 * @GetMapping("trangchu_quanly/quanly/{id}") public String
	 * quanLyDetail(@PathVariable("id") Long id, Model model) {
	 * model.addAttribute("quanly", quanlyservice.getInfQuanLy(id)); return
	 * "giaovu/information"; }
	 */
	@GetMapping("/quanly/info")
	public String quanLyDetail( Model model, Principal principal) {
		String email = principal.getName();
		model.addAttribute("quanly", quanlyservice.getInfQuanLybyEmail(email));
		System.out.println(quanlyservice.getInfQuanLybyEmail(email));
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
	@GetMapping("/doan/{id}")
	public String doanDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("detai", quanlyservice.getInfDeTai(id));
		model.addAttribute("doan", new DoAnDetail());
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
		return "giaovu/DanhSachDoAn";
	}

	// Giao dien danh sach bai tap truyen vao id cua detai
	@GetMapping("/sinhvien/baitap/{id}")
	public String listTaskOfStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listnhiemvu", quanlyservice.getAllBaiTapDetail(id));
		return "giaovu/DanhSachBaiTap";
	}

	// Giao dien xem chi tiet va danh gia bai tap
	@GetMapping("/baitap/{id}")
	public String baiTapDetail(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("baitapdanhgia", quanlyservice.getBaiTapDanhGia(id));
		BaiTapDetail baitapdanhgia = quanlyservice.getBaiTapDanhGia(id);
		
		String danhgiachung = null;
		if(baitapdanhgia!=null) {
			float tb = (baitapdanhgia.getTieuChi1()+baitapdanhgia.getTieuChi2()+baitapdanhgia.getTieuChi3())/3;
			if(tb<=4) {
				danhgiachung = "Yếu";
			}else
			if(tb>4 && tb<=6.5) {
				danhgiachung = "Trung bình";	
			}else
			if(tb>6.5 && tb<=8.5) {
				danhgiachung = "Khá";
			}else
			if(tb>8.5 && tb<=10) {
				danhgiachung = "Tốt";
			}
			
			model.addAttribute("danhgiachung",danhgiachung);
			model.addAttribute("tb", tb);
			model.addAttribute("baitapdanhgia", baitapdanhgia);
			
			return "giaovu/ChiTietBaiTapDanhGia";
			
		}else {
			
			
			model.addAttribute("baitapdanhgia", nhiemvuservice.getNhiemVu(id));
			return "giaovu/taskDetail";
		}
		
	}

	// View danh sach tro chuyen cua 1 sinh vien
	@GetMapping("/sinhvien/trochuyen/{id}")
	public String troChuyens(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listtrochuyensinhvien", quanlyservice.getAllTroChuyen(id));
		return "giaovu/disscuss";
	}

	// View chi tiet tro chuyen
	@GetMapping("/trochuyen/{id}")
	public String troChuyenDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("baidang", quanlyservice.getInfoBaiDang(id));
		return "giaovu/disscussDetail";
	}

	// View tao 1 do an
	@GetMapping("/formdoan")
	public String formDoAn(Model model) {
		model.addAttribute("detai", new DoAnDetail());
		model.addAttribute("listsinhvien", sinhvienservice.findAll());
		return "giaovu/TaoMoiDoAn";
	}

	@PostMapping("/commit")
	public String commit(@ModelAttribute DoAnDetail detaidetail, RedirectAttributes redirectAttributes, Model model) {
		DeTai detai = detaiservice.getOne(detaidetail.getIdDeTai());
		try {
			MultipartFile file = detaidetail.getFile();
			 byte[] bytes = file.getBytes();
			// Get the file and save it somewhere byte[] bytes = file.getBytes(); Path
		
			

			String filename = file.getOriginalFilename();
			File googleFile = GoogleDrive.createGoogleFile(null, "text/plain", filename, bytes);
			System.out.println("Created Google file!");
	        //System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
	        //System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
			System.out.println(filename);
			detai.setFile(googleFile.getWebViewLink());
			detai.setTrangthai("Hoàn Thành");
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		detaiservice.save(detai);
		return "redirect:/trangchu_quanly/doan";
	}
	// Luu 1 de tai
	@PostMapping("/doan")
	public String taoDoAn(@ModelAttribute DoAnDetail detaidetail,
            RedirectAttributes redirectAttributes, Model model) {

		DeTai detai = new DeTai();

		detai.setTen(detaidetail.getTenDeTai());
		SinhVien sv = sinhvienservice.getOne(detaidetail.getIdSv()); // Tim 1 sinh vien tuong ung lam do an
		detai.setSinhvien(sv);

		detai.setNgaytao(detaidetail.getNgayTao());
		detai.setNoidung(detaidetail.getNoiDung());
		detai.setThongtin(detaidetail.getThongTin());
		detai.setMota(detaidetail.getMoTa());
		detai.setTrangthai(detaidetail.getTrangThai());

		// Lưu file

		try {
			MultipartFile file = detaidetail.getFile();
			 byte[] bytes = file.getBytes();
			// Get the file and save it somewhere byte[] bytes = file.getBytes(); Path
		
			

			String filename = file.getOriginalFilename();
			File googleFile = GoogleDrive.createGoogleFile(null, "text/plain", filename, bytes);
			System.out.println("Created Google file!");
	        //System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
	        //System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
			System.out.println(filename);
			detai.setFile(googleFile.getWebContentLink());
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Lưu file

		
		

		model.addAttribute("taodetai", detaiservice.save(detai));

		return "redirect:/trangchu_quanly/doan";
	}
	@GetMapping("/thongke/{id}")
	public String listThongKe(Model model, @PathVariable Long id) {
		model.addAttribute("sinhvien", sinhvienservice.getOne(id)); // lay ra thong tin cua sinh vien
		model.addAttribute("detai", detaiservice.getDoanbyIdSv(id));
		
		model.addAttribute("thongke", giangvienservice.hoanThanh(id)); // show ra so luong nhiem vu hoan thanh/ tong
																		// nhiem vu
		model.addAttribute("list", giangvienservice.getAllNhiemVuDuocDanhGiaSinhVien(id));
		return "giaovu/thongke";
	}
}
