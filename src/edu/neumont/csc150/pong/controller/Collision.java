package edu.neumont.csc150.pong.controller;

public class Collision {
	private GameManager game;
	public Collision(GameManager game){
		this.game = game;
	}
	
	
	public void nonScoreCollision(){
		
	}
	public void scoreCollision(){
		
	}
	public void isCollision(){
		
	}
	public boolean isPaddle1Collision(){
		if (game.getPaddle1().getxPosition() > 0 && game.getPaddle1().getxPosition() < 1900) {
			return false;
		} else {
			return true;
		}
		
	}
}
