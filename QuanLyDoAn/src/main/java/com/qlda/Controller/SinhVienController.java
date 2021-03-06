package com.qlda.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.api.services.drive.model.File;
import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.NhiemVu;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.BaiTapDetail;
import com.qlda.Model.DoAnDetail;
import com.qlda.Model.NhiemVuDetail;
import com.qlda.Model.TroChuyenDetail;
import com.qlda.Service.BaiDangService;
import com.qlda.Service.DeTaiService;
import com.qlda.Service.GiangVienService;
import com.qlda.Service.GoogleDrive;
import com.qlda.Service.NhiemVuService;
import com.qlda.Service.QuanLyService;
import com.qlda.Service.SinhVienService;
import com.qlda.Service.TaiKhoanService;

@RequestMapping("/trangchu_sinhvien")
@Controller
public class SinhVienController {

	private static String UPLOADED_FOLDER_trochuyen = "..//QuanLyDoAn//src//main//resources//File//trochuyen//";

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
	@Autowired
	GiangVienService giangvienservice;
	@Autowired
	NhiemVuService nhiemvuservice;
	// GET: Hiển thị trang login
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(Model model, Principal principal) {
		String email = principal.getName();
		model.addAttribute("sinhvien", quanlyservice.getInfoSVbyEmail(email));
		model.addAttribute("listnhiemvu", quanlyservice.getAllBaiTapSV(email));

		return "sinhvien/index-SinhVien";
	}

	@RequestMapping(value = { "/info" }) // lay chi tiet sinh vien
	public String studentDetail(Model model, Principal principal) {
		String email = principal.getName();
		System.out.println(email);

		model.addAttribute("sinhvien", quanlyservice.getInfoSVbyEmail(email));

		return "sinhvien/ThongTin";
	}

	@RequestMapping(value = { "/nhiemvu" }) // Nhiem vu cua sinh vien
	public String giangViens(Model model, Principal principal) {
		String email = principal.getName();
		model.addAttribute("sinhvien", quanlyservice.getInfoSVbyEmail(email)); // Thong tin sinh vien
		model.addAttribute("listnhiemvu", quanlyservice.getAllBaiTapSV(email));
		model.addAttribute("nhiemvu", new NhiemVuDetail());
		return "sinhvien/NhiemVu";
	}

	@RequestMapping(value = { "/nhiemvu/{id}" }) // lay ra chi tiet bai tap va danh gia
	public String baiTapDetail(Model model, @PathVariable("id") Long id) {
		
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
			
			return "sinhvien/ChiTietBaiTapDanhGia";
			
		}else {
			
			model.addAttribute("baitapdanhgia", nhiemvuservice.getNhiemVu(id));
			return "sinhvien/ChiTietBaiTapchuaDanhGia";
		}
//		return "sinhvien/ChiTietDanhGia";
	}
	
	@RequestMapping(value= {"/nopbai"})
	public String nopbai(Model model, @ModelAttribute NhiemVuDetail nhiemvudetail,RedirectAttributes redirectAttributes ) {
		NhiemVu nhiemvu = nhiemvuservice.getNhiemVu(nhiemvudetail.getIdNhiemVu());
		
		try {
			MultipartFile file = nhiemvudetail.getFileBt();
			 byte[] bytes = file.getBytes();
			 
			// Get the file and save it somewhere byte[] bytes = file.getBytes(); Path

			String filename = file.getOriginalFilename();
			File googleFile = GoogleDrive.createGoogleFile(null, "text/plain", filename, bytes);
			System.out.println("Created Google file!");
	        //System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
	        //System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
			System.out.println(filename);
			nhiemvu.setFilebt(googleFile.getWebViewLink());
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		nhiemvu.setTrangthai("HOAN_THANH");
		nhiemvuservice.save(nhiemvu);
		
		
		return "redirect:/trangchu_sinhvien/nhiemvu";
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

	@RequestMapping(value = { "/thongke" }) // lay ra chi tiet thong ke
	public String thongKeDetail(Model model, Principal principal) {
		String email = principal.getName();
		Long id = quanlyservice.getInfoSVbyEmail(email).getIdSv();
		model.addAttribute("sinhvien", sinhvienservice.getOne(id)); // lay ra thong tin cua sinh vien
		model.addAttribute("detai", detaiservice.getDoanbyEmailSv(email));
		model.addAttribute("thongke", giangvienservice.hoanThanh(id)); // show ra so luong nhiem vu hoan thanh/ tong
																		// nhiem vu
		model.addAttribute("list", giangvienservice.getAllNhiemVuDuocDanhGiaSinhVien(id));
		return "sinhvien/thongke";

	}

	@RequestMapping(value = { "/trochuyen" }) // lay ra danh sach tro chuyen
	public String troChuyens(Model model, Principal principal) {
		String email = principal.getName();
		System.out.println(email);
		model.addAttribute("sinhvien", quanlyservice.getInfoSVbyEmail(email));
		model.addAttribute("listtrochuyensinhvien", quanlyservice.getAllTroChuyenSV(email));
		model.addAttribute("baidang", new TroChuyenDetail());
		return "sinhvien/TroChuyen";
	}

	@RequestMapping(value = { "/trochuyen/{id}" }) // lay ra chi tiet tro chuyen
	public String troChuyenDetail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("baidang", quanlyservice.getInfoBaiDang(id));
		return "sinhvien/ChiTietTroChuyen";
	}

	@RequestMapping(value = { "/trochuyen" }, method = RequestMethod.POST) // Tao tro chuyen
	public String taoTroChuyen(Model model, @ModelAttribute TroChuyenDetail tt, Principal principal,
			RedirectAttributes redirectAttributes) {
		String email = principal.getName();
		DoAnDetail doan = detaiservice.getDoanbyEmailSv(email);
		DeTai detai = detaiservice.getOne(doan.getIdDeTai());

		BaiDang bd = new BaiDang();
		bd.setTen(tt.getTenBaiDang());
		bd.setNoidung(tt.getNoiDung());
		bd.setNgaytao(tt.getNgayTao());
		bd.setDetai(detai);

		try {
			MultipartFile file = tt.getFile();
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

		baidangservice.save(bd);
		return "redirect:/trangchu_sinhvien/trochuyen";
	}
}
