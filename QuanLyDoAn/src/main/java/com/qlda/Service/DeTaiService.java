package com.qlda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.DeTai;
import com.qlda.Repository.DeTaiRepository;

@Service
public class DeTaiService {
	@Autowired
	DeTaiRepository detairepository;

	public DeTai save(DeTai detai) {

		return detairepository.save(detai);
	}
}
