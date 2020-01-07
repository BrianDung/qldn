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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.api.services.drive.model.File;
import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DanhGia;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.NhiemVu;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.BaiTapDetail;
import com.qlda.Model.DanhGiaDetail;
import com.qlda.Model.NhiemVuDetail;
import com.qlda.Model.TroChuyenDetail;
import com.qlda.Repository.GiangVienRepository;
import com.qlda.Service.DanhGiaService;
import com.qlda.Service.DeTaiService;
import com.qlda.Service.GiangVienService;
import com.qlda.Service.GoogleDrive;
import com.qlda.Service.NhiemVuService;
import com.qlda.Service.QuanLyService;
import com.qlda.Service.SinhVienService;
import com.qlda.Service.TaiKhoanService;
import com.qlda.Service.TroChuyenService;

@Controller
public class GiangVienController {
	
	private static String UPLOADED_FOLDER_baitap = "..//QuanLyDoAn//src//main//resources//File//baitap//";
	private static String UPLOADED_FOLDER_trochuyen = "..//QuanLyDoAn//src//main//resources//File//trochuyen//";

	@Autowired
	GiangVienService giangvienservice;
	@Autowired
	QuanLyService quanlyservice;
	@Autowired
	NhiemVuService nhiemvuservice;
	@Autowired
	DanhGiaService danhgiaservice;
	@Autowired
	DeTaiService detaiservice;
	@Autowired
	TroChuyenService trochuyenservice;
	@Autowired
	TaiKhoanService taikhoanservice;
	@Autowired
	SinhVienService sinhvienservice;
	

	@GetMapping("/trangchu_giangvien")
	public String home(Model model, Principal principal) {
		String email = principal.getName();// Email GV
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("listnhiemvu", giangvienservice.getAllNhiemVuSinhVienOfGiangVien(idGv));
		return "giangvien/TrangChu";
		
	}
	
	
	@GetMapping("/trangchu_giangvien/info")
	public String info(Model model, Principal principal){
		String email = principal.getName();
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("giangvien",giangvienservice.getOne(idGv));
		model.addAttribute("email",email);
		return "giangvien/ThongTin";
		
	}

	// View Danh sach sinh vien
	@GetMapping("trangchu_giangvien/sinhvien")
	public String getAllSinhVienHuongDan(Model model, Principal principal) {
		String email = principal.getName();// Email GV
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("listsinhvien", quanlyservice.getStudentOfTeacher(idGv));
		return "giangvien/DanhSachSinhVien";
	}

