package negocio;


public class Cliente {

	protected String nome;
	protected int id;
	protected boolean situacao;
	
	
	public Cliente(String nome, int id, boolean situacao) {
		this.nome= nome;
		this.id= id;
		this.situacao = situacao;
	}
	
}
