package com.qlda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.GiangVienDetail;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
	
	TaiKhoan findByEmail(String email);
}
