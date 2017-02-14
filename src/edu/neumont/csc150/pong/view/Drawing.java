package edu.neumont.csc150.pong.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import edu.neumont.csc150.pong.model.Ping;



public class Drawing extends JPanel implements ActionListener {
	private Timer timer = new Timer((2),this);
	public Ping ping;
	public Drawing(Ping ball) {
		this.ping = ball;
		this.setBackground(Color.darkGray);
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(ping.getxPosition(), ping.getyPosition(), ping.getWidth(), ping.getHeight());
		super.paint(g);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.timer) {
			if (ping != null) {
				ping.setxPosition(ping.getxPosition() + ping.getxVelocity());
				ping.setyPosition(ping.getyPosition() + ping.getyVelocity());
				//ping.detectCollision(this.getWidth(), this.getHeight(), 0, 0);
			}
		} 
		this.repaint();
	}

}
