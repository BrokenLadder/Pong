package edu.neumont.csc150.pong.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

import edu.neumont.csc150.pong.controller.GameManager;
import edu.neumont.csc150.pong.model.Paddle;

public class GUI implements ActionListener, KeyListener{
	private GameManager game;
	private JFrame window;
	private JPanel mainPanel;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem newGame,exit,theme;
	private Drawing drawingPanel;
	private ArrayList<Paddle> isPressedDown = new ArrayList<>();
	private ArrayList<Paddle> isPressedUp = new ArrayList<>();
	private Timer timer = new Timer((200),this);
	private Font gameFont = new Font("Helvetica", Font.BOLD, 50);
	
	public GUI(GameManager gameManager) {
		game = gameManager;
	}
	
	public void initGUI() throws IOException {
		window = new JFrame("Pong");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		loadGUI();
		window.addKeyListener(this);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.getContentPane().add(mainPanel);
		window.setVisible(true);
		
		System.out.println("width: " + window.getWidth());
		System.out.println("height: " + window.getHeight());
		
	}
	
	private void loadGUI() throws IOException {
		initializeItems();
		timer.start();
		createMenu();
		setLayouts();
		addListeners();
		addPanels();
		setGUIFont();
		setGUIMargins();
		setGUITheme();
	}
	private void initializeItems() throws IOException { //TODO add to uml
		mainPanel = new JPanel();
		drawingPanel = new Drawing(game);
		menu = new JMenu("Game Menu");
		menuBar = new JMenuBar();
		newGame = new JMenuItem("New Game");
		exit = new JMenuItem("Exit");
		theme = new JMenuItem("Theme");
	}
	private void createMenu() { //TODO add to uml
		menu.add(newGame);
		menu.add(theme);
		menu.add(exit);
		menuBar.add(menu);
		window.setJMenuBar(menuBar);
	}
	private void setLayouts() {
		mainPanel.setLayout(new BorderLayout());
	}
	
	private void addListeners() {
		newGame.addActionListener(this);
		theme.addActionListener(this);
		exit.addActionListener(this);
	}
	
	private void addPanels() {
		window.add(mainPanel);
		mainPanel.add(drawingPanel,BorderLayout.CENTER);
	}
	
	private void setGUIFont() {
		mainPanel.setFont(gameFont);
		menuBar.setFont(gameFont);
		menu.setFont(gameFont);
		newGame.setFont(gameFont);
		exit.setFont(gameFont);
		theme.setFont(gameFont);
	}
	
	private void setGUIMargins() {
		// TODO Auto-generated method stub
		
	}
	private void setGUITheme() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void resetGUI() {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			isPressedUp.add(game.getPaddle2());
		}
		if(key == KeyEvent.VK_DOWN){
			isPressedDown.add(game.getPaddle2());
		}
		if(key == KeyEvent.VK_W){
			isPressedUp.add(game.getPaddle1());
		}
		if(key == KeyEvent.VK_S){
			isPressedDown.add(game.getPaddle1());
		}
		if (isPressedDown.contains(game.getPaddle1()) && isPressedDown.contains(game.getPaddle2())) {
			game.getPaddle1().setyPosition( //TODO MAYBE? make separate method, add a repaint and change the position multiple times to make smoother animation
					game.getPaddle1().getyPosition() + game.getPaddle1().getyVelocity()
					);
			game.getPaddle2().setyPosition(
					game.getPaddle2().getyPosition() + game.getPaddle2().getyVelocity()
					);
		} else if (isPressedDown.contains(game.getPaddle2()) && !isPressedDown.contains(game.getPaddle1())) {
			game.getPaddle2().setyPosition(
					game.getPaddle2().getyPosition() + game.getPaddle2().getyVelocity()
					);
		} else if (isPressedDown.contains(game.getPaddle1()) && !isPressedDown.contains(game.getPaddle2()))  {
			game.getPaddle1().setyPosition(
					game.getPaddle1().getyPosition() + game.getPaddle1().getyVelocity()
					);
		}
		if (isPressedUp.contains(game.getPaddle1()) && isPressedUp.contains(game.getPaddle2())) {
			game.getPaddle1().setyPosition(
					game.getPaddle1().getyPosition() - game.getPaddle1().getyVelocity()
					);
			game.getPaddle2().setyPosition(
					game.getPaddle2().getyPosition() - game.getPaddle2().getyVelocity()
					);
		} else if (isPressedUp.contains(game.getPaddle2()) && !isPressedUp.contains(game.getPaddle1())) {
			game.getPaddle2().setyPosition(
					game.getPaddle2().getyPosition() - game.getPaddle2().getyVelocity()
					);
		} else if (isPressedUp.contains(game.getPaddle1()) && !isPressedUp.contains(game.getPaddle2()))  {
			game.getPaddle1().setyPosition(
					game.getPaddle1().getyPosition() - game.getPaddle1().getyVelocity()
					);
		}
		drawingPanel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP && isPressedUp.contains(game.getPaddle2())){
			isPressedUp.clear();
		}
		if(key == KeyEvent.VK_DOWN && isPressedDown.contains(game.getPaddle2())){
			isPressedDown.clear();
		}
		if(key == KeyEvent.VK_W && isPressedUp.contains(game.getPaddle1())){
			isPressedUp.clear();
		}
		if(key == KeyEvent.VK_S && isPressedDown.contains(game.getPaddle1())){
			isPressedDown.clear();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	
	
}
