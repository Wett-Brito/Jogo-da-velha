package JogoDaVelha.VelhaDoJogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		System.out.println("--------------------------");
		System.out.println("3    │   │   ");
		System.out.println("  ―――│―――│―――");
		System.out.println("2    │   │   ");
		System.out.println("  ―――│―――│―――");
		System.out.println("1    │   │   ");
		System.out.println("   a   b   c   ");
		System.out.println("--------------------------");
		
		String a3 = " ", a2 = " ", a1 = " ", b3 = " ", b2 = " ", b1 = " ", c3 = " ", c2 = " ", c1 = " ";
		
		List<String> posicoesValidas = new ArrayList<>();
		List<String> posicoesX = new ArrayList<>();
		List<String> posicoesY = new ArrayList<>();
		
		
		posicoesValidas.addAll(Arrays.asList("a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"));
		
		Scanner sc = new Scanner(System.in);
		
		int xa = 0;
		int xb = 0;
		int xc = 0;
		int x1 = 0;
		int x2 = 0;
		int x3 = 0;
		boolean xCenter = false;

		int oa = 0;
		int ob = 0;
		int oc = 0;
		int o1 = 0;
		int o2 = 0;
		int o3 = 0;
		boolean oCenter = false;
		
		boolean writeLoop = true;
		
		String posicao = "";
		
		while(!posicoesValidas.isEmpty()) {
			
			while(writeLoop) {
				posicao = sc.nextLine();
				
				for (String string : posicoesValidas) {
					if(string.equals(posicao)) {
						writeLoop = false;
						break;
					}
				}
			}
				
		
			
			writeLoop = true;

			
			
			
			boolean a1_for = false;
			boolean a3_for = false;
			boolean c1_for = false;
			boolean c3_for = false;
			
			for (int i = 0; i < posicoesX.size(); i++) {
				
				if(posicoesX.get(i).equals("b2")) {
					xCenter = true;
				}
				
				if(posicoesX.get(i).equals("a1")){
					a1_for = true;
				}
				
				if(posicoesX.get(i).equals("a3")){
					a3_for = true;
				}
				
				if(posicoesX.get(i).equals("c1")){
					c1_for = true;
				}
				
				if(posicoesX.get(i).equals("c3")){
					c3_for = true;
				}
				
				if((posicoesX.get(i)).substring(0,1).equals("a")) {
					xa++;
				}
				
				if((posicoesX.get(i)).substring(0,1).equals("b")) {
					xb++;
				}

				if((posicoesX.get(i)).substring(0,1).equals("c")) {
					xc++;
				}
				
				if((posicoesX.get(i)).substring(1,2).equals("1")) {
					x1++;
				}
				
				if((posicoesX.get(i)).substring(1,2).equals("2")) {
					x2++;
				}
				
				if((posicoesX.get(i)).substring(1,2).equals("3")) {
					x3++;
				}
				
			}
			
			if(xa == 3 || xb == 3 || xc == 3) {
				System.out.println("Acabou X ganhou 1 ");
				posicoesValidas.clear();
				break;
			}
			
			if(x1 == 3 || x2 == 3 || x3 == 3) {
				System.out.println("Acabou X ganhou 2");
				posicoesValidas.clear();
				break;
			}

			
			if(((a1_for && c3_for) || (a3_for && c1_for)) && xCenter) {
				System.out.println("Acabou X ganhou 3");
				posicoesValidas.clear();
				break;
			}
			
			a1_for = false;
			a3_for = false;
			c1_for = false;
			c3_for = false;
			
			x1 = 0;
			x2 = 0;
			x3 = 0;
			xa = 0;
			xb = 0;
			xc = 0;
			xCenter = false;
			
			Random rand = new Random();
			
			switch (posicoesValidas.get(rand.nextInt(posicoesValidas.size()))) {
			case "a1":
				a1 = "O";
				posicoesValidas.remove("a1");
				posicoesY.add("a1");
				break;
				
			case "a2":
				a2 = "O";
				posicoesValidas.remove("a2");
				posicoesY.add("a2");
				break;
				
			case "a3":
				a3 = "O";
				posicoesValidas.remove("a3");
				posicoesY.add("a3");
				break;
				
			case "b1":
				b1 = "O";
				posicoesValidas.remove("b1");
				posicoesY.add("b1");
				break;
				
			case "b2":
				b2 = "O";
				posicoesValidas.remove("b2");
				posicoesY.add("b2");
				break;
				
			case "b3":
				b3 = "O";
				posicoesValidas.remove("b3");
				posicoesY.add("b3");
				break;
				
			case "c1":
				c1 = "O";
				posicoesValidas.remove("c1");
				posicoesY.add("c1");
				break;
		
			case "c2":
				c2 = "O";
				posicoesValidas.remove("c2");
				posicoesY.add("c2");
				break;
				
			case "c3":
				c3 = "O";
				posicoesValidas.remove("c3");
				posicoesY.add("c3");
				break;
	
			default:
				break;
			}
			
			for (int i = 0; i < posicoesY.size(); i++) {
				
				if(posicoesY.get(i).equals("b2")) {
					oCenter = true;
				}
				
				if(posicoesY.get(i).equals("a1")){
					a1_for = true;
				}
				
				if(posicoesY.get(i).equals("a3")){
					a3_for = true;
				}
				
				if(posicoesY.get(i).equals("c1")){
					c1_for = true;
				}
				
				if(posicoesY.get(i).equals("c3")){
					c3_for = true;
				}
				
				if(posicoesY.get(i).equals("b2")) {
					oCenter = true;
				}
				
				if((posicoesY.get(i)).substring(0,1).equals("a")) {
					oa++;
				}
				
				if((posicoesY.get(i)).substring(0,1).equals("b")) {
					ob++;
				}

				if((posicoesY.get(i)).substring(0,1).equals("c")) {
					oc++;
				}
				
				if((posicoesY.get(i)).substring(1,2).equals("1")) {
					o1++;
				}
				
				if((posicoesY.get(i)).substring(1,2).equals("2")) {
					o2++;
				}
				
				if((posicoesY.get(i)).substring(1,2).equals("3")) {
					o3++;
				}
				
			}
			
			if(oa == 3 || ob == 3 || oc == 3) {
				System.out.println("Acabou O ganhou 1");
				posicoesValidas.clear();
				break;
			}
			
			if(o1 == 3 || o2 == 3 || o3 == 3) {
				System.out.println("Acabou O ganhou 2");
				posicoesValidas.clear();
				break;
			}
			
			if(((a1_for && c3_for) || (a3_for && c1_for)) && oCenter) {
				System.out.println("Acabou O ganhou 3");
				posicoesValidas.clear();
				break;
			}
			
			a1_for = false;
			a3_for = false;
			c1_for = false;
			c3_for = false;
			
			o1 = 0;
			o2 = 0;
			o3 = 0;
			oa = 0;
			ob = 0;
			oc = 0;
			oCenter = false;
			
			String teste = "3  " + a3 +  "  │ " + b3 + "  │ " + c3 + "  " + "\n"
						 + "  ――――│――――│――――" + "\n"
						 + "2  " + a2 +  "  │ " + b2 + "  │ " + c2 + "  " + "\n"
						 + "  ――――│――――│――――" + "\n"
						 + "1  " + a1 +  "  │ " + b1 + "  │ " + c1 + "  " + "\n"
						 + "   a   b   c   ";
			
			System.out.println(teste);
		
		}
		
		sc.close();
	}

}
