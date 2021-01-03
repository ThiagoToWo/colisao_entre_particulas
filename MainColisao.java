import java.awt.Color;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import janela.JanelaAnimacao;
import tarefas.Animacao;

public class MainColisao {

	public static void main(String[] args) {
		// lê um string para o número de partículas		
		String numDeParticulas = JOptionPane.showInputDialog("Número de partículas (int): ");
		while (!numDeParticulas.matches("\\d*")) {
			numDeParticulas = JOptionPane.showInputDialog("Número de partículas (int): ");
		}
		// lê um string para a area de movimentação
		String aresta = JOptionPane.showInputDialog("Lado do quadrado de movimentação (int): ");
		while (!aresta.matches("\\d*")) {
			aresta = JOptionPane.showInputDialog("Área (int): ");
		}
		// lê um string para o tamanho partículas	
		String diametDasParticulas = JOptionPane.showInputDialog("Diâmetro das partículas (int): ");
		while (!diametDasParticulas.matches("\\d*")) {
			diametDasParticulas = JOptionPane.showInputDialog("Diâmetro das partículas (int): ");
		}
		// lê um string para a velocidade das partículas	
		String velDasParticulas = JOptionPane.showInputDialog("Velocidade das partículas (int): ");
		while (!velDasParticulas.matches("\\d*")) {
			velDasParticulas = JOptionPane.showInputDialog("Velocidade das partículas (int): ");
		}
		// cria os inteiros que serão as varíaves da qual depende o período entre as colisões
		int N = new Integer(numDeParticulas);
		int a = new Integer(aresta);
		int d = new Integer(diametDasParticulas);
		int v = new Integer(velDasParticulas);
		// cria um array de partículas
		Particula[] particulas = new Particula[N];
		// cria N partículas
		for (int i = 0; i < particulas.length; i++) {
			int x = new SecureRandom().nextInt(a);
			int y = new SecureRandom().nextInt(a);
			int[] direcoes = {-1, 1};
			int dir = direcoes[new SecureRandom().nextInt(direcoes.length)];
			int vx = (int) (dir * v * Math.sqrt(2) / 2);
			int vy = (int) (dir * v * Math.sqrt(2) / 2);
			if (i < particulas.length / 2) particulas[i] = new Particula(x, y, d, d, Color.black);
			else particulas[i] = new Particula(x, y, d, d, Color.white);
			// configura a velocidade da partícula
			particulas[i].setInc(vx, vy);
		}
		// cria o painel de movimentação
		Espaco espaco = new Espaco(particulas);
		espaco.setBackground(Color.red);
		// cria uma animaçao para o painel
		Animacao an = new Animacao(espaco);
		// adiciona a animaçao à janela de animação
		JanelaAnimacao jan = new JanelaAnimacao(an);
		// configura o tamanho da janela de animação
		jan.setSize(a, a);
		// configurações finais
		jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jan.setLocationRelativeTo(null);
		jan.setResizable(false);
		jan.setVisible(true);
	}
}
