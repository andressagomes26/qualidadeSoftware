package negocio;

public class LocacaoFav {

	protected Cliente cliente;
	protected Filme filme;
	protected Data data;
	
	public void alugar(Cliente c, Filme f, Data d) {
		this.cliente = c;
		this.filme = f;
		this.data = d;
	}
}