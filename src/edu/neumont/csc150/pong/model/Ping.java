package edu.neumont.csc150.pong.model;
/**
 * Class that holds properties of the Ball
 * @author Gabe B
 *
 */
public class Ping {
int width;
int height;
int xVelocity;
int yVelocity;
int xPosition;
int yPosition;
/**
 * Constructor for the Ball
 * @param width
 * @param height
 * @param xVelocity
 * @param yVelocity
 * @param xPosition
 * @param yPosition
 */
public Ping(int width, int height, int xVelocity, int yVelocity, int xPosition, int yPosition) {
	this.width = width;
	this.height = height;
	this.xVelocity = xVelocity;
	this.yVelocity = yVelocity;
	this.xPosition = xPosition;
	this.yPosition = yPosition;
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
 * @return the xVelocity
 */
public int getxVelocity() {
	return xVelocity;
}
/**
 * @param xVelocity the xVelocity to set
 */
public void setxVelocity(int xVelocity) {
	this.xVelocity = xVelocity;
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
}
