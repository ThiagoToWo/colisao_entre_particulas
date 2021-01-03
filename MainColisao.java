import java.awt.Color;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import janela.JanelaAnimacao;
import tarefas.Animacao;

public class MainColisao {

	public static void main(String[] args) {
		// l� um string para o n�mero de part�culas		
		String numDeParticulas = JOptionPane.showInputDialog("N�mero de part�culas (int): ");
		while (!numDeParticulas.matches("\\d*")) {
			numDeParticulas = JOptionPane.showInputDialog("N�mero de part�culas (int): ");
		}
		// l� um string para a area de movimenta��o
		String aresta = JOptionPane.showInputDialog("Lado do quadrado de movimenta��o (int): ");
		while (!aresta.matches("\\d*")) {
			aresta = JOptionPane.showInputDialog("�rea (int): ");
		}
		// l� um string para o tamanho part�culas	
		String diametDasParticulas = JOptionPane.showInputDialog("Di�metro das part�culas (int): ");
		while (!diametDasParticulas.matches("\\d*")) {
			diametDasParticulas = JOptionPane.showInputDialog("Di�metro das part�culas (int): ");
		}
		// l� um string para a velocidade das part�culas	
		String velDasParticulas = JOptionPane.showInputDialog("Velocidade das part�culas (int): ");
		while (!velDasParticulas.matches("\\d*")) {
			velDasParticulas = JOptionPane.showInputDialog("Velocidade das part�culas (int): ");
		}
		// cria os inteiros que ser�o as var�aves da qual depende o per�odo entre as colis�es
		int N = new Integer(numDeParticulas);
		int a = new Integer(aresta);
		int d = new Integer(diametDasParticulas);
		int v = new Integer(velDasParticulas);
		// cria um array de part�culas
		Particula[] particulas = new Particula[N];
		// cria N part�culas
		for (int i = 0; i < particulas.length; i++) {
			int x = new SecureRandom().nextInt(a);
			int y = new SecureRandom().nextInt(a);
			int[] direcoes = {-1, 1};
			int dir = direcoes[new SecureRandom().nextInt(direcoes.length)];
			int vx = (int) (dir * v * Math.sqrt(2) / 2);
			int vy = (int) (dir * v * Math.sqrt(2) / 2);
			if (i < particulas.length / 2) particulas[i] = new Particula(x, y, d, d, Color.black);
			else particulas[i] = new Particula(x, y, d, d, Color.white);
			// configura a velocidade da part�cula
			particulas[i].setInc(vx, vy);
		}
		// cria o painel de movimenta��o
		Espaco espaco = new Espaco(particulas);
		espaco.setBackground(Color.red);
		// cria uma anima�ao para o painel
		Animacao an = new Animacao(espaco);
		// adiciona a anima�ao � janela de anima��o
		JanelaAnimacao jan = new JanelaAnimacao(an);
		// configura o tamanho da janela de anima��o
		jan.setSize(a, a);
		// configura��es finais
		jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jan.setLocationRelativeTo(null);
		jan.setResizable(false);
		jan.setVisible(true);
	}
}
