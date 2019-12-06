package com.qlda.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qlda.Entity.GiangVien;
import com.qlda.Entity.SinhVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.SinhVienDetail;
import com.qlda.Repository.TaiKhoanRepository;
import com.qlda.Service.GiangVienService;
import com.qlda.Service.SinhVienService;
import com.qlda.Service.TaiKhoanService;

@Controller
public class TaiKhoanController {

	
	private static String UPLOADED_FOLDER = "F://temp//";
	private static String UPLOADED_FOLDER_baitap = "..//QuanLyDoAn//src//main//resources//File//baitap//";
	private static String UPLOADED_FOLDER_real = "C:/Users/Tran Hau/git/qldn/QuanLyDoAn/src/main/resources/File/";
	@Autowired
	TaiKhoanService taiKhoanService;
	// form login
	
	@Autowired
	GiangVienService giangVienService;
	private GiangVien gv;
	
	
	//test upload file
	
	//end of test upload
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Upload file
	@GetMapping("/upload")
	public String uploadfile(){
		return "uploadfile";
	}
	
	
	@PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:test1";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER_baitap + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
  
        return "redirect:/upload";
    }
	//end upload file
	
	
	


	@Autowired
	SinhVienService sinhVienService;
	private SinhVien sv;


	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	// TỪ chối truy cập
	@GetMapping("/403")
	public String accessDenied(Model model) {
		return "403";
	}

	// View tao 1 tai khoan Gv
	@GetMapping("trangchu_quanly/formtaikhoangv")
	public String formTaiKhoanGv(Model model) {
		GiangVienDetail gv = new GiangVienDetail();
		model.addAttribute("taikhoan", gv);
		return "giaovu/TaoMoiGiangVien";
	}

	// Luu 1 tai khoan giang vien
	@PostMapping("trangchu_quanly/taikhoangv") // Tao 1 oject luu tren database
	public String submitTaiKhoanGv(@ModelAttribute GiangVienDetail taikhoan, Model model) {
		TaiKhoan tk = new TaiKhoan();
		tk.setEmail(taikhoan.getEmail());
		tk.setPassword(taikhoan.getPassword());
		tk.setRole(taikhoan.getRole());

		tk = taiKhoanService.addTaiKhoan(tk);

		GiangVien gv = new GiangVien();
		gv.setNamsinh(taikhoan.getNamSinh());
		gv.setTen(taikhoan.getTen());
		gv.setSodienthoai(taikhoan.getSoDienThoai());
		gv.setTaikhoan(tk);

		giangVienService.addGiangVien(gv);

		return "redirect:/trangchu_quanly/giangvien";
	}

	// View tao 1 tai khoan Sv
	@GetMapping("trangchu_quanly/formtaikhoansv")
	public String formTaiKhoanSv(Model model) {
		model.addAttribute("taikhoansv", new SinhVienDetail());
		model.addAttribute("listgv", giangVienService.getAllGv()); // Lay ra danh sach giang vien
		return "giaovu/TaoMoiSinhVien";
	}

	@PostMapping("trangchu_quanly/taikhoansv")
	public String submitTaiKhoanSv(@ModelAttribute SinhVienDetail sinhviendetail, Model model) {
		TaiKhoan tk = new TaiKhoan();
		tk.setEmail(sinhviendetail.getEmailSv());
		tk.setPassword(sinhviendetail.getPassword());
		tk.setRole(sinhviendetail.getRole());

		tk = taiKhoanService.addTaiKhoan(tk); // Them tai khoan trong db

		SinhVien sv = new SinhVien();
		sv.setMssv(sinhviendetail.getMssv());
		sv.setNamsinh(sinhviendetail.getNamSinhSv());
		sv.setSodienthoai(sinhviendetail.getSoDienThoaiSv());
		sv.setTen(sinhviendetail.getTenSv());
		Long id = sinhviendetail.getIdGv();
		GiangVien gv = giangVienService.getOne(id);

		sv.setTaikhoan(tk);
		sv.setGiangvien(gv);

		sinhVienService.save(sv);
		return "giaovu/TaoMoiSinhVien";
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
