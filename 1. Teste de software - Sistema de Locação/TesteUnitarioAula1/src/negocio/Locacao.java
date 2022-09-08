package negocio;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	
	public void alugar(Cliente c, Filme f) {
		this.cliente = c;
		this.filme = f;
	}
}