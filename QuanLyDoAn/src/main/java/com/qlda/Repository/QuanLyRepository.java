package com.qlda.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.BaiDang;
import com.qlda.Entity.DeTai;
import com.qlda.Entity.GiangVien;
import com.qlda.Entity.QuanLy;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.BaiTapDetail;
import com.qlda.Model.DoAnDetail;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.QuanLyDetail;
import com.qlda.Model.SinhVienDetail;
import com.qlda.Model.TroChuyenDetail;

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

	@Query("SELECT new com.qlda.Model.SinhVienDetail(sv.id,sv.ten, sv.mssv, sv.sodienthoai, tk.email, sv.namsinh, gv.ten, gv.sodienthoai, dt.ten,dt.id)"
			+ " FROM DeTai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.taikhoan tk INNER JOIN sv.giangvien gv ")
	List<SinhVienDetail> getListInfo();
	
	
	

	@Query("SELECT new com.qlda.Model.GiangVienDetail(gv.ten, gv.namsinh, tk.email, gv.sodienthoai, gv.id)"
			+ "FROM GiangVien gv INNER JOIN gv.taikhoan tk")
	List<GiangVienDetail> getAllListGv();

	@Query("SELECT new com.qlda.Entity.DeTai(dt.id , dt.ten, dt.mota, dt.noidung, dt.thongtin , dt.ngaytao, dt.file , dt.trangthai)"
			+ "FROM DeTai dt")
	List<DeTai> getAllDeTai();

	@Query("SELECT new com.qlda.Model.QuanLyDetail(ql.id , ql.ten, ql.sodienthoai, ql.namsinh, tk.email)"
			+ "FROM QuanLy ql INNER JOIN ql.taikhoan tk")
	List<QuanLyDetail> getAllQuanLy();

	@Query("SELECT new com.qlda.Model.DoAnDetail(dt.id, dt.ten, gv.id, gv.ten, sv.id, sv.ten, dt.ngaytao,dt.trangthai)"
			+ "FROM DeTai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv ")
	List<DoAnDetail> getAllDoAnDetail();

	@Query("SELECT new com.qlda.Model.BaiTapDetail(dt.id,nv.ten , nv.filebt , nv.filehd , sv.ten , nv.ngaytao ,dg.tieuchi1, dg.tieuchi2, dg.tieuchi3, dg.id,nv.id )"
			+ "FROM DanhGia dg INNER JOIN dg.nhiemvu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv")
	List<BaiTapDetail> getAllBaiTapDetail(); // thêm nv.id
	
	//Lấy tất cả các bài tập 
	@Query("SELECT new com.qlda.Model.BaiTapDetail(nv.id, dt.id, nv.ten, nv.filebt, nv.filehd,\r\n" + 
			"			sv.ten, nv.ngaytao, nv.hannop, nv.noidung, gv.id)"
			+ "FROM NhiemVu nv INNER JOIN nv.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv")
	List<BaiTapDetail> getAllBaiTap(); // thêm nv.id
	
	@Query("SELECT new com.qlda.Model.BaiTapDetail(nv.id , nv.ten , nv.filehd , nv.hannop , nv.noidung , dg.noidung , dg.file , dg.tieuchi1 , dg.tieuchi2 , dg.tieuchi3 )"
			+ "FROM DanhGia dg INNER JOIN dg.nhiemvu nv ")
	List<BaiTapDetail> getAllDanhGiaBaiTap();

	@Query("SELECT new com.qlda.Model.TroChuyenDetail(bd.ngaytao , bd.ten , bd.noidung, dt.id, bd.id , sv.ten , gv.ten,dt.ten)"
			+ "FROM BaiDang bd INNER JOIN bd.detai dt INNER JOIN dt.sinhvien sv INNER JOIN sv.giangvien gv")
	List<TroChuyenDetail> getAllTroChuyenDetail();

	@Query("SELECT new com.qlda.Entity.BaiDang(bd.id,bd.ten,bd.noidung,bd.ngaytao,bd.file)" + "FROM BaiDang bd")
	List<BaiDang> getAllBaiDang();


}
