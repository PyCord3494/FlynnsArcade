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

public class Grid extends Pane
{
	private int w,h;
	ArrayList<Block> blocks1 = new ArrayList<Block>();
	ArrayList<Block> blocks2 = new ArrayList<Block>();
	Player p1;
	Player2 p2;
	
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
	
	public void update()
	{
		for(Block b:blocks1)
		{
			b.movement();
		}
		addOne();
	}
	
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
				if(b.posX == getW() - 1 || b.posY == getH() - 1)
				{
					return true;
				}
				if(b.posX < 0 || b.posY < 0)
				{
					return true;
				}
			}
		}
		return false;
	}
	
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
				if(b.posX == getW() - 1 || b.posY == getH() - 1)
				{
					return true;
				}
				if(b.posX < 0 || b.posY < 0)
				{
					return true;
				}
			}
		}
		return false;
	}
	
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
	
	private void addBlock(Block one)
	{
		getChildren().add(one);
		blocks1.add(one);
		blocks2.add(one);
	}
	
	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public Grid(int width, int height)
	{
		w = width;
		h = height;
		
		setMinSize(w * Main.block_size, h * Main.block_size);
		setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
	}
}