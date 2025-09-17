package com.klaudiodev.recibofacil.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klaudiodev.recibofacil.entity.Recibo;
import com.klaudiodev.recibofacil.entity.User;
import com.klaudiodev.recibofacil.services.ReciboService;
import com.klaudiodev.recibofacil.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/cadastrar")
	public User cadastrar(@RequestBody User user) {
		return userService.cadastrarUsuario(user);
	}

	// login simples futuramente JWT

	@PostMapping("/login")
	public User login(@RequestBody Map<String, String> credentials) {
		String email = credentials.get("email");
		String senha = credentials.get("senha");
		return userService.login(email, senha);
	}

	@GetMapping
	public List<User> listar() {
		return userService.listarTodos();
	}

	@GetMapping("/{id}")
	public User buscarPorId(@PathVariable Long id) {
		return userService.buscarPorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		userService.deletarUsuario(id);
	}
}
