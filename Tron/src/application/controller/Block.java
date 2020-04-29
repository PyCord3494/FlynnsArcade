package application.controller;

import javafx.scene.shape.Rectangle;

/**
 * Class for creating the player object's movement functionality.
 * 
 * @author gtp818 and yng451
 */
public class Block extends Rectangle
{
	
	static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3; // must be constants for switch to be used
	int posX, posY, oldPosX, oldPosY;
	
	Block previous;
	
	public int direction = UP;
	
	int maxX, maxY;
	/**
	 * Function to keep track of the player object's position and update it on screen.
	 * 
	 * @param x 	position x of the block being used
	 * @param y		position y of the block being used
	 * @param p		player object's current block
	 * @param g		grid implemented in the game
	 */
	public Block(int x, int y, Block p, Grid g)
	{
		super(MainMenuController.block_size, MainMenuController.block_size);
		posX = x;
		posY = y;
	
		setTranslateX(posX * MainMenuController.block_size);
		setTranslateY(posY * MainMenuController.block_size);
		previous = p;
		
		maxX = g.getW();
		maxY = g.getH();
	}
	
	/**
	 * Function to move the player in the direction of the key pressed.
	 * The player's current position is also updated at the end.
	 */
	public void movement()
	{
		oldPosX = posX;
		oldPosY = posY;
		if(previous == null) // this is the head block
		{
			switch(direction)
			{
				case UP: moveUp();
					break;
				case RIGHT: moveRight();
					break;
				case DOWN: moveDown();
					break;
				case LEFT: moveLeft();
					break;
			}
		}	
		else
		{
			posX = previous.oldPosX;
			posY = previous.oldPosY;
		}
		updatePos();
	}
	
	/**
	 * Function to move the user up, if key is pressed, and checks to see if they're touching an edge.
	 */
	public void moveUp()
	{
		posY--;
		if(posY < 0)
		{
			posY = 0;
		}
	}
	
	/**
	 * Function to move the user right, if key is pressed, and checks to see if they're touching an edge.
	 */
	public void moveRight()
	{
		posX++;
		if(posX >= maxX)
		{
			posX = maxX;
		}
	}
	/**
	 * Function to move the user down, if key is pressed, and checks to see if they're touching an edge.
	 */
	public void moveDown()
	{
		posY++;
		if(posY >= maxY)
		{
			posY = maxY;
		}
	}
	/**
	 * Function to move the user left, if key is pressed, and checks to see if they're touching an edge.
	 */
	public void moveLeft()
	{
		posX--;
		if(posX < 0)
		{
			posX = 0;
		}
	}

	/**
	 * Updates the new position of the block to the controller.
	 */
	public void updatePos()
	{
		//System.out.println(posX + " / " + posY);
		setTranslateX(posX * MainMenuController.block_size);
		setTranslateY(posY * MainMenuController.block_size);
	}
}
