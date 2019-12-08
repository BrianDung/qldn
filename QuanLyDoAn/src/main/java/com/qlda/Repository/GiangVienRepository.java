package com.qlda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.SinhVienDetail;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Long> {
	@Query("SELECT new com.qlda.Model.SinhVienDetail(sv.id , sv.ten , sv.mssv , sv.sodienthoai ,tk.email , dt.id , dt.ten , nv.id , nv.ten)"
			+ "FROM NhiemVu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.taikhoan tk")
	List<SinhVienDetail> getAllSinhVienHuongDan();

	@Query("SELECT new com.qlda.Entity.DeTai(dt.id ,dt.ten , dt.mota , dt.noidung , dt.thongtin,dt.ngaytao,dt.file, dt.trangthai )"
			+ "FROM DeTai dt")
	List<DeTai> getAllDeTai();
	
	
}
