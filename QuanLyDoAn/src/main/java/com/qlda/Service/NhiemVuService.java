package com.qlda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.NhiemVu;
import com.qlda.Repository.NhiemVuRepository;

@Service
public class NhiemVuService {
	@Autowired
	NhiemVuRepository nhiemvurepository;

	public NhiemVu getNhiemVu(Long id) {
		return nhiemvurepository.getOne(id);
	}

	public List<NhiemVu> getAllNhiemVu() {
		return nhiemvurepository.findAll();
	}

	public NhiemVu save(NhiemVu nhiemvu) {
		return nhiemvurepository.save(nhiemvu);
	}
}
