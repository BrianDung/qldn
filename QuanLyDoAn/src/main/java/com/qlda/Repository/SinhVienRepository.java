package com.qlda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.SinhVien;
import com.qlda.Model.TroChuyenDetail;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

	
	
}
