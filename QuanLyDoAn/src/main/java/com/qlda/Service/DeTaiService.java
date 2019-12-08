package com.qlda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlda.Entity.DeTai;
import com.qlda.Model.DoAnDetail;
import com.qlda.Repository.DeTaiRepository;

@Service
public class DeTaiService {
	@Autowired
	DeTaiRepository detairepository;

	public DeTai save(DeTai detai) {

		return detairepository.save(detai);
	}

	
	public DeTai getOne(Long id) {
		return detairepository.getOne(id);
	}
	
	public DoAnDetail getDoanbyEmailSv(String email) {
		
		for(DoAnDetail da : detairepository.getAllDoAnDetail()) {
			if(da.getEmailSv().equals(email)) {
				return da;
			}
			
		}
		return null;
	}
	public List<DeTai> getAllDeTai() {
		return detairepository.findAll();

	}
}
