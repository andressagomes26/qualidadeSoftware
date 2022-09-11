package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import negocio.Filme;
import negocio.Genero;

public class FilmeTest {

	Filme filme;
	@Before
	public void setUp() throws Exception {
		System.out.println("Antes");
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testFilme() {
		filme= new Filme("Java", Genero.DRAMA);
		assertEquals("Java", filme.nome);
	}

}
