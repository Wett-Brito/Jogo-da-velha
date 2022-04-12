package JogoDaVelha.Tabuleiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import JogoDaVelha.Regras.Jogador;

public class Tabuleiro {

	private static List<String> posicoesValidas = new ArrayList<>();
	private static String a3 = " ", a2 = " ", a1 = " ", b3 = " ", b2 = " ", b1 = " ", c3 = " ", c2 = " ", c1 = " ";

	
	
	public static void mostrarTabuleiroEmBranco() {
		System.out.println("--------------------------");
		System.out.println("3    │   │   ");
		System.out.println("  ―――│―――│―――");
		System.out.println("2    │   │   ");
		System.out.println("  ―――│―――│―――");
		System.out.println("1    │   │   ");
		System.out.println("   a   b   c   ");
		System.out.println("--------------------------");
	}
	
	public static void rezetarListaPosicoesValidas() {
		posicoesValidas.clear();
		posicoesValidas.addAll(Arrays.asList("a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"));
		a3 = " ";
		a2 = " ";
		a1 = " "; 
		b3 = " "; 
		b2 = " "; 
		b1 = " "; 
		c3 = " "; 
		c2 = " "; 
		c1 = " ";
	}
	
	public static List<String> listaPosicoesValidas() {
		return posicoesValidas;
	}
	
	public static List<String> removerPosicaoValida(String posicao){
		posicoesValidas.remove(posicao);
		
		return posicoesValidas;
	}
	
	
	public static String adicionarMarcacaoTabuleiro(Jogador jogador, String posicao) {
	
		return     "3  " + (posicao.equals("a3") ? a3 = jogador.simbolo() : " ") +  "  │ " + (posicao.equals("b3") ? b3 = jogador.simbolo() : " ") + "  │ " + (posicao.equals("c3") ? c3 = jogador.simbolo() : " ") + "  " + "\n"
				 + "  ――――│――――│――――" + "\n"
				 + "2  " + (posicao.equals("a2") ? a2 = jogador.simbolo() : " ") +  "  │ " + (posicao.equals("b2") ? b2 = jogador.simbolo() : " ") + "  │ " + (posicao.equals("c2") ? c2 = jogador.simbolo() : " ") + "  " + "\n"
				 + "  ――――│――――│――――" + "\n"
				 + "1  " + (posicao.equals("a1") ? a1 = jogador.simbolo() : " ") +  "  │ " + (posicao.equals("b1") ? b1 = jogador.simbolo() : " ") + "  │ " + (posicao.equals("c1") ? c1 = jogador.simbolo() : " ") + "  " + "\n"
				 + "   a   b   c   ";
	}
	
	public static String mostarTabuleiroPreenchido() {
		return "3  " + a3 +  "  │ " + b3 + "  │ " + c3 + "  " + "\n"
				 + "  ――――│――――│――――" + "\n"
				 + "2  " + a2 +  "  │ " + b2 + "  │ " + c2 + "  " + "\n"
				 + "  ――――│――――│――――" + "\n"
				 + "1  " + a1 +  "  │ " + b1 + "  │ " + c1 + "  " + "\n"
				 + "   a   b   c   ";
	}
}
