package com.fatec.ace.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(nullable = false)
	String nome;
	@CreatedDate
	LocalDateTime dataCriacao;
	@Column
	LocalDateTime prazo;
	@Column
	LocalDateTime conclusao;

}
