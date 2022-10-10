package com.epicode.progettofinaleepicode.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SquadreDto {
	
	
	private String nome;
	private int punti;
	private int vittorie;
	private int pareggi;
	private int sconfitte;
	private int giocate;
	private int meteFatti;
	private int meteSubiti;
	private int puntiSubiti;
	private int puntiFatti;
	private int differenza;

}
