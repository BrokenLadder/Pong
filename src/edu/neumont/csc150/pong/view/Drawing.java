package edu.neumont.csc150.pong.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import edu.neumont.csc150.pong.controller.GameManager;

public class Drawing extends JPanel {
	private static final long serialVersionUID = -7398355064246963722L;
	private GameManager game;
	private BufferedImage image;
	public Drawing(GameManager game) throws IOException {
		this.game = game;
		image = ImageIO.read(new File("pong_default2.png"));
		//this.setBackground(Color.darkGray);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, null);
		g.setColor(Color.BLUE);
		g.fillRect(game.getBall().getxPosition(), game.getBall().getyPosition(), 
				   game.getBall().getWidth(), game.getBall().getHeight());
		g.fillRect(game.getPaddle1().getxPosition(), game.getPaddle1().getyPosition(), 
				   game.getPaddle1().getWidth(), game.getPaddle1().getHeight());
		g.fillRect(game.getPaddle2().getxPosition(), game.getPaddle2().getyPosition(), 
				   game.getPaddle2().getWidth(), game.getPaddle2().getHeight());
	}


	
}