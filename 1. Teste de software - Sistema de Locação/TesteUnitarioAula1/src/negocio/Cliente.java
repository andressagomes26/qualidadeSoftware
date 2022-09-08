package negocio;

//import negocio.Locacao;
//import negocio.Filme;

public class Cliente {

	protected String nome;
	protected int id;
	protected boolean situacao;
	
	//Locacao locacao;
	//Filme filme;
	
	public Cliente(String nome, int id, boolean situacao) {
		this.nome= nome;
		this.id= id;
		this.situacao = situacao;
	}
	
	/*public boolean clienteInativoAlugarFilme() {
		if(situacao) {
			Locacao locacao = new Locacao();
			Filme filme = new Filme();
			
			return locacao.alugar(Cliente, filme);
			
		}
	}
	
	public void clienteInativoAlugarFilme() {
		if(situacao) {
			return locacao.cliente;
		}
			
		}
		return null;
	}*/
}
