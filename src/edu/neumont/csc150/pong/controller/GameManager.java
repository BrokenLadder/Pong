package edu.neumont.csc150.pong.controller;

import edu.neumont.csc150.pong.view.GUI;

public class GameManager {
	private GUI gui;
	public void run() {
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
	
}
