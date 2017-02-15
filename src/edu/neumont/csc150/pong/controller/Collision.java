package edu.neumont.csc150.pong.controller;

public class Collision {
	private GameManager game;
	public Collision(GameManager game){
		this.game = game;
	}
	
	
	public void upDownCollision(int ceiling, int floor){
		if(game.getBall().getyPosition() >= ceiling - game.getBall().getHeight() || game.getBall().getyPosition() <= floor - game.getBall().getHeight()){
			//game.getBall().setyVelocity(game.getBall().getyVelocity() * -1);
		}

		
	}
	public void scoreCollision(int rWall, int lWall){
		if(game.getBall().getxPosition() >= rWall){
			game.resetBall();
			game.getGUI().getDrawingPanel().stopTimer();
			game.getBall().setxVelocity(game.getBall().getxVelocity() * -1);
		}
		if( game.getBall().getxPosition() <= lWall){
			game.resetBall();
			game.getGUI().getDrawingPanel().stopTimer();
			
		}
		
	}
	public void paddleCollision(){
		int p1Height = game.getPaddle1().getHeight();
		int p2Height = game.getPaddle2().getHeight();
		int p1XPos = game.getPaddle1().getxPosition();
		int p1YPos = game.getPaddle1().getyPosition();
		int p2XPos = game.getPaddle2().getxPosition();
		int p2YPos = game.getPaddle1().getyPosition();
		int ballx = game.getBall().getxPosition();
		int bally = game.getBall().getyPosition();
		System.out.println("Hello!");
		if(ballx == p1XPos && bally >= p1YPos && bally <= p1YPos + p1Height){
			game.getBall().setxVelocity(game.getBall().getxVelocity() * -1);
			
		}
		if(ballx == p2XPos  && bally >= p2YPos && bally <= p2YPos + p2Height){
			game.getBall().setxVelocity(game.getBall().getxVelocity() * -1);
		}
	}
	/**
	 * Detects if there is a collision and returns true if paddle 1 tries to leave the screen
	 * @return
	 */
	public boolean isPaddle1Collision(){
		if (game.getPaddle1().getxPosition() > 0 && game.getPaddle1().getxPosition() < 1900) {
			return false;
		} else {
			return true;
		}
		
	}
	/**
	 * Detects if there is a collision and returns true if paddle 2 tries to leave the screen
	 * @return
	 */
	public boolean isPaddle2Collision(){
		if (game.getPaddle2().getxPosition() > 0 && game.getPaddle2().getxPosition() < 1900) {
			return false;
		} else {
			return true;
		}
		
	}
}
