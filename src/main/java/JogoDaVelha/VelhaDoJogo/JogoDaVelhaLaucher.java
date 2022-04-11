package JogoDaVelha.VelhaDoJogo;

import java.io.IOException;
import java.util.Scanner;

import JogoDaVelha.Regras.Bot;
import JogoDaVelha.Regras.Jogador;
import JogoDaVelha.Regras.Regras;
import JogoDaVelha.Tabuleiro.Tabuleiro;
import JogoDaVelha.Texto.Texto;

public class JogoDaVelhaLaucher {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Texto.limparPagina();

		
		boolean fimJogo = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Bem vindo, qual é o nome do jogador: ");
		String nomeJogador = sc.nextLine();
		Texto.limparPagina();
		
		System.out.print("Ola " + nomeJogador + ". Gostaria de jogar primeiro S/N: ");
		boolean jogarPrimeiro;
		
		if(sc.nextLine().toLowerCase().trim().equals("s")) {
			jogarPrimeiro = true;
		} else {
			jogarPrimeiro = false;
		}
		Texto.limparPagina();

		System.out.println("Escolhar por favor o nivel de dificuldade: ");
		System.out.println("1) Completamente burro");
		System.out.println("2) Menos burro");
		System.out.println("3) Começando a pensar");
		System.out.println("4) Pele da velha");
		String dificuldade = sc.nextLine();
		
		Texto.limparPagina();
		
		Jogador j1 = new Jogador(nomeJogador, jogarPrimeiro);
		Jogador j2 = new Jogador("Gary", !jogarPrimeiro);
		
		while(!fimJogo){
			
			Tabuleiro.rezetarListaPosicoesValidas();
			
			if(!j1.isComecouPrimeiro()) {
				
				if(Integer.valueOf(dificuldade) < 2) {
					Regras.RealizarJogada(Bot.gerarJogadaAleatoria(Tabuleiro.listaPosicoesValidas()), j2);
				} else {
					Regras.RealizarJogada(Bot.realizarJogadaCentro(), j2);
					
				}
				
				System.out.println(Tabuleiro.mostarTabuleiroPreenchido());

			}
			if(j1.isComecouPrimeiro()) {
				Tabuleiro.mostrarTabuleiroEmBranco();
			}
			while(!Regras.isPartidaFinalizada()) {
			
				System.out.println("Qual sera a sua jogada? Exemplos a1 ou b3");			
				String posicao = sc.nextLine();
				Texto.limparPagina();
				
				while(Regras.verificarSeJogadaPermitida(posicao)) {
					System.out.println("Posição invalida, pois ja foi jogada, favor digitar outra jogada: ");
					posicao = sc.nextLine();
				}
				
				Regras.RealizarJogada(posicao, j1);
								
				if(Regras.isPartidaFinalizada() == true) {
					break;
				}
				
				String jogadaBot = null;
				
				if(Integer.valueOf(dificuldade) == 1) {
					jogadaBot = Bot.gerarJogadaAleatoria(Tabuleiro.listaPosicoesValidas());
				} else if (Integer.valueOf(dificuldade) == 2){
					jogadaBot = Bot.realizarJogadaPensadaNivel2(Tabuleiro.listaPosicoesValidas(), j2, j1);
					
				} else if(Integer.valueOf(dificuldade) == 3) {
					jogadaBot = Bot.realizarJogadaPensadaNivel3(Tabuleiro.listaPosicoesValidas(), j2, j1);

				} else if(Integer.valueOf(dificuldade) == 4) {
					jogadaBot = Bot.realizarJogadaPensadaNivel4(Tabuleiro.listaPosicoesValidas(), j2, j1);

				}
				
					while(Regras.verificarSeJogadaPermitida(jogadaBot)) {
					jogadaBot = Bot.gerarJogadaAleatoria(Tabuleiro.listaPosicoesValidas());
				}
				
				Regras.RealizarJogada(jogadaBot, j2);
				
				
				System.out.println(Tabuleiro.mostarTabuleiroPreenchido());

			}
			
			System.out.println("Gostaria de continuar jogando? S/N");
			if(sc.nextLine().toLowerCase().trim().equals("n")) {
				fimJogo = true;
				Texto.limparPagina();
			} else {
				Regras.reiniciarPartida();
				System.out.println("Gostaria de jogar primeiro? S/N");
				
				if(sc.nextLine().toLowerCase().trim().equals("s")) {
					jogarPrimeiro = true;
				} else {
					jogarPrimeiro = false;
				}
				Texto.limparPagina();
				j1 = new Jogador(nomeJogador, jogarPrimeiro);
				j2 = new Jogador("Gary", !jogarPrimeiro);
				
			}
		}
		
		
		sc.close();
		
	}

}
