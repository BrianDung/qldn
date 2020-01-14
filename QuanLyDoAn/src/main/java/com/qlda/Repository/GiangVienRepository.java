package com.qlda.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.TaiKhoan;

import com.qlda.Model.BaiTapDetail;

import com.qlda.Model.DanhGiaDetail;

import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.NhiemVuDetail;
import com.qlda.Model.SinhVienDetail;
import com.qlda.Model.TroChuyenDetail;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Long> {
	@Query("SELECT new com.qlda.Model.SinhVienDetail(sv.id , sv.ten , sv.mssv , sv.sodienthoai ,tk.email , dt.id , dt.ten , nv.id , nv.ten)"
			+ "FROM NhiemVu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.taikhoan tk")
	List<SinhVienDetail> getAllSinhVienHuongDan();

	@Query("SELECT new com.qlda.Entity.DeTai(dt.id ,dt.ten , dt.mota , dt.noidung , dt.thongtin,dt.ngaytao,dt.file, dt.trangthai )"
			+ "FROM DeTai dt")
	List<DeTai> getAllDeTai();

	@Query("SELECT new com.qlda.Model.NhiemVuDetail(nv.ten,sv.ten, nv.trangthai, nv.ngaytao, nv.hannop, dt.id,"
			+ "dt.ten, gv.id,nv.id)"
			+ "FROM NhiemVu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv")
	List<NhiemVuDetail> getAllNhiemVu();
	

	@Query("SELECT new com.qlda.Model.BaiTapDetail(dt.id,nv.ten , nv.filebt , nv.filehd , sv.ten , nv.ngaytao ,dg.tieuchi1, dg.tieuchi2, dg.tieuchi3, dg.id,nv.id,gv.id )"
			+ "FROM DanhGia dg INNER JOIN dg.nhiemvu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv")
	List<BaiTapDetail> getAllBaiTapDetail(); // thêm nv.id

	//Lấy tất cả các bài tập 
		@Query("SELECT new com.qlda.Model.BaiTapDetail(nv.id, dt.id, nv.ten, nv.filebt, nv.filehd,\r\n" + 
				"			sv.ten, nv.ngaytao, nv.hannop, nv.noidung, gv.id)"
				+ "FROM NhiemVu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv")
		List<BaiTapDetail> getAllBaiTap(); // thêm nv.id
	@Query("SELECT new com.qlda.Model.TroChuyenDetail(bd.ngaytao, bd.ten, dt.id, bd.id, sv.id,"
			+ "			gv.id, tk.id) "
			+ "FROM BaiDang bd INNER JOIN bd.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv INNER JOIN gv.taikhoan tk")
	List<TroChuyenDetail> getAllTroChuyen();

	@Query("SELECT new com.qlda.Model.DanhGiaDetail(nv.id, sv.id, gv.id, dg.id, dt.id,\r\n"
			+ "	dt.ten, sv.ten,dg.trangthai,dg.file,dg.tieuchi1,dg.tieuchi2,dg.tieuchi3,nv.hannop,nv.ngaytao,nv.ten)"
			+ "FROM DanhGia dg INNER JOIN dg.nhiemvu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv ")
	List<DanhGiaDetail> getAllSinhVienDanhGia();
	
	@Query("SELECT new com.qlda.Model.DanhGiaDetail(nv.id, sv.id, gv.id, dt.id,\r\n"
			+ "	dt.ten, sv.ten,nv.hannop,nv.ngaytao,nv.ten)"
			+ "FROM NhiemVu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv ")
	List<DanhGiaDetail> getSinhVienDanhGia();
}
