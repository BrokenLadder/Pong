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
/**
 * Class that creates the GUI
 * @author Gabe B
 *
 */
public class GUI implements ActionListener, KeyListener{
	private GameManager game;
	private JFrame window;
	private JPanel mainPanel;
	private JMenu menu, menu2;
	private JMenuBar menuBar;
	private JMenuItem newGame, exit, theme1, theme2, theme3, theme4, theme5;
	private Drawing drawingPanel;
	private ArrayList<Paddle> isPressedDown = new ArrayList<>();
	private ArrayList<Paddle> isPressedUp = new ArrayList<>();
	private Timer timer = new Timer((200),this);
	private Font gameFont = new Font("Helvetica", Font.BOLD, 50);
	/**
	 * Gives the GUI access to gameManager
	 * @param gameManager
	 */
	public GUI(GameManager gameManager) {
		game = gameManager;
	}
	/**
	 * Initializes the GUI
	 * @throws IOException
	 */
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
	/**
	 * loads the GUI
	 * @throws IOException
	 */
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
	/**
	 * Initializes the items
	 * @throws IOException
	 */
	private void initializeItems() throws IOException { //TODO add to uml
		mainPanel = new JPanel();
		drawingPanel = new Drawing(game);
		menu = new JMenu("Game Menu");
		menu2 = new JMenu("Themes");
		menuBar = new JMenuBar();
		newGame = new JMenuItem("New Game");
		exit = new JMenuItem("Exit");
		theme1 = new JMenuItem("Atari");
		theme2 = new JMenuItem("Zelda");
		theme3 = new JMenuItem("Dark Souls");
		theme4 = new JMenuItem("Space");
		theme5 = new JMenuItem("Skyrim");
	}
	/**
	 * Adds the menu to the window
	 */
	private void createMenu() { //TODO add to uml
		menu.add(newGame);
		menu2.add(theme1);
		menu2.add(theme2);
		menu2.add(theme3);
		menu2.add(theme4);
		menu2.add(theme5);
		menu.add(exit);
		menuBar.add(menu);
		menuBar.add(menu2);
		window.setJMenuBar(menuBar);
	}
	/**
	 * sets Layouts
	 */
	private void setLayouts() {
		mainPanel.setLayout(new BorderLayout());
	}
	/**
	 * Adds listeners
	 */
	private void addListeners() {
		newGame.addActionListener(this);
		theme1.addActionListener(this);
		theme2.addActionListener(this);
		theme3.addActionListener(this);
		theme4.addActionListener(this);
		theme5.addActionListener(this);
		exit.addActionListener(this);
	}
	/**
	 * adds panels to the mainPanel
	 */
	private void addPanels() {
		window.add(mainPanel);
		mainPanel.add(drawingPanel,BorderLayout.CENTER);
		
	}
	/**
	 * Sets the font of the GUI
	 */
	private void setGUIFont() {
		mainPanel.setFont(gameFont);
		menuBar.setFont(gameFont);
		menu.setFont(gameFont);
		menu2.setFont(gameFont);
		newGame.setFont(gameFont);
		exit.setFont(gameFont);
		theme1.setFont(gameFont);
		theme2.setFont(gameFont);
		theme3.setFont(gameFont);
		theme4.setFont(gameFont);
		theme5.setFont(gameFont);
		
	}
	/**
	 * Sets the Margins of the GUI
	 */
	private void setGUIMargins() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Sets the theme of the GUI
	 */
	private void setGUITheme() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @Override actionPerformend method for New Game, Exit, Theme
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JMenuItem) {
			JMenuItem sourceItem = (JMenuItem) source;
			if(sourceItem.getText().equals("New Game")) {
				game.restart();
			} else if(sourceItem.getText().equals("Exit")) {
				System.exit(0);
			} else if(sourceItem.getText().equals("Atari")) {
				try {
					drawingPanel.getTheme().Theme1();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				drawingPanel.repaint();
			} else if(sourceItem.getText().equals("Zelda")) {
				try {
					drawingPanel.getTheme().Theme2();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				drawingPanel.repaint();
			} else if(sourceItem.getText().equals("Dark Souls")) {
				try {
					drawingPanel.getTheme().Theme3();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				drawingPanel.repaint();
			} else if(sourceItem.getText().equals("Space")) {
				try {
					drawingPanel.getTheme().Theme4();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				drawingPanel.repaint();
			} else if(sourceItem.getText().equals("Skyrim")) {
				try {
					drawingPanel.getTheme().Theme5();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				drawingPanel.repaint();
			}
		}
	}
	/**
	 * resets the GUI
	 */
	public void resetGUI() {
		drawingPanel.stopTimer();
		game.getBall().setxPosition(1265);
		game.getBall().setyPosition(611);
		game.getPaddle1().setyPosition(100);
		game.getPaddle1().setxPosition(100);
		game.getPaddle2().setyPosition(100);
		game.getPaddle2().setxPosition(2412);
		drawingPanel.repaint();
	}
	/**
	 * returns the drawing Panel
	 * @return
	 */
	public Drawing getDrawingPanel() {
		return this.drawingPanel;
	}
	/**
	 * @Override keypressed, allows users to press the keys to move the Paddles
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) {
			drawingPanel.startTimer();
		}
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
			game.paddleMovement(game.PADDLE_BOTH,game.VELOCITY_POSITIVE);
		} else if (isPressedDown.contains(game.getPaddle2()) && !isPressedDown.contains(game.getPaddle1())) {
			game.paddleMovement(game.PADDLE2,game.VELOCITY_POSITIVE);
		} else if (isPressedDown.contains(game.getPaddle1()) && !isPressedDown.contains(game.getPaddle2()))  {
			game.paddleMovement(game.PADDLE1,game.VELOCITY_POSITIVE);
		}
		if (isPressedUp.contains(game.getPaddle1()) && isPressedUp.contains(game.getPaddle2())) {
			game.paddleMovement(game.PADDLE_BOTH,game.VELOCITY_NEGATIVE);
		} else if (isPressedUp.contains(game.getPaddle2()) && !isPressedUp.contains(game.getPaddle1())) {
			game.paddleMovement(game.PADDLE2,game.VELOCITY_NEGATIVE);
		} else if (isPressedUp.contains(game.getPaddle1()) && !isPressedUp.contains(game.getPaddle2()))  {
			game.paddleMovement(game.PADDLE1,game.VELOCITY_NEGATIVE);
		}
	}
	/**
	 * Key Released, removes keys from the isPressedDown list 
	 */
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
