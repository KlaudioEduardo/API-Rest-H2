package com.klaudiodev.recibofacil.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klaudiodev.recibofacil.entity.Recibo;
import com.klaudiodev.recibofacil.entity.User;
import com.klaudiodev.recibofacil.repository.ReciboRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReciboService {

	private final ReciboRepository reciboRepository;

	public Recibo criarRecibo(Recibo recibo) {
		User user = recibo.getUser();
		YearMonth currentMonth = YearMonth.now();
		LocalDate start = currentMonth.atDay(1);
		LocalDate end = currentMonth.atEndOfMonth();

		List<Recibo> reciboThisMonth = reciboRepository.findByUserAndDataServicoBetween(user, start, end);

		if (reciboThisMonth.size() >= 3) {
			throw new RuntimeException("Limite do plano gratuito atingido (3 recibos/mês)");
		}

		return reciboRepository.save(recibo);
	}

	public List<Recibo> getAllRecibos(User user) {
		return reciboRepository.findByUserAndDataServicoBetween(user, YearMonth.now().atDay(1),
				YearMonth.now().atEndOfMonth());
	}

	public List<Recibo> buscarRecibosPorUsuario(User user) {
		YearMonth mesAtual = YearMonth.now();
		return reciboRepository.findByUserAndDataServicoBetween(user, mesAtual.atDay(1), mesAtual.atEndOfMonth());
	}

	public List<Recibo> listarTodos() {
		return reciboRepository.findAll();
	}

	public Recibo buscarPorId(Long id) {
		return reciboRepository.findById(id).orElseThrow(() -> new RuntimeException("Recibo não encontrado!"));
	}

	public void deletarRecibo(Long id) {
		if (!reciboRepository.existsById(id)) {
			throw new RuntimeException("Recibo não encontrado!");
		}
		reciboRepository.deleteById(id);
	}

}