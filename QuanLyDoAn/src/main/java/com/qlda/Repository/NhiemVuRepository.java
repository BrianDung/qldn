package com.qlda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.NhiemVu;

@Repository
public interface NhiemVuRepository extends JpaRepository<NhiemVu, Long> {

}
