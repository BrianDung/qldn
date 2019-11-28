package com.qlda.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.GiangVien;
import com.qlda.Entity.QuanLy;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.SinhVienDetail;

@Repository
public interface QuanLyRepository extends JpaRepository<QuanLy, Long> {
//	@Override
//	default Optional<QuanLy> findById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Query("SELECT new com.qlda.Model.SinhVienDetail(sv.id, sv.ten, sv.mssv, tk.email, gv.id, gv.ten, dt.id, dt.ten)"
			+ " FROM DeTai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.taikhoan tk INNER JOIN sv.giangvien gv ")
	List<SinhVienDetail> getAllListStudentDoAn();

	@Query("SELECT new com.qlda.Model.SinhVienDetail(sv.id,sv.ten, sv.mssv, sv.sodienthoai, tk.email, sv.namsinh, gv.ten, gv.sodienthoai, dt.ten)"
			+ " FROM DeTai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.taikhoan tk INNER JOIN sv.giangvien gv ")
	List<SinhVienDetail> getListInfo();

	@Query("SELECT new com.qlda.Model.GiangVienDetail(gv.ten, gv.namsinh, tk.email, gv.sodienthoai, gv.id)"
			+ "FROM GiangVien gv INNER JOIN gv.taikhoan tk")
	List<GiangVienDetail> getAllListGv();

	
	
	
}