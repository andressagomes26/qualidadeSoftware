package negocio;

import java.util.ArrayList;

public class Transacao {
	
	protected  ArrayList<Locacao> alugueis;
	protected  ArrayList<LocacaoFav> alugueisFavoritos;
	
	public Transacao() {
		
		alugueis= new ArrayList<Locacao>();
		alugueisFavoritos = new ArrayList<LocacaoFav>();
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
				System.out.println("Cliente " + locacao.cliente.nome + " = Ativo (Pode alugar filmes).");
				return locacao.cliente;
			}
			
			System.out.println("Cliente " + locacao.cliente.nome + " = Inativo (Não pode alugar filmes).");
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
				System.out.println("Gênero mais alugado: " + negocio.Genero.ROMANCE);
				return negocio.Genero.ROMANCE;
			} else if (indiceMaior == 1) {
				System.out.println("Gênero mais alugado:" + negocio.Genero.DRAMA);
				return negocio.Genero.DRAMA;
			} else if(indiceMaior == 2) {
				System.out.println("Gênero mais alugado:" + negocio.Genero.COMEDIA);
				return negocio.Genero.COMEDIA;
			}
			
		}
		return null;
	}

	public String listaFilmesFavoritos(boolean favoritos) {
	    
		for (LocacaoFav locacao : alugueisFavoritos) {
			if(favoritos) {
				return locacao.filme.nome;
			}
			
		}
		return null;
	}
	
}
