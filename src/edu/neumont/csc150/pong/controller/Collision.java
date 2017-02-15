package edu.neumont.csc150.pong.controller;

public class Collision {
	private GameManager game;
	public Collision(GameManager game){
		this.game = game;
	}
	
	
	public void upDownCollision(int ceiling, int floor){
		if(game.getBall().getxPosition() >= ceiling - game.getBall().getHeight() || game.getBall().getxPosition() <= floor - game.getBall().getHeight()){
			game.getBall().setyVelocity(game.getBall().getyVelocity() * -1);
		}

		
	}
	public void scoreCollision(int rWall, int lWall){
		if(game.getBall().getxPosition() >= rWall || game.getBall().getxPosition() <= lWall){
			
			System.out.println("YOU SCORED");
		}
		
	}
	public void paddleCollision(){
		
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
