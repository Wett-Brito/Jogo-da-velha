package JogoDaVelha.VelhaDoJogo;

import java.io.IOException;
import java.util.Scanner;

import JogoDaVelha.Controllers.ExceptionsControl;
import JogoDaVelha.Controllers.MotorDoJogo;
import JogoDaVelha.Regras.Bot;
import JogoDaVelha.Regras.Jogador;
import JogoDaVelha.Tabuleiro.Tabuleiro;

public class JogoDaVelhaLaucher {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		MotorDoJogo.limparPagina();

		
		boolean fimJogo = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Bem vindo, qual é o nome do jogador: ");
		String nomeJogador = sc.nextLine();
		MotorDoJogo.limparPagina();
		
		System.out.print("Ola " + nomeJogador + ". Gostaria de jogar primeiro S/N: ");
		boolean jogarPrimeiro;
		
		String respostaJogarPrimeiro = sc.nextLine();
		
		while(!ExceptionsControl.verificarSimOuNao(respostaJogarPrimeiro)) {
			respostaJogarPrimeiro = sc.nextLine();
		}
		
		if(respostaJogarPrimeiro.toLowerCase().trim().equals("s")) {
			jogarPrimeiro = true;
		} else {
			jogarPrimeiro = false;
		}
		MotorDoJogo.limparPagina();

		System.out.println("Escolhar por favor o nivel de dificuldade ");
		System.out.println("1) Completamente burro");
		System.out.println("2) Menos burro");
		System.out.println("3) Começando a pensar");
		System.out.println("4) Pelé da velha");
		System.out.print("Escolha um numero entre as opcoes: ");
		String dificuldade = sc.nextLine();
		
		while(!ExceptionsControl.verificarDificuldade(dificuldade)) {
			dificuldade = sc.nextLine();
		}
		
		MotorDoJogo.limparPagina();
		
		Jogador j1 = new Jogador(nomeJogador, jogarPrimeiro);
		Jogador j2 = new Jogador("Gary", !jogarPrimeiro);
		
		while(!fimJogo){
			
			Tabuleiro.rezetarListaPosicoesValidas();
			
			if(!j1.isComecouPrimeiro()) {
				
				if(Integer.valueOf(dificuldade) < 2) {
					MotorDoJogo.RealizarJogada(Bot.gerarJogadaAleatoria(Tabuleiro.listaPosicoesValidas()), j2);
				} else {
					MotorDoJogo.RealizarJogada(Bot.realizarJogadaCentro(), j2);
					
				}
				
				System.out.println(Tabuleiro.mostarTabuleiroPreenchido());

			}
			if(j1.isComecouPrimeiro()) {
				Tabuleiro.mostrarTabuleiroEmBranco();
			}
			
			while(!MotorDoJogo.isPartidaFinalizada()) {
			
				System.out.println("Qual sera a sua jogada? Exemplos a1 ou b3");
				System.out.print("Posição: ");
				String posicao = sc.nextLine();
				
				while(!ExceptionsControl.VerificarPosicaoDigitada(posicao)) {
					posicao = sc.nextLine();
				}
/*
*		COMENTAR O sc.nextLine E O while ACIMA E DESCOMENTAR A LINHA DE BAIXO, PARA FAZER UM BOT IA X BOT IA
*/
//				String posicao = Bot.realizarJogadaPensadaNivel4(Tabuleiro.listaPosicoesValidas(), j1, j2);

				MotorDoJogo.limparPagina();
				
				while(MotorDoJogo.verificarSeJogadaPermitida(posicao)) {
					System.out.println(Tabuleiro.mostarTabuleiroPreenchido());
					System.out.print("Posição invalida, pois ja foi jogada, favor digitar outra jogada: ");
					posicao = sc.nextLine();
					MotorDoJogo.limparPagina();
				}
				
				MotorDoJogo.RealizarJogada(posicao, j1);
								
				if(MotorDoJogo.isPartidaFinalizada() == true) {
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
				
					while(MotorDoJogo.verificarSeJogadaPermitida(jogadaBot)) {
					jogadaBot = Bot.gerarJogadaAleatoria(Tabuleiro.listaPosicoesValidas());
				}
				
				MotorDoJogo.RealizarJogada(jogadaBot, j2);
				
				
				System.out.println(Tabuleiro.mostarTabuleiroPreenchido());

			}
			
			System.out.print("Gostaria de continuar jogando? S/N: ");
			String respostaContinuar = sc.nextLine();
			while(!ExceptionsControl.verificarSimOuNao(respostaContinuar)) {
				respostaContinuar = sc.nextLine();
			}
				if(respostaContinuar.toLowerCase().trim().equals("n")) {
					MotorDoJogo.limparPagina();
					System.out.println("OBRIGADO POR JOGAR!!             ass: Wellington Brito");
					Thread.sleep(2000);
					
					fimJogo = true;
					MotorDoJogo.limparPagina();
					
				} else {
					MotorDoJogo.reiniciarPartida();
					System.out.print("Gostaria de jogar primeiro? S/N: ");
					
					String respostaJogarPrimeiro2 = sc.nextLine();
					
					while(!ExceptionsControl.verificarSimOuNao(respostaJogarPrimeiro2)) {
						respostaJogarPrimeiro2 = sc.nextLine();
						
					}
					
					if(respostaJogarPrimeiro2.toLowerCase().trim().equals("s")) {
						jogarPrimeiro = true;
					} else {
						jogarPrimeiro = false;
					}
					
					MotorDoJogo.limparPagina();
					
					j1 = new Jogador(nomeJogador, jogarPrimeiro);
					j2 = new Jogador("Gary", !jogarPrimeiro);
					
				}
		}
		
		sc.close();
		
	}

}
