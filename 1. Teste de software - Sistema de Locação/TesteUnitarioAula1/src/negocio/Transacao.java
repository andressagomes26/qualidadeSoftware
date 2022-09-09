package negocio;

import java.util.ArrayList;
import negocio.Genero;

public class Transacao {
	
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
	
	
 	public String registrarHora() {
 		String hora = "";
		for(Locacao locacao : alugueis) {
			hora = locacao.data.hora;
		}
		return hora;
	}
 	
	
 	public String registrarData() {
 		String data = "";
		for(Locacao locacao : alugueis) {
			data = locacao.data.data;
		}
		return data;
	}
 	
	
 	public Cliente clienteInativoAlugarFilme() {
		
		for(Locacao locacao : alugueis) {
			if(locacao.cliente.situacao) {
				return locacao.cliente;
			}
		}
		return null;
	}
	
	
	public double calculoDesconto(Genero Genero) {
		double valor=0;
		double desconto = 0;
		for (Locacao locacao : alugueis) {
			if(locacao.filme.genero == Genero.ROMANCE) {
				valor += locacao.filme.valor;
				desconto = 10;
			} else if(locacao.filme.genero == Genero.DRAMA) {
				valor += locacao.filme.valor;
				desconto = 20;
			}
			else if(locacao.filme.genero == Genero.COMEDIA) {
				valor += locacao.filme.valor;
				desconto = 50;
			}
			
		}
		return valor-(valor*(desconto/100));
	}
	
}
