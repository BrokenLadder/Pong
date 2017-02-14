package edu.neumont.csc150.pong.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.neumont.csc150.pong.controller.GameManager;

public class GUI implements ActionListener{
	private GameManager game;
	private JFrame window;
	private JPanel mainPanel;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem newGame,exit,theme;
	private Drawing drawingPanel;
	private Font gameFont = new Font("Arial", Font.PLAIN,0);
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
		menu = new JMenu();
		menuBar = new JMenuBar();
		newGame = new JMenuItem();
		exit = new JMenuItem();
		theme = new JMenuItem();
	}
	private void createMenu() { //TODO add to uml
		menu.add(newGame);
		menu.add(theme);
		menu.add(exit);
		menuBar.add(menu);
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
		mainPanel.add(menuBar,BorderLayout.NORTH);
		mainPanel.add(drawingPanel,BorderLayout.CENTER);
	}
	
	private void setGUIFont() {
		mainPanel.setFont(gameFont);
		menuBar.setFont(gameFont);
		
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

	
	
}
