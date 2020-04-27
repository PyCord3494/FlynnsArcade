package application;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;

/**
 * Grid is a java class used to represent the actuapl playing field for the Tron game. 
 * It focuses on adding the players to the game and drawing their movements.
 * @author gtp818
 */
public class Grid extends Pane
{
	private int w,h;
	ArrayList<Block> blocks1 = new ArrayList<Block>();
	ArrayList<Block> blocks2 = new ArrayList<Block>();
	Player p1;
	Player2 p2;
	MainMenuController player;
	
	/**
	 * Adds the two players into the game
	 * @param p1	Player object representing player1
	 * @param p2	Player2 object representing player2
	 */
	public void addPlayer(Player p1, Player2 p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		
		for(Block b:p1.blocks1)
		{
			addBlock(b);
		}
		
		for(Block b:p2.blocks2)
		{
			addBlock(b);
		}
	}
	
	/**
	 * Generates coordinates for player's movements
	 * and updates grid correspondingly
	 */
	public void update()
	{
		for(Block b:blocks1)
		{
			b.movement();
		}
		addOne();
	}
	
	/**
	 * Determines if p1 has lost
	 * @return Boolean representing if p1 loses
	 */
	public boolean gameOverP1()
	{
		for(Block b:blocks1)
		{
			if(b != p1.head)
			{
				if(b.posX == p1.head.posX && b.posY == p1.head.posY)
				{
					return true;
				}
				if(p1.head.posX == getW() - 2 || p1.head.posY == getH() - 2)	//south & east walls	
				{
					return true;
				}
				if(b.posX < 2 || b.posY < 2)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Determines if p2 has lost
	 * @return Boolean representing if p2 loses
	 */
	public boolean gameOverP2()
	{
		for(Block b:blocks2)
		{
			if(b != p2.head)
			{
				if(b.posX == p2.head.posX && b.posY == p2.head.posY)
				{
					return true;
				}
				if(p2.head.posX == getW() - 2 || p2.head.posY == getH() - 2)	//south walls 
				{
					return true;
				}
				if(b.posX < 2 || b.posY < 2)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Colors the new movement block, reassigns tail, and adds said block
	 */
	public void addOne()
	{
		Block b = new Block(p1.tail.oldPosX, p1.tail.oldPosY, p1.tail, this);
		Block b2 = new Block(p2.tail.oldPosX, p2.tail.oldPosY, p2.tail, this);
		
		b.setFill(Color.RED.desaturate());
		b2.setFill(Color.BLUE.desaturate());

		p1.tail = b;
		p2.tail = b2;
		addBlock(b);
		addBlock(b2);
	}
	
	/**
	 * Adds the block to the arraylist of blocks
	 * @param one	Block to add to the arraylist
	 */
	private void addBlock(Block one)
	{
		getChildren().add(one);
		blocks1.add(one);
		blocks2.add(one);
	}
	
	/**
	 * Grab grid's width
	 * @return int w	width of grid
	 */
	public int getW() {
		return w;
	}

	/**
	 * Grab grid's height
	 * @return int h	height of grid
	 */
	public int getH() {
		return h;
	}

	/**
	 * Constructor for Grid
	 * 
	 * @param width		Grid's width
	 * @param height	Grid's height
	 */
	public Grid(int width, int height)
	{
		
		player = new MainMenuController();
		w = 25;
		h = 25;
		//String p1Score = Integer.toString(player.player1Score);
		
		setMinSize(w * MainMenuController.block_size, h * MainMenuController.block_size);
		setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, new BorderWidths(10))));
		
	
	}
}