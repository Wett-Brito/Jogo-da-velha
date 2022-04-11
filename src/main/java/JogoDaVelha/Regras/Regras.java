package JogoDaVelha.Regras;

import JogoDaVelha.Tabuleiro.Tabuleiro;
import JogoDaVelha.Texto.Texto;

public class Regras {

	private static boolean partidaFinalizada = false;
	
	public static boolean isPartidaFinalizada() {
		return partidaFinalizada;
	}

	public static void RealizarJogada(String posicao, Jogador jogador) {
			
		Tabuleiro.removerPosicaoValida(posicao);
		jogador.adicionarPosicaoJogada(posicao);
		Tabuleiro.adicionarMarcacaoTabuleiro(jogador, posicao);
		verificarVitoria(jogador);
		
	}
	
	public static boolean verificarSeJogadaPermitida(String posicao) {
		for (String string : Tabuleiro.listaPosicoesValidas()) {
			if(string.equals(posicao)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean verificaVelha() {
		if(partidaFinalizada == false && Tabuleiro.listaPosicoesValidas().isEmpty()) {
			
			Texto.limparPagina();
			System.out.println(Tabuleiro.mostarTabuleiroPreenchido());
			System.out.println("Fim da partida...");
			System.out.println("Partida terminou em velha :(");
			partidaFinalizada = true;
			return true;
		}
		
		return false;
	}
	
	public static void fimDaPartida(Jogador jogador) {
		
		Texto.limparPagina();
		System.out.println(Tabuleiro.mostarTabuleiroPreenchido());
		System.out.println("Fim da partida...");
		System.out.println("Vitoria do jogador " + jogador.getNome() + "!!!!");
		partidaFinalizada = true;
	}
	
	public static void verificarVitoria(Jogador jogador) {
		if(verificaVelha()) {
			return;
		}
			
		boolean a1_for = false;
		boolean a3_for = false;
		boolean c1_for = false;
		boolean c3_for = false;
		boolean center = false;
		int a = 0;
		int b = 0;
		int c = 0;
		int x1 = 0;
		int x2 = 0;
		int x3 = 0;
		
		for (int i = 0; i < jogador.getPosicoesJogadas().size(); i++) {
			
			if(jogador.getPosicoesJogadas().get(i).equals("b2")) {
				center = true;
			}
			
			if(jogador.getPosicoesJogadas().get(i).equals("a1")){
				a1_for = true;
			}
			
			if(jogador.getPosicoesJogadas().get(i).equals("a3")){
				a3_for = true;
			}
			
			if(jogador.getPosicoesJogadas().get(i).equals("c1")){
				c1_for = true;
			}
			
			if(jogador.getPosicoesJogadas().get(i).equals("c3")){
				c3_for = true;
			}
			
			if((jogador.getPosicoesJogadas().get(i)).substring(0,1).equals("a")) {
				a++;
			}
			
			if((jogador.getPosicoesJogadas().get(i)).substring(0,1).equals("b")) {
				b++;
			}

			if((jogador.getPosicoesJogadas().get(i)).substring(0,1).equals("c")) {
				c++;
			}
			
			if((jogador.getPosicoesJogadas().get(i)).substring(1,2).equals("1")) {
				x1++;
			}
			
			if((jogador.getPosicoesJogadas().get(i)).substring(1,2).equals("2")) {
				x2++;
			}
			
			if((jogador.getPosicoesJogadas().get(i)).substring(1,2).equals("3")) {
				x3++;
			}
			
		}
		
		if(a == 3 || b == 3 || c == 3) {
			fimDaPartida(jogador);
		}
		
		if(x1 == 3 || x2 == 3 || x3 == 3) {
			fimDaPartida(jogador);
			
		}
		
		if(((a1_for && c3_for) || (a3_for && c1_for)) && center) {
			fimDaPartida(jogador);
		}
	}
	
	public static void reiniciarPartida() {
		partidaFinalizada = false;
	}
		
}