	// Chi tiết 1 sv
	@GetMapping("trangchu_giangvien/sinhvien/{id}")
	public String getSinhVienById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("sinhvien", quanlyservice.getInfoSv(id));
		return "giangvien/ThongTinSinhVien";
	}

	// Chi tiết đề tài của sinh vien
	@GetMapping("trangchu_giangvien/detai/{id}")
	public String getDeTaiById(@PathVariable("id") Long id, Model model) {
		DeTai dt = quanlyservice.getInfDeTai(id);
		model.addAttribute("detai", dt);

		return "giangvien/ChiTietDoAn";
	}

	// Danh sach bai tap truyen theo id de tai
	@GetMapping("trangchu_giangvien/sinhvien/baitap/{id}")
	public String getAllBaiTap(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listnhiemvu", quanlyservice.getAllBaiTapDetail(id));
		return "giangvien/DanhSachNhiemVuCuaSinhVien";
	}

	// CHi tiet bai tap cua sinh vien
	@GetMapping("trangchu_giangvien/baitap/{id}")
	public String getBaiTap(@PathVariable("id") Long id, Model model) {
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
			
			return "giangvien/ChiTietNhiemVu";
			
		}else {
			return "redirect:/trangchu_giangvien/formdanhgia/"+id;
		}

	}

	// View cua form danh gia
	@GetMapping("trangchu_giangvien/formdanhgia/{id}")
	public String formDanhGia(@PathVariable("id") Long id, Model model) {
		DanhGiaDetail danhgia = new DanhGiaDetail();
		danhgia.setIdNhiemVu(id);
		NhiemVu nv = nhiemvuservice.getNhiemVu(id);
		model.addAttribute("nhiemvu", nv);
		model.addAttribute("danhgia", danhgia);
		
		return "giangvien/danhgia";
	}

	// Luu danh gia cho bai tap
	@PostMapping("trangchu_giangvien/danhgia")
	public String danhGia(Model model, @ModelAttribute DanhGiaDetail danhgia, RedirectAttributes redirectAttributes) {
		DanhGia dg = new DanhGia();
		dg.setTen(danhgia.getTenDanhGia());
		dg.setNoidung(danhgia.getNoiDung());
		dg.setTieuchi1(danhgia.getTieuChi1());
		dg.setTieuchi2(danhgia.getTieuChi2());
		dg.setTieuchi3(danhgia.getTieuChi3());
		dg.setTrangthai(danhgia.getTrangThai());
		NhiemVu nv = nhiemvuservice.getNhiemVu(danhgia.getIdNhiemVu());
		dg.setNhiemvu(nv);
		
		try {
			MultipartFile file = danhgia.getFiledg();
			 byte[] bytes = file.getBytes();
			 
			// Get the file and save it somewhere byte[] bytes = file.getBytes(); Path
			
			String filename = file.getOriginalFilename();
			File googleFile = GoogleDrive.createGoogleFile(null, "text/plain", filename, bytes);
			System.out.println("Created Google file!");
	        System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
	        System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
			System.out.println(filename);
			dg.setFile(googleFile.getWebViewLink());
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		model.addAttribute("danhgia", danhgiaservice.save(dg));
		return "redirect:/trangchu_giangvien/nhiemvu";

	}

	// View tao nhiem vu
	@GetMapping("trangchu_giangvien/nhiemvu")
	public String formNhiemVu(Model model,Principal principal) {
		String email = principal.getName();// Email GV
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("listnhiemvu", giangvienservice.getAllNhiemVuSinhVienOfGiangVien(idGv));
		model.addAttribute("listdetai", detaiservice.getAllDeTai()); //bug !!! list detai phải chỉ của gv, ở đây là tất cả đề tài
		model.addAttribute("nhiemvu", new NhiemVuDetail());
		return "giangvien/NhiemVu";
	}

	// Luu 1 nhiem vu
	@PostMapping("trangchu_giangvien/nhiemvu")
	public String nhiemVu(@ModelAttribute NhiemVuDetail nhiemvudetail, Model model, RedirectAttributes redirectAttributes) {
		NhiemVu nhiemvu = new NhiemVu();
		nhiemvu.setTen(nhiemvudetail.getTenNhiemVu());
		
		nhiemvu.setNoidung(nhiemvudetail.getNoiDungNhiemVu());
		//nhiemvu.setFilebt(nhiemvudetail.getFileBt());
		//nhiemvu.setFilehd(nhiemvudetail.getFileHd());
		nhiemvu.setHannop(nhiemvudetail.getHanNop());
		nhiemvu.setNgaytao(nhiemvudetail.getNgayTao());
		nhiemvu.setTrangthai(nhiemvudetail.getTrangThai());
		nhiemvu.setDetai(giangvienservice.getDeTaiById(nhiemvudetail.getIdDeTai())); // save de tai
		
		try {
			MultipartFile file = nhiemvudetail.getFileHd();
			 byte[] bytes = file.getBytes();
			 
			// Get the file and save it somewhere byte[] bytes = file.getBytes(); Path
			Path path = Paths.get(UPLOADED_FOLDER_baitap + file.getOriginalFilename());
			Files.write(path, bytes);
			String filename = file.getOriginalFilename();
			File googleFile = GoogleDrive.createGoogleFile(null, "text/plain", filename, bytes);
			System.out.println("Created Google file!");
	        System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
	        System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
			System.out.println(filename);
			nhiemvu.setFilehd(googleFile.getWebViewLink());
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		nhiemvuservice.save(nhiemvu);
		return "redirect:/trangchu_giangvien/nhiemvu";
	}

	// View tao tro chuyen
	@GetMapping("trangchu_giangvien/trochuyen")
	public String formTroChuyen(Model model,Principal principal) {
		
		String email = principal.getName();// Email GV
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("listtrochuyen", giangvienservice.getAllTroChuyenSinhVienOfGiangVien(idGv));
		
		model.addAttribute("listdetai", detaiservice.getAllDeTai()); //bug !!! list detai phải chỉ của gv, ở đây là tất cả đề tài
		model.addAttribute("trochuyen", new TroChuyenDetail());
		return "giangvien/TroChuyen";
	}

	// Luu 1 bai dang
	@PostMapping("trangchu_giangvien/trochuyen")
	public String troChuyen(@ModelAttribute TroChuyenDetail trochuyendetail, Model model, RedirectAttributes redirectAttributes) {
		BaiDang bd = new BaiDang();
		bd.setTen(trochuyendetail.getTenBaiDang());
		bd.setNoidung(trochuyendetail.getNoiDung());
		bd.setNgaytao(trochuyendetail.getNgayTao());
//		tt.setFile(trochuyendetail.getFile());
		bd.setDetai(giangvienservice.getDeTaiById(trochuyendetail.getIdDeTai()));// Truyen id de tai
		
		
		try {
			MultipartFile file = trochuyendetail.getFile();
			 byte[] bytes = file.getBytes();
			// Get the file and save it somewhere byte[] bytes = file.getBytes(); Path
			Path path = Paths.get(UPLOADED_FOLDER_trochuyen + file.getOriginalFilename());
			Files.write(path, bytes);
			String filename = file.getOriginalFilename();
			System.out.println(filename);
			bd.setFile(UPLOADED_FOLDER_trochuyen + filename);
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		trochuyenservice.save(bd);

		return "redirect:/trangchu_giangvien/trochuyen";
	}

	// View Danh sach nhiem vu cua sinh vien dc gv huong dan
	@GetMapping("trangchu_giangvien/listnhiemvu")
	public String listNhiemVu(Model model, Principal principal) {
		String email = principal.getName();// Email GV
		Long idGv = taikhoanservice.getIdTaiKhoanGiangVien(email);
		model.addAttribute("listnhiemvu", giangvienservice.getAllNhiemVuSinhVienOfGiangVien(idGv));
		return "giangvien/DanhSachNhiemVuCuaSinhVien";
	}

	// View chi tiet nhiem vu
	@GetMapping("trangchu_giangvien/nhiemvu/{id}")
	public String nhiemVu(@PathVariable("id") Long id, Model model) {
		model.addAttribute("nhiemvu", nhiemvuservice.getNhiemVu(id));
		return "ChiTietNhiemVu_GiangVien";
	}

	// View danh sach cuoc tro chuyen
	/*
	 * @GetMapping("trangchu_giangvien/listtrochuyen") public String
	 * listTroChuyen(Model model, Principal principal) { String email =
	 * principal.getName();// Email GV Long idGv =
	 * taikhoanservice.getIdTaiKhoanGiangVien(email);
	 * model.addAttribute("listtrochuyen",
	 * giangvienservice.getAllTroChuyenSinhVienOfGiangVien(idGv)); return
	 * "DanhSachTroChuyen_GiangVien"; }
	 */

	// View chi tiet tro chuyen
	@GetMapping("trangchu_giangvien/trochuyen/{id}")
	public String troChuyenDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("trochuyen", trochuyenservice.getTroChuyen(id));
		return "giangvien/ChiTietTroChuyen";
	}

	// View Thong ke tong quan cua 1 sinh vien
	@GetMapping("trangchu_giangvien/thongke/{id}")
	public String listThongKe(Model model, @PathVariable Long id) {
		model.addAttribute("sinhvien", sinhvienservice.getOne(id)); // lay ra thong tin cua sinh vien
		model.addAttribute("detai", detaiservice.getDoanbyIdSv(id));
		model.addAttribute("thongke", giangvienservice.hoanThanh(id)); // show ra so luong nhiem vu hoan thanh/ tong
																		// nhiem vu
		model.addAttribute("list", giangvienservice.getAllNhiemVuDuocDanhGiaSinhVien(id));
		return "giangvien/thongke";
	}

	// Chi tiet danh gia
	@GetMapping("trangchu_giangvien/danhgia/{id}")
	public String danhGia(@PathVariable("id") Long id, Model model) {
		model.addAttribute("danhgia", danhgiaservice.getOne(id));
		return "ChiTietDanhGia_GiangVien";
	}
}
