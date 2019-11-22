package com.qlda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.TaiKhoan;
@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {

}
