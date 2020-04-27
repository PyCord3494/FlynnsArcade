package application;

import javafx.scene.shape.Rectangle;

/**
 * 
 * @author uys943
 *
 */
public class MenuController extends Rectangle
{
	int posX, posY;
	
	/**
	 * Getters
	 * @return int posX		position x
	 */
	public int getPosX()
	{
		return posX;
	}
	
	/**
	 * Getters
	 * @return int posY		position y
	 */
	public int getPosY()
	{
		return posY;
	}
	
	
	/**
	 * Setters
	 * @param posX 			sets new x position
	 */
	public void setPosX(int posX)
	{
		this.posX = posX;
	}
	

	/**
	 * Setters
	 * @param posY			sets new y position
	 */
	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	
	/**
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
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
