package com.fatec.ace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.ace.entity.Canal;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Long> {

}
