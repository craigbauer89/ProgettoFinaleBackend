package com.epicode.progettofinaleepicode.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Squadre {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private int punti  =0;
	private int vittorie =0;
	private int pareggi =0;
	private int sconfitte =0;
	private int giocate =0;
	private int meteFatti =0;
	private int meteSubiti =0;
	private int puntiSubiti =0;
	private int puntiFatti =0;
	private int differenza =0;

}

