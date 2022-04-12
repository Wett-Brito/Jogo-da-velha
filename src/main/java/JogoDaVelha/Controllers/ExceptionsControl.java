package JogoDaVelha.Controllers;

import java.util.ArrayList;
import java.util.List;

public class ExceptionsControl {
	
	public static boolean VerificarPosicaoDigitada(String posicao) {
		posicao = posicao.trim().toLowerCase();
		List<String> tamanhoPalavra = new ArrayList<>();
		
		for (int i = 0; i < posicao.length(); i++) {
			
			tamanhoPalavra.add(String.valueOf(posicao.charAt(i)));
		}
		
		if(tamanhoPalavra.size() != 2) {
			System.out.print("Por favor digitar uma posição de apenas 2 digitos, como por exemplo (a1 ou b2): ");
			return false;
		}
		
		
		String letra = posicao.substring(0,1);
		String numero = posicao.substring(1,2);
		
		if(!letra.equals("a") && !letra.equals("b") && !letra.equals("c")) {
			System.out.print("Por favor digitar a letra na primeira posição, como por exemplo (a1 ou b2): ");
			return false;
		}
		
		if(!numero.equals("1") && !numero.equals("2") && !numero.equals("3")) {
			System.out.print("Por favor digitar o numero na segunda posição, como por exemplo (a1 ou b2): ");
			return false;
		}
		
		return true;
	}
	
	public static boolean verificarSimOuNao(String resposta) {
		resposta = resposta.toLowerCase().trim();
		List<String> tamanhoPalavra = new ArrayList<>();
		
		for (int i = 0; i < resposta.length(); i++) {
			
			tamanhoPalavra.add(String.valueOf(resposta.charAt(i)));
		}
		
		if(!(tamanhoPalavra.size() == 1) || (!resposta.equals("s") && !resposta.equals("n"))) {
			System.out.print("Por favor digitar apenas S ou N: ");
			return false;
		}
		
		return true;

	}
	
	public static boolean verificarDificuldade(String resposta) {
		resposta = resposta.toLowerCase().trim();
		List<String> tamanhoPalavra = new ArrayList<>();
		
		for (int i = 0; i < resposta.length(); i++) {
			
			tamanhoPalavra.add(String.valueOf(resposta.charAt(i)));
		}
		
		if(!(tamanhoPalavra.size() == 1) || !(Integer.valueOf(resposta) <= 4)) {
			System.out.print("Por favor digitar apenas uma das opções acima: ");
			return false;
		}
		
		return true;
	}
	
}
