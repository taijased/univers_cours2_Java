package ru.kgrf.painting;

import java.awt.Color;
import java.awt.Graphics;

public class Painter {
protected	Graphics g;
	public Painter(Graphics g){
		this.g=g;
	}
	public void paint(){
		g.setColor(Color.BLUE);
		g.fill3DRect(100, 150, 300, 20, false);
	}
}
