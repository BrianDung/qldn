package com.qlda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.DanhGia;
import com.qlda.Repository.DanhGiaRepository;

@Service
public class DanhGiaService {
	@Autowired
	DanhGiaRepository danhgiarepository;

	public DanhGia save(DanhGia danhgia) {
		return danhgiarepository.save(danhgia);
	}
}
