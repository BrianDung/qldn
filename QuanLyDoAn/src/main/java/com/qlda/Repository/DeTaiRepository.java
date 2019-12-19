package com.qlda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.DeTai;
import com.qlda.Model.DoAnDetail;

@Repository
public interface DeTaiRepository extends JpaRepository<DeTai, Long> {
	
	@Query("SELECT new com.qlda.Model.DoAnDetail(dt.id, sv.id, sv.ten,tk.id,tk.email,dt.ten )"
			+ "FROM DeTai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.taikhoan tk ")
	List<DoAnDetail> getAllDoAnDetail();
	
	
}
