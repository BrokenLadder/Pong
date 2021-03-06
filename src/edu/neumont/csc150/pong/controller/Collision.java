package edu.neumont.csc150.pong.controller;

import javax.swing.JOptionPane;

public class Collision {
	private GameManager game;
	public Collision(GameManager game){
		this.game = game;
	}
	
	
	public void upDownCollision(int ceiling, int floor){
		if(game.getBall().getyPosition() <= ceiling  || game.getBall().getyPosition() >= floor - game.getBall().getHeight()){
			game.getBall().setyVelocity(game.getBall().getyVelocity() * -1);
		}

		
	}
	public void scoreCollision(int rWall, int lWall){
		if (game.getPlayer1Score() != 7 && game.getPlayer2Score() != 7) {
			if(game.getBall().getxPosition() >= rWall){
					game.setPlayer1Score(game.getPlayer1Score() + 1);
					game.resetBall();
					game.getGUI().getDrawingPanel().stopTimer();
					game.getBall().setxVelocity(game.getBall().getxVelocity() * -1);
			}
			if (game.getBall().getxPosition() <= lWall){
					game.setPlayer2Score(game.getPlayer2Score() + 1);
					game.resetBall();
					game.getGUI().getDrawingPanel().stopTimer();
			}
		} else {
			game.setPlayer1Score(0);
			game.setPlayer2Score(0);
			JOptionPane.showMessageDialog(null, "GAME OVER: Press enter to play again");
		}
		game.getGUI().getDrawingPanel().startTimer();
	}
	public void paddleCollision(){
		int collisionBoxLength = 30;
			int p1Height = game.getPaddle1().getHeight();
			int p2Height = game.getPaddle2().getHeight();
			int p1Width = game.getPaddle1().getWidth();
			int p2Width = game.getPaddle2().getWidth();
			int p1XPos = game.getPaddle1().getxPosition();
			int p1YPos = game.getPaddle1().getyPosition();
			int p2XPos = game.getPaddle2().getxPosition();
			int p2YPos = game.getPaddle2().getyPosition();
			int ballx = game.getBall().getxPosition();
			int bally = game.getBall().getyPosition();
			int ballHeight = game.getBall().getHeight();
			for (int i = 0; i < collisionBoxLength;i++) {
				if(ballx == (p1XPos - i) + p1Width && bally >= p1YPos - ballHeight && bally <= p1YPos + p1Height){
					game.getBall().setxVelocity(game.getBall().getxVelocity() * -1);
					if (bally >= p1YPos + (p1Height / 3)) {
						game.getBall().setyVelocity(game.getBall().getyVelocity() + 1 * 3);
					} else if (bally <= p1YPos + (p1Height / 3) && bally <= p1YPos + ( 2* (p1Height / 3))) {
						game.getBall().setyVelocity(game.getBall().getyVelocity() + 1 * -1);
					} else {
						game.getBall().setyVelocity(game.getBall().getyVelocity() + 1 * -3);
					}
				}
				if(ballx == (p2XPos + i) - p2Width && bally >= p2YPos - ballHeight && bally <= p2YPos + p2Height){
					game.getBall().setxVelocity(game.getBall().getxVelocity() * -1);
					if (bally >= p2YPos + (p2Height / 3)) {
						game.getBall().setyVelocity(game.getBall().getyVelocity() + 1 * 3);
					} else if (bally <= p2YPos + (p2Height / 3) && bally <= p2YPos + ( 2* (p2Height / 3))) {
						game.getBall().setyVelocity(game.getBall().getyVelocity() + 1 * -1);
					} else {
						game.getBall().setyVelocity(game.getBall().getyVelocity() + 1 * -3);
					}
				}
			}
			
	}
	/**
	 * Detects if there is a collision and returns true if paddle 1 tries to leave the screen
	 * @return
	 */
	public boolean isPaddle1Collision(){
		if (game.getPaddle1().getyPosition() > 0 && game.getPaddle1().getyPosition() < 1900) {
			return true;
		} else {
			return false;
		}
		
	}
	/**
	 * Detects if there is a collision and returns true if paddle 2 tries to leave the screen
	 * @return
	 */
	public boolean isPaddle2Collision(){
		if (game.getPaddle2().getyPosition() > 0 && game.getPaddle2().getyPosition() < 1900) {
			return true;
		} else {
			return false;
		}
		
	}
}
