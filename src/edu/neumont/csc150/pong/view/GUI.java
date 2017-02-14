package edu.neumont.csc150.pong.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.neumont.csc150.pong.controller.GameManager;

public class GUI implements ActionListener, KeyListener{
	private GameManager game;
	private JFrame window;
	private JPanel mainPanel;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem newGame,exit,theme;
	private Drawing drawingPanel;
	private Font gameFont = new Font("Helvetica", Font.BOLD, 50);
	
	public GUI(GameManager gameManager) {
		game = gameManager;
	}
	
	public void initGUI() {
		window = new JFrame("Pong");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		loadGUI();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.getContentPane().add(mainPanel);
		window.setVisible(true);
		
	}
	
	private void loadGUI() {
		initializeItems();
		createMenu();
		setLayouts();
		addListeners();
		addPanels();
		setGUIFont();
		setGUIMargins();
		setGUITheme();
	}
	private void initializeItems() { //TODO add to uml
		drawingPanel = new Drawing();
		mainPanel = new JPanel();
		menu = new JMenu("Game Menu");
		menuBar = new JMenuBar();
		newGame = new JMenuItem("New Game");
		exit = new JMenuItem("Exit");
		theme = new JMenuItem("Theme");
		
		newGame.setFont(gameFont);
		exit.setFont(gameFont);
		theme.setFont(gameFont);
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
		window.add(menuBar);
		window.add(mainPanel);
		mainPanel.add(drawingPanel,BorderLayout.CENTER);
	}
	
	private void setGUIFont() {
		mainPanel.setFont(gameFont);
		menuBar.setFont(gameFont);
		menu.setFont(gameFont);
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
