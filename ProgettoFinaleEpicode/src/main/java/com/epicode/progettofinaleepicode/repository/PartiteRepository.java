package com.epicode.progettofinaleepicode.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.progettofinaleepicode.entity.Partite;
import com.epicode.progettofinaleepicode.entity.Squadre;

@Repository
public interface PartiteRepository extends JpaRepository<Partite, Long> {
	
	public Squadre findByDate(LocalDate date);
	public boolean existsByDate(LocalDate date);

}
