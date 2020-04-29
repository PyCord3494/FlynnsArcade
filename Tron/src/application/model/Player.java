package application.model;

import java.util.ArrayList;
import application.controller.Block;
import application.controller.Grid;
import javafx.scene.paint.Color;

/**
 * This class contains all data for player 1's character. It includes the player's
 * starting position, current direction, and sets their new direction.
 * 
 * @author yng451
 */
public class Player
{
	public ArrayList<Block> blocks1 = new ArrayList<Block>();
	ArrayList<Block> blocks2 = new ArrayList<Block>();

	public Block head;
	public Block tail;
	public String name;
	
	/**
	 * This function sets the player's starting position and creates
	 * the blocks for the character on screen as they move. 
	 * 
	 * @param initialLength 	the initial length of the player
	 * @param g 				the grid implemented to display the game
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
		
		Block b;
		for (int i = 1; i < initialLength; i++)
		{
			b = new Block(initialPosX + i, initialPosY, tail, g);
			blocks1.add(b);
			blocks2.add(b);
			tail = b;
		}
	}
	
    /**
	 * Getter function to get the current direction of the player.
	 * 
	 * @return head.direction		the location of the head
	 */
	public int getDirection()
	{
		return head.direction;
	}
	
	/**
	 * Setter function to set the current direction of the player.
	 * 
	 * @param int d			sets the player's direction to given direction
	 */
	public void setDirection(int d)
	{
		head.direction = d;
	}
}