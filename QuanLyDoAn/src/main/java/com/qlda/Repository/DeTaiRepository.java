package com.qlda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlda.Entity.DeTai;

@Repository
public interface DeTaiRepository extends JpaRepository<DeTai, Long> {

}