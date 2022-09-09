package negocio;

import java.util.ArrayList;

public class Transacao {
	
	protected  ArrayList<Locacao> alugueis;
	protected  ArrayList<Locacao> alugueisFavoritos;
	
	public Transacao() {
		
		alugueis= new ArrayList<Locacao>();
		alugueisFavoritos = new ArrayList<Locacao>();
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
			if(locacao.filme.genero == negocio.Genero.ROMANCE) {
				valor += locacao.filme.valor;
				desconto = 10;
			} else if(locacao.filme.genero == negocio.Genero.DRAMA) {
				valor += locacao.filme.valor;
				desconto = 20;
			}
			else if(locacao.filme.genero == negocio.Genero.COMEDIA) {
				valor += locacao.filme.valor;
				desconto = 50;
			}
		}
		return valor-(valor*(desconto/100));
	}
	
	
	// Buscar quais gêneros são mais alugados
	public Genero buscaGeneroMaisAlugado() {
		int[] generos = new int[3];
		
		for(Locacao locacao : alugueis) {
			if(locacao.filme.genero == negocio.Genero.ROMANCE) {
				generos[0] += 1;
			} else if(locacao.filme.genero == negocio.Genero.DRAMA) {
				generos[1] += 1;
			} else if(locacao.filme.genero == negocio.Genero.COMEDIA) {
				generos[2] += 1;
			}
			
			int maior = 0;
			int indiceMaior = -1;
			for (int i = 0; i < generos.length; i++) {
			    if (generos[i] > maior) {
			        maior = generos[i];
			        indiceMaior = i;
			    }
			}
		
			if(indiceMaior == 0) {
				return negocio.Genero.ROMANCE;
			} else if (indiceMaior == 1) {
				return negocio.Genero.DRAMA;
			} else if(indiceMaior == 2) {
				return negocio.Genero.COMEDIA;
			}
			
		}
		return null;
	}
}
