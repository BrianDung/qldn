package com.qlda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.GiangVien;
import com.qlda.Entity.TaiKhoan;
import com.qlda.Model.GiangVienDetail;
import com.qlda.Model.TaiKhoanDetails;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {

	TaiKhoan findByEmail(String email);

	@Query("SELECT new com.qlda.Model.TaiKhoanDetails(gv.id,tk.id,tk.email)"
			+ "FROM TaiKhoan tk INNER JOIN tk.giangvien gv")
	List<TaiKhoanDetails> listGiangVien();

}
