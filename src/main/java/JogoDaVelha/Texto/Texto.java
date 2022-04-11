package JogoDaVelha.Texto;

public enum Texto {
	TEXTO_VITORIA_X,
	TEXTO_VITORIA_O;
	
	
	public static void limparPagina() {
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
	}
}
