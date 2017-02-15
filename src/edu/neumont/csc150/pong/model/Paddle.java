package edu.neumont.csc150.pong.model;

/**
 * Class that creates the Paddle
 * @author Gabe B
 *
 */
public class Paddle {
	int width;
	int height;
	int yVelocity;
	int yPosition;
	int xPosition;
	
/**
 * Constructor method for Paddle	
 * @param width
 * @param height
 * @param yVelocity
 * @param yPosition
 * @param xPosition
 */
public Paddle(int width, int height, int yVelocity, int yPosition, int xPosition) {
	this.width = width;
	this.height = height;
	this.yVelocity = yVelocity;
	this.yPosition = yPosition;
	this.xPosition = xPosition;
}
/**
 * @return the width
 */
public int getWidth() {
	return width;
}
/**
 * @param width the width to set
 */
public void setWidth(int width) {
	this.width = width;
}
/**
 * @return the yVelocity
 */
public int getyVelocity() {
	return yVelocity;
}
/**
 * @param yVelocity the yVelocity to set
 */
public void setyVelocity(int yVelocity) {
	this.yVelocity = yVelocity;
}
/**
 * @return the height
 */
public int getHeight() {
	return height;
}
/**
 * @param height the height to set
 */
public void setHeight(int height) {
	this.height = height;
}
/**
 * @return the yPosition
 */
public int getyPosition() {
	return yPosition;
}
/**
 * @param yPosition the yPosition to set
 */
public void setyPosition(int yPosition) {
	this.yPosition = yPosition;
}
/**
 * @return the xPosition
 */
public int getxPosition() {
	return xPosition;
}
/**
 * @param xPosition the xPosition to set
 */
public void setxPosition(int xPosition) {
	this.xPosition = xPosition;
}




}
