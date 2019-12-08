package com.qlda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.BaiDang;
import com.qlda.Model.BaiTapDetail;
import com.qlda.Model.TroChuyenDetail;
import com.qlda.Repository.BaiDangRepository;

@Service
public class BaiDangService {
	
	@Autowired
	BaiDangRepository baidangRepository;
	
	public BaiDang save(BaiDang baidang) {
		
		return baidangRepository.save(baidang);
	}
	
	
	
}
