package edu.neumont.csc150.pong.controller;

import java.awt.Graphics;
import java.io.IOException;

import edu.neumont.csc150.pong.model.Paddle;
import edu.neumont.csc150.pong.model.Ping;

import edu.neumont.csc150.pong.view.GUI;

public class GameManager {
	private GUI gui;
	private Paddle paddle1;
	private Paddle paddle2;
	private Ping ball;
	private Collision collisions;
	public void run() throws IOException {
		paddle1 = new Paddle(50,120,50,100,100);
		paddle2 = new Paddle(50,120,50,100,2412);
		ball = new Ping(30,30,40,10,1265,611);
		collisions = new Collision(this);
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
	public Collision getCollisions() {
		return collisions;
	}
	
}
