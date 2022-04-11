package JogoDaVelha.Regras;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

	private List<String> posicoesJogadas = new ArrayList<>();
	private String nome;
	private boolean comecouPrimeiro;

	public Jogador(String nome, boolean comecouPrimeiro) {
		this.nome = nome;
		this.comecouPrimeiro = comecouPrimeiro;
	}
	
	public List<String> adicionarPosicaoJogada(String posicao){
		posicoesJogadas.add(posicao);
		
		return posicoesJogadas;
	}
	
	public String simbolo() {
		
		if(comecouPrimeiro) {
			return "X";
		} else {
			return "O";
		}
	}

	public List<String> getPosicoesJogadas() {
		return posicoesJogadas;
	}


	public String getNome() {
		return nome;
	}


	public boolean isComecouPrimeiro() {
		return comecouPrimeiro;
	}

}
