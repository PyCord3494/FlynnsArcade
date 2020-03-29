package application;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Player
{
	ArrayList<Block> blocks1 = new ArrayList<Block>();
	ArrayList<Block> blocks2 = new ArrayList<Block>();

	Block head;
	Block tail;
	
	public Player(int initialLength, Grid g)
	{
		int initialPosX = g.getW()/4;
		int initialPosY = g.getH()/2;
		
		head = new Block(initialPosX, initialPosY, null, g);
		
		blocks1.add(head);
		blocks2.add(head);

		head.setFill(Color.RED.desaturate());
		
		tail = head;
		
		//Block previous = head;
		Block b;
		for (int i = 1; i < initialLength; i++)
		{
			b = new Block(initialPosX + i, initialPosY, tail, g);
			blocks1.add(b);
			blocks2.add(b);
			tail = b;
		}
//		for(int i = 1; i < initialLength; i++)
//		{
//			Block b = new Block(initialPosX + i, initialPosY, previous, g);
//			blocks.add(b);
//			previous = b;
//		}
	}
	
	public int getDirection()
	{
		return head.direction;
	}
	
	public void setDirection(int d)
	{
		head.direction = d;
	}
}