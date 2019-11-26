package com.qlda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.qlda.Entity.GiangVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Repository.GiangVienRepository;
import com.qlda.Repository.TaiKhoanRepository;

@Service
public class GiangVienService {
	
	@Autowired
	GiangVienRepository giangVienRepository;
	

}
