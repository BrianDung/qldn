package com.qlda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.BaiDang;
import com.qlda.Repository.TroChuyenRepository;

@Service
public class TroChuyenService {
	@Autowired
	TroChuyenRepository trochuyenrepository;

	public List<BaiDang> getAllTroChuyen() {
		return trochuyenrepository.findAll();
	}

	public BaiDang save(BaiDang baidang) {
		return trochuyenrepository.save(baidang);
	}
}
