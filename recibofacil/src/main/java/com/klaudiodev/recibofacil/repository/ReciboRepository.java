package com.klaudiodev.recibofacil.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klaudiodev.recibofacil.entity.Recibo;
import com.klaudiodev.recibofacil.entity.User;

public interface ReciboRepository extends JpaRepository<Recibo, Long>{
	 
	List<Recibo> findByUserAndDataServicoBetween(User user, LocalDate start, LocalDate end);
	//contar os recibos emitidos no mês para validar o plano gratuito

}
