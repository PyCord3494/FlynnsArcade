package application.controller;

import javafx.scene.shape.Rectangle;

/**
 * This class is used to keep track of a player's current position.
 * 
 * @author uys943
 */
public class MenuController extends Rectangle
{
	int posX, posY;
	
	/**
	 * Getter function to get the current x value of player.
	 * 
	 * @return int posX		current x position
	 */
	public int getPosX()
	{
		return posX;
	}
	
	/**
	 * Getter function to get the current y value of player.
	 * 
	 * @return int posY		current y position
	 */
	public int getPosY()
	{
		return posY;
	}
	
	
	/**
	 * Setter function to set the current x value of player.
	 * 
	 * @param posX 			sets new x position
	 */
	public void setPosX(int posX)
	{
		this.posX = posX;
	}
	

	/**
	 * Setter function to set the current y value of player.
	 * 
	 * @param posY 			sets new y position
	 */
	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	
	/**
	 * This function sets the player's current position to the given parameters.
	 * 
	 * @param x		player's x-coordinate
	 * @param y		player's y-coordinate
	 */
	public MenuController(int x, int y)
	{
		super(MainMenuController.block_size,MainMenuController.block_size);
		posX=x;
		posY=y;
		setTranslateX(posX * MainMenuController.block_size);
		setTranslateY(posY * MainMenuController.block_size);
	}
}
