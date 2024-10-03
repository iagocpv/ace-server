package com.fatec.ace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.ace.entity.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}
