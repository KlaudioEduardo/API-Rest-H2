package com.klaudiodev.recibofacil.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klaudiodev.recibofacil.entity.Recibo;
import com.klaudiodev.recibofacil.services.ReciboService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recibos")
@RequiredArgsConstructor
public class ReciboController {

	private final ReciboService reciboService;

	@PostMapping
	public Recibo criarRecibo(@RequestBody Recibo recibo) {
		return reciboService.criarRecibo(recibo);
	}

	@GetMapping
	public List<Recibo> listarTodos() {
		return reciboService.listarTodos();
	}

	@GetMapping("/{id}")
	public Recibo buscarPorId(@PathVariable Long id) {
		return reciboService.buscarPorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		reciboService.deletarRecibo(id);
	}
}
