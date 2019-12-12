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

import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.BaiTapDetail;
import com.qlda.Model.DoAnDetail;
import com.qlda.Model.TroChuyenDetail;
import com.qlda.Service.BaiDangService;
import com.qlda.Service.DeTaiService;
import com.qlda.Service.GiangVienService;
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
		return "sinhvien/NhiemVu";
	}

	@RequestMapping(value = { "/nhiemvu/{id}" }) // lay ra chi tiet bai tap va danh gia 
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

	@RequestMapping(value = { "/thongke" }) // lay ra chi tiet thong ke
	public String thongKeDetail(Model model, Principal principal) {
		String email = principal.getName();
		Long id = quanlyservice.getInfoSVbyEmail(email).getId();
		model.addAttribute("sinhvien", giangvienservice.getSinhVien(id)); // lay ra thong tin cua sinh vien
		model.addAttribute("thongke", giangvienservice.hoanThanh(id)); // show ra so luong nhiem vu hoan thanh/ tong
																		// nhiem vu
		model.addAttribute("listdanhgiahoanthanhsv", giangvienservice.getAllNhiemVuDuocDanhGiaSinhVien(id));
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
