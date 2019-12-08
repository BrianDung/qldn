package com.qlda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.SinhVien;
import com.qlda.Repository.SinhVienRepository;

@Service
public class SinhVienService {
	@Autowired
	SinhVienRepository sinhvienrepository;

	public SinhVien save(SinhVien sinhvien) {
		return sinhvienrepository.save(sinhvien);
	}

	public List<SinhVien> findAll() {
		return sinhvienrepository.findAll();
	}

	public SinhVien getOne(Long id) {
		return sinhvienrepository.getOne(id);
	}
	
	
}
