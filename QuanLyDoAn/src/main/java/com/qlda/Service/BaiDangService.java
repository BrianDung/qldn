package com.qlda.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.qlda.Entity.BaiDang;
import com.qlda.Repository.BaiDangRepository;

public class BaiDangService {
	
	@Autowired
	BaiDangRepository baidangRepository;
	
	public BaiDang save(BaiDang baidang) {
		
		return baidangRepository.save(baidang);
	}
	
	
	
}
