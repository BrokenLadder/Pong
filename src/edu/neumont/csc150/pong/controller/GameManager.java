package edu.neumont.csc150.pong.controller;

import edu.neumont.csc150.pong.model.Paddle;
import edu.neumont.csc150.pong.model.Ping;

import edu.neumont.csc150.pong.view.GUI;

public class GameManager {
	private GUI gui;
	private Paddle paddle1;
	private Paddle paddle2;
	private Ping ball;
	public void run() {
		paddle1 = new Paddle(50,120,30,100,100);
		paddle2 = new Paddle(50,120,30,100,1000);
		setBall(new Ping(30,30,0,0,300,300));
		gui = new GUI(this);
		gui.initGUI();
	}
	public void isWon(){
		
	}
	public void restart(){
		gui.resetGUI();
		
	}
	public void startAnimationBall(){
		
	}
	public void p1Movement(){
		
	}
	public void p2Movement(){
		
	}
	public Paddle getPaddle1() {
		return paddle1;
	}
	public Paddle getPaddle2() {
		return paddle2;
	}
	public Ping getBall() {
		return ball;
	}
	public void setBall(Ping ball) {
		this.ball = ball;
	}
	
}
