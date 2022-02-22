package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach // é chamado antes dos metodos
	public void inicilaizar() {
		System.out.println("inicilalizar");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
	}

	@AfterEach // chamado apos dos metodos serem finalizados
	public void finalizar() {
		System.out.println("fim");
	}

	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Antes de todos");
	}

	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Depois de todos");
	}

	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {

		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerQuinzePorcentoQuandoDesempenhoForBom() {

		service.concederReajuste(funcionario, Desempenho.BOM);

		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {

		service.concederReajuste(funcionario, Desempenho.OTIMO);

		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
