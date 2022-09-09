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
	Locacao locacao4;
	Locacao locacao5;
	LocacaoFav locacaoFav;
	
	Filme filme;
	Filme filme2;
	Filme filme3;
	Data data;
	
	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao4 = new Locacao();
		locacao5 = new Locacao();
		locacaoFav = new LocacaoFav();
		
		transacao = new Transacao();
		
		filme = new Filme("Java", Genero.ROMANCE);
		filme.valor = 100;
		
		filme2 = new Filme("Java", Genero.DRAMA);
		filme2.valor = 100;
		
		filme3 = new Filme("Java", Genero.COMEDIA);
		filme3.valor = 100;
		
		data = new Data("08/09/2022", "21:22");

		locacao1.alugar(new Cliente("Andressa", 1, false), filme, data);
		locacao2.alugar(new Cliente("Andressa2", 2, true), filme, data);
		
		
		locacao4.alugar(new Cliente("Andressa4", 4, true), filme2, data);
		locacao5.alugar(new Cliente("Andressa5", 5, true), filme3, data);
		
		locacaoFav.alugar(new Cliente("AndressaFav", 6, true), filme, data);
		
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

		locacao.alugar(new Cliente("Izaias", 2, true), f, data);

		transacao.alugueis.add(locacao);
		assertTrue(100 == transacao.valorLocacaoTotal());
	}
	
	// Registrar HORA da locação para os filmes alugado
	public void registrarHoraLocacaoTest() {
		transacao.alugueis.add(locacao1);
		assertEquals("21:22", transacao.registrarHora());
	}
	
	// Registrar DATA da locação para os filmes alugado
	public void registrarDataLocacaoTest() {
		transacao.alugueis.add(locacao1);
		assertEquals("08/09/2022", transacao.registrarData());
	}
	

	// Cliente inativo = não pode alugar filmes.
	@Test 
	public void clienteInativoAlugarFilmeTest() {
		transacao.alugueis.add(locacao1);
		assertNull(transacao.clienteInativoAlugarFilme());
	}
	
	// Cliente ativo = pode alugar filmes.
	@Test 
	public void clienteAtivoAlugarFilmeTest() {
		transacao.alugueis.add(locacao2);
		assertEquals("Andressa2", transacao.clienteInativoAlugarFilme().nome);
	}
	
	// Desconto de aluguel - Gênero Romance 
	@Test 
	public void calculoDescontoRomanceTest() {
		transacao.alugueis.add(locacao1);
		assertEquals(90,transacao.calculoDesconto(filme.genero),0.01);
	}
	
	// Desconto de aluguel - Gênero Drama 
	@Test 
	public void calculoDescontoDramaTest() {
		transacao.alugueis.add(locacao4);
		assertEquals(80,transacao.calculoDesconto(filme2.genero),0.01);
	}
	
	// Desconto de aluguel - Gênero Comedia 
	@Test 
	public void calculoDescontoComediaTest() {
		transacao.alugueis.add(locacao5);
		assertEquals(50,transacao.calculoDesconto(filme3.genero),0.01);
	}
	
	
	// Testar quais gêneros são mais alugados
	@Test 
	public void buscaGeneroMaisAlugadoTest() {
	 	transacao.alugueis.add(locacao1);
	 	transacao.alugueis.add(locacao2);
	 	transacao.alugueis.add(locacao4);
	 	transacao.alugueis.add(locacao5);
	 		
	 	assertEquals(filme.genero, transacao.buscaGeneroMaisAlugado());
	}
	
	
	// Permitir que o cliente possa fazer uma lista de filmes favorito
	@Test
	public void listaFilmesFavoritos() {
		transacao.alugueisFavoritos.add(locacaoFav);
	 	assertEquals("Java", transacao.listaFilmesFavoritos(true));
	}
	
}

