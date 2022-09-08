package negocio;

import java.util.ArrayList;

public class Transacao {

	//Cliente cliente; 
	
	protected  ArrayList<Locacao> alugueis;
	
	public Transacao() {
		
		alugueis= new ArrayList<Locacao>();
	}
	
	public double valorLocacaoTotal() {
	    double valor=0;
		for (Locacao locacao : alugueis) {
			valor +=locacao.filme.valor;
		}
		return valor;
	}
	
	
	/*public Cliente clienteInativoAlugarFilme() {
		
		for(Locacao locacao : alugueis) {
			if(locacao.cliente.situacao) {
				return locacao.cliente;
			}
			/*else {
				return null;
			}
		}
		return null;
	}*/
	
	public Cliente clienteInativoAlugarFilme() {
		
		for(Locacao locacao : alugueis) {
			if(locacao.cliente.situacao) {
				return locacao.cliente;
			}
		}
		return null;
	}
}
