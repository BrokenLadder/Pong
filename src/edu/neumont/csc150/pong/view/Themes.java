package edu.neumont.csc150.pong.view;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Themes {
	private Drawing drawing;
	public Themes(Drawing drawing) {
		this.drawing = drawing;
	}
	public void Theme1() throws IOException {
		drawing.setImage(ImageIO.read(new File("pong_default2.png")));
		drawing.setColor(new Color(255,255,255));
	}
	public void Theme2() throws IOException {
		drawing.setImage(ImageIO.read(new File("zelda_theme1.png")));
		drawing.setColor(new Color(0,4,0));
	}
	public void Theme3() throws IOException {
		drawing.setImage(ImageIO.read(new File("ds_theme.png")));
		drawing.setColor(new Color(244,183,55));
	}
	public void Theme4() throws IOException {
		drawing.setImage(ImageIO.read(new File("space_theme.png")));
		drawing.setColor(new Color(44,236,229));
	}
	public void Theme5() throws IOException {
		drawing.setImage(ImageIO.read(new File("skyrim_theme.png")));
		drawing.setColor(new Color(0,0,0));
	}
}
