package application;

import javafx.scene.shape.Rectangle;

public class Block extends Rectangle
{
	int posX, posY, oldPosX, oldPosY;
	
	Block previous;
	
	public Block(int x, int y, Block p)
	{
		super(Main.block_size, Main.block_size);
		posX = x;
		posY = y;
	
		setTranslateX(posX * Main.block_size);
		setTranslateY(posY * Main.block_size);
	}
}
