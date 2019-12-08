package com.qlda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DeTai;

public interface BaiDangRepository extends JpaRepository<BaiDang, Long> {
	
}
