package com.epicode.progettofinaleepicode.entity;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartiteDto {
	
	private LocalDate date;
	private Squadre squadra1;
	private Squadre squadra2;
	private int puntisquadra1;
	private int puntisquadra2;
	private int meteSquadra1;
	private int meteSquadra2;

}
