package com.qlda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DeTai;
import com.qlda.Model.TroChuyenDetail;

public interface BaiDangRepository extends JpaRepository<BaiDang, Long> {
	
	
}
