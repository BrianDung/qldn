package com.qlda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

}
