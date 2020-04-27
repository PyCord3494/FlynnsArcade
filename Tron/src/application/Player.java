package application;

import java.util.ArrayList;
import javafx.scene.paint.Color;
/**
 * 
 * @author kxm210
 *
 */
public class Player
{
	ArrayList<Block> blocks1 = new ArrayList<Block>();
	ArrayList<Block> blocks2 = new ArrayList<Block>();

	Block head;
	Block tail;
	public String name;
	/**
	  * 
	  * @param initialLength passed in is the initial Length of the player
	  * @param g is a grid object used in the length of player 2
	  * This function elongates the player every second of the game making them longer and longer
	  */
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
	/***
	 * 
	 * @return the location of the head
	 */
	public int getDirection()
	{
		return head.direction;
	}
	/**
	 * 
	 * @param sets the direction from the block being passed in, the block is the player
	 */
	public void setDirection(int d)
	{
		head.direction = d;
	}
	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return name;
	}
}