package JogoDaVelha.Regras;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot {

	private static Random rand = new Random();

	public static String gerarJogadaAleatoria(List<String> listaPosicoesValidas) {

		return listaPosicoesValidas.get(rand.nextInt(listaPosicoesValidas.size()));
	}

	public static String realizarJogadaCentro() {
		return "b2";
	}

	public static boolean verificoSeCentroFoiJogado(List<String> listaPosicoesValidas) {

		if (listaPosicoesValidas.contains("b2")) {
			return true;
		} else {
			return false;
		}

	}

	public static String realizarJogadaPensadaNivel2(List<String> listaPosicoesValidas, Jogador bot, Jogador j1) {

		if (verificoSeCentroFoiJogado(listaPosicoesValidas)) {
			return "b2";
		}

		boolean center = false;
		int a = 0;
		int b = 0;
		int c = 0;
		int x1 = 0;
		int x2 = 0;
		int x3 = 0;

		for (int i = 0; i < bot.getPosicoesJogadas().size(); i++) {

			if (bot.getPosicoesJogadas().get(i).equals("b2")) {
				center = true;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(0, 1).equals("a")) {
				a++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(0, 1).equals("b")) {
				b++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(0, 1).equals("c")) {
				c++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(1, 2).equals("1")) {
				x1++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(1, 2).equals("2")) {
				x2++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(1, 2).equals("3")) {
				x3++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("a")) {
				a--;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("b")) {
				b--;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("c")) {
				c--;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("1")) {
				x1--;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("2")) {
				x2--;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("3")) {
				x3--;
			}

		}

		boolean aExist = false;
		boolean bExist = false;
		boolean cExist = false;
		boolean x1Exist = false;
		boolean x2Exist = false;
		boolean x3Exist = false;
		boolean a1xExist = false;
		boolean c1xExist = false;
		boolean a3xExist = false;
		boolean c3xExist = false;

		for (String s : listaPosicoesValidas) {

			if (s.substring(0, 1).equals("a")) {
				aExist = true;
			}

			if (s.substring(0, 1).equals("b")) {
				bExist = true;
			}

			if (s.substring(0, 1).equals("c")) {
				cExist = true;
			}

			if (s.substring(1, 2).equals("1")) {
				x1Exist = true;
			}

			if (s.substring(1, 2).equals("2")) {
				x2Exist = true;
			}

			if (s.substring(1, 2).equals("3")) {
				x3Exist = true;
			}

			if (s.equals("a1")) {
				a1xExist = true;
			}

			if (s.equals("c1")) {
				c1xExist = true;
			}

			if (s.equals("a3")) {
				a3xExist = true;
			}

			if (s.equals("c3")) {
				c3xExist = true;
			}

		}

		for (String s : bot.getPosicoesJogadas()) {
			if (s.equals("a1")) {
				a1xExist = true;
			}

			if (s.equals("c1")) {
				c1xExist = true;
			}

			if (s.equals("a3")) {
				a3xExist = true;
			}

			if (s.equals("c3")) {
				c3xExist = true;
			}
		}

		if (center && a1xExist && c3xExist) {
			String posicao = null;
			for (String s : listaPosicoesValidas) {
				if (s.equals("a1") || s.equals("c3")) {
					posicao = s;
					break;
				}

			}
			return posicao;

		} else if (center && a3xExist && c1xExist) {
			String posicao = null;
			for (String s : listaPosicoesValidas) {
				if (s.equals("a3") || s.equals("c1")) {
					posicao = s;
					break;
				}

			}
			return posicao;

		} else if ((b >= a && b >= c && b >= x1 && b >= x2 && b >= x3) && bExist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(0, 1).equals("b")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((a >= b && a >= c && a >= x1 && a >= x2 && a >= x3) && aExist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(0, 1).equals("a")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((c >= a && c >= b && c >= x1 && c >= x2 && c >= x3) & cExist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(0, 1).equals("c")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((x1 >= a && x1 >= b && x1 >= c && x1 >= x2 && x1 >= x3) && x1Exist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(1, 2).equals("1")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((x2 >= a && x2 >= b && x2 >= c && x2 >= x1 && x2 >= x3) && x2Exist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(1, 2).equals("2")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((x3 >= a && x3 >= b && x3 >= c && x3 >= x1 && x3 >= x2) && x3Exist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(1, 2).equals("3")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else {
			return gerarJogadaAleatoria(listaPosicoesValidas);
		}

	}

	public static String realizarJogadaPensadaNivel3(List<String> listaPosicoesValidas, Jogador bot, Jogador j1) {

		if (verificoSeCentroFoiJogado(listaPosicoesValidas)) {
			return "b2";
		}

		boolean center = false;
		int a = 0;
		int b = 0;
		int c = 0;
		int x1 = 0;
		int x2 = 0;
		int x3 = 0;

		for (int i = 0; i < j1.getPosicoesJogadas().size(); i++) {

			if (j1.getPosicoesJogadas().get(i).equals("b2")) {
				center = true;
			}
			
			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("a")) {
				a++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("b")) {
				b++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("c")) {
				c++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("1")) {
				x1++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("2")) {
				x2++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("3")) {
				x3++;
			}

		}
		
		if(a >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("a")) {
					return s;
				}
			}	
		} else if(b >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("b")) {
					return s;
				}
			}	
		} else if(c >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("c")) {
					return s;
				}
			}	
		} else if(x1 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("1")) {
					return s;
				}
			}	
		} else if(x2 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("2")) {
					return s;
				}
			}	
		} else if(x3 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("3")) {
					return s;
				}
			}	
		}
		
		
		boolean aExist = false;
		boolean bExist = false;
		boolean cExist = false;
		boolean x1Exist = false;
		boolean x2Exist = false;
		boolean x3Exist = false;
		boolean a1xExist = false;
		boolean c1xExist = false;
		boolean a3xExist = false;
		boolean c3xExist = false;

		for (String s : listaPosicoesValidas) {

			if (s.substring(0, 1).equals("a")) {
				aExist = true;
			}

			if (s.substring(0, 1).equals("b")) {
				bExist = true;
			}

			if (s.substring(0, 1).equals("c")) {
				cExist = true;
			}

			if (s.substring(1, 2).equals("1")) {
				x1Exist = true;
			}

			if (s.substring(1, 2).equals("2")) {
				x2Exist = true;
			}

			if (s.substring(1, 2).equals("3")) {
				x3Exist = true;
			}

			if (s.equals("a1")) {
				a1xExist = true;
			}

			if (s.equals("c1")) {
				c1xExist = true;
			}

			if (s.equals("a3")) {
				a3xExist = true;
			}

			if (s.equals("c3")) {
				c3xExist = true;
			}

		}

		for (String s : bot.getPosicoesJogadas()) {
			if (s.equals("a1")) {
				a1xExist = true;
			}

			if (s.equals("c1")) {
				c1xExist = true;
			}

			if (s.equals("a3")) {
				a3xExist = true;
			}

			if (s.equals("c3")) {
				c3xExist = true;
			}
		}

		if (center && a1xExist && c3xExist) {
			String posicao = null;
			for (String s : listaPosicoesValidas) {
				if (s.equals("a1") || s.equals("c3")) {
					
					
					posicao = s;
					break;
				}

			}
			return posicao;

		} else if (center && a3xExist && c1xExist) {
			String posicao = null;
			for (String s : listaPosicoesValidas) {
				if (s.equals("a3") || s.equals("c1")) {
					posicao = s;
					break;
				}

			}
			return posicao;

		} else if ((b >= a && b >= c && b >= x1 && b >= x2 && b >= x3) && bExist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(0, 1).equals("b")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((a >= b && a >= c && a >= x1 && a >= x2 && a >= x3) && aExist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(0, 1).equals("a")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((c >= a && c >= b && c >= x1 && c >= x2 && c >= x3) & cExist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(0, 1).equals("c")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((x1 >= a && x1 >= b && x1 >= c && x1 >= x2 && x1 >= x3) && x1Exist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(1, 2).equals("1")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((x2 >= a && x2 >= b && x2 >= c && x2 >= x1 && x2 >= x3) && x2Exist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(1, 2).equals("2")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else if ((x3 >= a && x3 >= b && x3 >= c && x3 >= x1 && x3 >= x2) && x3Exist) {

			List<String> posicoesDisponiveis = new ArrayList<>();

			for (String s : listaPosicoesValidas) {
				if (s.substring(1, 2).equals("3")) {
					posicoesDisponiveis.add(s);
				}
			}

			return posicoesDisponiveis.get((int) Math.floor(Math.random() * posicoesDisponiveis.size()));

		} else {
			return gerarJogadaAleatoria(listaPosicoesValidas);
		}

	}
	
	
	public static String realizarJogadaPensadaNivel4(List<String> listaPosicoesValidas, Jogador bot, Jogador j1) {

		if (verificoSeCentroFoiJogado(listaPosicoesValidas)) {
			return "b2";
		}

		int a = 0;
		int b = 0;
		int c = 0;
		int x1 = 0;
		int x2 = 0;
		int x3 = 0;
		boolean a1 = false;
		boolean a3 = false;
		boolean c1 = false;
		boolean c3 = false;
		boolean center = false;
		
		int bot_a = 0;
		int bot_b = 0;
		int bot_c = 0;
		int bot_x1 = 0;
		int bot_x2 = 0;
		int bot_x3 = 0;
		boolean bot_a1 = false;
		boolean bot_a3 = false;
		boolean bot_c1 = false;
		boolean bot_c3 = false;
		boolean bot_center = false;
		
		for (int i = 0; i < bot.getPosicoesJogadas().size(); i++) {
			
			if ((bot.getPosicoesJogadas().get(i)).substring(0, 1).equals("a")) {
				bot_a++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(0, 1).equals("b")) {
				bot_b++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(0, 1).equals("c")) {
				bot_c++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(1, 2).equals("1")) {
				bot_x1++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(1, 2).equals("2")) {
				bot_x2++;
			}

			if ((bot.getPosicoesJogadas().get(i)).substring(1, 2).equals("3")) {
				bot_x3++;
			}
			
			if(bot.getPosicoesJogadas().get(i).equals("a1")) {
				a1 = true;
			}
			
			if(bot.getPosicoesJogadas().get(i).equals("a3")) {
				a3 = true;
			}
			
			if(bot.getPosicoesJogadas().get(i).equals("c1")) {
				c1 = true;
			}
			
			if(bot.getPosicoesJogadas().get(i).equals("c3")) {
				c3 = true;
			}
			
			if(bot.getPosicoesJogadas().get(i).equals("b2")) {
				center = true;
			}

		}
		
		for (int i = 0; i < j1.getPosicoesJogadas().size(); i++) {
			
			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("a")) {
				a++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("b")) {
				b++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(0, 1).equals("c")) {
				c++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("1")) {
				x1++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("2")) {
				x2++;
			}

			if ((j1.getPosicoesJogadas().get(i)).substring(1, 2).equals("3")) {
				x3++;
			}
			
			if(j1.getPosicoesJogadas().get(i).equals("a1")) {
				bot_a1 = true;
			}
			
			if(j1.getPosicoesJogadas().get(i).equals("a3")) {
				bot_a3 = true;
			}
			
			if(j1.getPosicoesJogadas().get(i).equals("c1")) {
				bot_c1 = true;
			}
			
			if(j1.getPosicoesJogadas().get(i).equals("c3")) {
				bot_c3 = true;
			}
			
			if(j1.getPosicoesJogadas().get(i).equals("b2")) {
				bot_center = true;
			}

		}
		
		if(bot_a1 == true && bot_center == true && listaPosicoesValidas.contains("c3")) {
			return "c3";
		}
		
		if(bot_a3 == true && bot_center == true && listaPosicoesValidas.contains("c1")) {
			return "c1";
		}
		
		if(bot_c1 == true && bot_center == true && listaPosicoesValidas.contains("a3")) {
			return "a3";
		}
		
		if(bot_c3 == true && bot_center == true && listaPosicoesValidas.contains("a1")) {
			return "a1";
		}
		
		if((bot_c1 == true && bot_a3 == true) || (bot_c3 == true && bot_a1 == true) && listaPosicoesValidas.contains("b2")) {
			return "b2";
		}
		
		if(bot_a >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("a")) {
					return s;
				}
			}	
		} else if(bot_b >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("b")) {
					return s;
				}
			}	
		} else if(bot_c >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("c")) {
					return s;
				}
			}	
		} else if(bot_x1 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("1")) {
					return s;
				}
			}	
		} else if(bot_x2 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("2")) {
					return s;
				}
			}	
		} else if(bot_x3 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("3")) {
					return s;
				}
			}	
		}
		
		if(a1 == true && center == true && listaPosicoesValidas.contains("c3")) {
			return "c3";
		}
		
		if(a3 == true && center == true && listaPosicoesValidas.contains("c1")) {
			return "c1";
		}
		
		if(c1 == true && center == true && listaPosicoesValidas.contains("a3")) {
			return "a3";
		}
		
		if(c3 == true && center == true && listaPosicoesValidas.contains("a1")) {
			return "a1";
		}
		
		if((c1 == true && a3 == true) || (c3 == true && a1 == true) && listaPosicoesValidas.contains("b2")) {
			return "b2";
		}
		
		if(a >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("a")) {
					return s;
				}
			}	
		} else if(b >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("b")) {
					return s;
				}
			}	
		} else if(c >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(0, 1).equals("c")) {
					return s;
				}
			}	
		} else if(x1 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("1")) {
					return s;
				}
			}	
		} else if(x2 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("2")) {
					return s;
				}
			}	
		} else if(x3 >= 2) {
			for (String s : listaPosicoesValidas) {
				if(s.substring(1, 2).equals("3")) {
					return s;
				}
			}	
		}
		
		return realizarJogadaPensadaNivel2(listaPosicoesValidas, bot, j1);
	}

}
