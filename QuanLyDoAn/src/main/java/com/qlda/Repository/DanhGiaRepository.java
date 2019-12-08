package com.qlda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.DanhGia;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia, Long> {

}
