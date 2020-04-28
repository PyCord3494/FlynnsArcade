package application;

import javafx.scene.shape.Rectangle;
/***
 * 
 * @author gtp818 and yng451
 *
 */
public class Block extends Rectangle
{
	
	static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3; // must be constants for switch to be used
	int posX, posY, oldPosX, oldPosY;
	
	Block previous;
	
	int direction = UP;
	
	int maxX, maxY;
	/**
	 * 
	 * @param x position x of the block being used
	 * @param y	position y of block being used
	 * @param p	Block is the object of player 1 or player2
	 * @param g	grid implemented in the game.
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
	 * This function moves the player in whatever direction they pressed. Updates their current position at the end
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
	 * moves the user up if key is pressed and checks to see if its touching an edge
	 */
	public void moveUp()
	{
		posY--;
		if(posY < 0) // Check color of position to see if it is on the edge of the map to end
		{
			posY = 0;
			//return;
		}
	}
	/**
	 * moves the user right and checks to see if theyre touching an edge
	 */
	public void moveRight()
	{
		posX++;
		if(posX >= maxX)
		{
			posX = maxX;
			
			//return;
		}
	}
	/**
	 * moves the user down and checks to see if theyre touching an edge
	 */
	public void moveDown()
	{
		posY++;
		if(posY >= maxY)
		{
			posY = maxY;
			//return;
		}
	}
	/**
	 * moves the user right and checks the edge
	 */
	public void moveLeft()
	{
		posX--;
		if(posX < 0)
		{
			posX = 0;
			//return;
		}
	}
	/*
	 * sends the new position of the block to the controller once again.
	 */
	public void updatePos()
	{
		//System.out.println(posX + " / " + posY);
		setTranslateX(posX * MainMenuController.block_size);
		setTranslateY(posY * MainMenuController.block_size);
	}
}
