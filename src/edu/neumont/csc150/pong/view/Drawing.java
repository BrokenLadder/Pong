package edu.neumont.csc150.pong.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import edu.neumont.csc150.pong.controller.GameManager;
/**
 * Class that draws the ball and creates the animation
 * @author Gabe B
 *
 */
public class Drawing extends JPanel implements ActionListener {
	private static final long serialVersionUID = -7398355064246963722L;
	private GameManager game;
	private BufferedImage image;
	private Color color;
	private Themes theme;
	private Font scoreFont = new Font("Helvetica",150,150);
	private Timer timer = new Timer(1, this);
	/**
	 * Sets the background to an image
	 * @param game
	 * @throws IOException
	 */
	public Drawing(GameManager game) throws IOException {
		this.game = game;
		theme = new Themes(this);
		theme.Theme1();
		//this.setBackground(Color.darkGray);
	}
	/**
	 * Paints the items on the screen, Ball, paddles etc
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, null);
		g.setColor(color);
		g.setFont(scoreFont);
		g.drawString(game.getPlayer1Score() + "", 1102, 250);
		g.drawString(game.getPlayer2Score() + "", 1365, 250);
		g.fillRect(game.getBall().getxPosition(), game.getBall().getyPosition(), 
				   game.getBall().getWidth(), game.getBall().getHeight());
		g.fillRect(game.getPaddle1().getxPosition(), game.getPaddle1().getyPosition(), 
				   game.getPaddle1().getWidth(), game.getPaddle1().getHeight());
		g.fillRect(game.getPaddle2().getxPosition(), game.getPaddle2().getyPosition(), 
				   game.getPaddle2().getWidth(), game.getPaddle2().getHeight());
	
	}
	/**
	 * @Override actionperformend moves the ball
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.timer){
			game.getBall().setxPosition(game.getBall().getxPosition() + game.getBall().getxVelocity());;
			game.getBall().setyPosition(game.getBall().getyPosition() + game.getBall().getyVelocity());;
			game.getCollisions().scoreCollision(2512, 0);
			game.getCollisions().upDownCollision(96, 1154);
			game.getCollisions().paddleCollision();
		}
		this.repaint();
		
	}
	/**
	 * Starts the timer
	 */
	public void startTimer(){
		this.timer.start();
	}
	/**
	 * Stops the timer
	 */
	public void stopTimer(){
		this.timer.stop();
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public Themes getTheme() {
		return theme;
	}
}