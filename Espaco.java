import paineis.Canvas;
import tarefas.Colisao;

public class Espaco extends Canvas {
	private Colisao col = new Colisao();
	
	public Espaco(Particula[] p) {
		for (int i = 0; i < p.length; i++) addFormaAnimada(p[i]);
	}

	@Override
	public void atualizarAnimado(int i) {
		Particula particula = (Particula) getFormaAnimada(i);
		if (col.colidiuPorDentroDireita(particula, this) || col.colidiuPorDentroEsquerda(particula, this)) {
			particula.setDx(-1 * particula.getDx());
		}		
		
		if (col.colidiuPorDentroAcima(particula, this) || col.colidiuPorDentroAbaixo(particula, this)) { 
			particula.setDy(-1 * particula.getDy());
		}
		
		particula.incAnimacao();
		
		for (int j = 0; j < qtdeDeFormasAnimadas(); j++) {
			if (j == i) continue; // garante que não colidirá uma forma com ela mesma
			
			Particula alvo = (Particula) getFormaAnimada(j);
			if (particula.colidiuCom(alvo) && alvo.getColor() != particula.getColor()) { // movem juntas
				removeFormaAnimada(particula);
				removeFormaAnimada(alvo);
			} else if (particula.colidiuCom(alvo) && alvo.getColor() == particula.getColor()){ // trocam velocidades
				int xTemp = particula.getDx();
				int yTemp = particula.getDy();
				particula.setInc(alvo.getDx(), alvo.getDy());
				alvo.setInc(xTemp, yTemp);
			}
		}
	}
}
