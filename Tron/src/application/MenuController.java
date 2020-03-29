package application;

import javafx.scene.shape.Rectangle;

public class MenuController extends Rectangle
{
	int posX, posY;
	
	public int getPosX()
	{
		return posX;
	}
	
	public void setPosX(int posX)
	{
		this.posX = posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	
	public MenuController(int x, int y)
	{
		super(Main.block_size,Main.block_size);
		posX=x;
		posY=y;
		setTranslateX(posX * Main.block_size);
		setTranslateY(posY * Main.block_size);
	}
}
