import java.awt.Color;
import java.awt.Graphics;

import objetos.FormaQueColide;

public class Particula extends FormaQueColide {
	private boolean ativo;
	
	public Particula(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		setAtivo(true);		
	}	
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public void pintar(Graphics g) {
		if (!isAtivo()) return;
		
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}
