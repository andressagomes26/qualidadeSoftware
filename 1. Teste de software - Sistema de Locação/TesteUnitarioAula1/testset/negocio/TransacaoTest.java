package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import negocio.Cliente;
import negocio.Filme;
import negocio.Genero;
import negocio.Locacao;
import negocio.Transacao;

public class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Filme filme;
	
	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		
		transacao = new Transacao();
		
		filme = new Filme("Java", Genero.ROMANCE);
		filme.valor = 100;

		locacao1.alugar(new Cliente("Andressa", 1, false), filme);
		locacao2.alugar(new Cliente("Andressa2", 2, true), filme);
		
		transacao = new Transacao();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void valorLocacaoTotalTest() {
		Locacao locacao = new Locacao();
		Filme f = new Filme("Java", Genero.ROMANCE);
		f.valor = 100;

		locacao.alugar(new Cliente("Izaias", 2, true), f);

		transacao.alugueis.add(locacao);
		assertTrue(100 == transacao.valorLocacaoTotal());
	}
	

	// Se o cliente for inativo não poderá alugar filmes.
	@Test 
	public void clienteInativoAlugarFilmeTest() {
		transacao.alugueis.add(locacao1);
		assertNull(transacao.clienteInativoAlugarFilme());
	}
	
	// Se o cliente for ativo poderá alugar filmes.
	@Test 
	public void clienteAtivoAlugarFilmeTest() {
		transacao.alugueis.add(locacao2);
		assertEquals("Andressa2", transacao.clienteInativoAlugarFilme().nome);
	}
	
	
	// Desconto de aluguel - Gênero Romance 
	@Test 
	public void calculoDescontoRomanceTest() {
		
		Locacao locacao = new Locacao();
		Filme f = new Filme("Java", Genero.ROMANCE);
		f.valor = 100;

		locacao.alugar(new Cliente("Teste", 3, true), f);

		transacao.alugueis.add(locacao);
		assertEquals(90,transacao.calculoDesconto(f.genero),0.01);
		
	
	}
	
	// Desconto de aluguel - Gênero Drama 
	@Test 
	public void calculoDescontoDramaTest() {
		
		Locacao locacao = new Locacao();
		Filme f = new Filme("Java", Genero.DRAMA);
		f.valor = 100;

		locacao.alugar(new Cliente("Teste", 3, true), f);

		transacao.alugueis.add(locacao);
		assertEquals(80,transacao.calculoDesconto(f.genero),0.01);
		
	}
	
	// Desconto de aluguel - Gênero Comedia 
	@Test 
	public void calculoDescontoComediaTest() {
		
		Locacao locacao = new Locacao();
		Filme f = new Filme("Java", Genero.COMEDIA);
		f.valor = 100;

		locacao.alugar(new Cliente("Teste", 3, true), f);

		transacao.alugueis.add(locacao);
		assertEquals(50,transacao.calculoDesconto(f.genero),0.01);
	}
	
}

