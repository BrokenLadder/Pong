package edu.neumont.csc150.pong.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import edu.neumont.csc150.pong.controller.GameManager;

public class Drawing extends JPanel {
	private static final long serialVersionUID = -7398355064246963722L;
	private GameManager game;
	public Drawing(GameManager game) {
		this.game = game;
		this.setBackground(Color.darkGray);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillRect(game.getBall().getxPosition(), game.getBall().getyPosition(), 
				   game.getBall().getWidth(), game.getBall().getHeight());
		g.fillRect(game.getPaddle1().getxPosition(), game.getPaddle1().getyPosition(), 
				   game.getPaddle1().getWidth(), game.getPaddle1().getHeight());
		g.fillRect(game.getPaddle2().getxPosition(), game.getPaddle2().getyPosition(), 
				   game.getPaddle2().getWidth(), game.getPaddle2().getHeight());
	}
}
