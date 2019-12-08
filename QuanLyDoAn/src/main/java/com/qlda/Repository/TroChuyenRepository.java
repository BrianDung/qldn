package com.qlda.Repository;

import com.qlda.Entity.BaiDang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TroChuyenRepository extends JpaRepository<BaiDang, Long>{

}
