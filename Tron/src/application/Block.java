package application;

import javafx.scene.shape.Rectangle;

public class Block extends Rectangle
{
	
	static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3; // must be constants for switch to be used
	int posX, posY, oldPosX, oldPosY;
	
	Block previous;
	
	int direction = UP;
	
	int maxX, maxY;
	
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
	
	public void moveUp()
	{
		posY--;
		if(posY < 0) // Check color of position to see if it is on the edge of the map to end
		{
			posY = 0;
			//return;
		}
	}
	
	public void moveRight()
	{
		posX++;
		if(posX >= maxX)
		{
			posX = maxX;
			
			//return;
		}
	}
	
	public void moveDown()
	{
		posY++;
		if(posY >= maxY)
		{
			posY = maxY;
			//return;
		}
	}
	
	public void moveLeft()
	{
		posX--;
		if(posX < 0)
		{
			posX = 0;
			//return;
		}
	}
	
	public void updatePos()
	{
		//System.out.println(posX + " / " + posY);
		setTranslateX(posX * MainMenuController.block_size);
		setTranslateY(posY * MainMenuController.block_size);
	}
}
