package com.klaudiodev.recibofacil.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klaudiodev.recibofacil.entity.User;
import com.klaudiodev.recibofacil.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User cadastrarUsuario(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email já cadastrado!");
		}
		return userRepository.save(user);
	}

	public User buscarPorId(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
	}

	public List<User> listarTodos() {
		return userRepository.findAll();
	}

	/**
	 * Login básico: valida email e senha.
	 */
	public User login(String email, String senha) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

		if (!user.getSenha().equals(senha)) {
			throw new RuntimeException("Senha inválida!");
		}

		return user;
	}

	public void deletarUsuario(Long id) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("Usuário não encontrado!");
		}
		userRepository.deleteById(id);
	}
}