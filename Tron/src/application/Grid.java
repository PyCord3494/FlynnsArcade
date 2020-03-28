package application;

import javafx.scene.paint.Color;
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
	
	public Grid(int width, int height)
	{
		w = width;
		h = height;
		
		setMinSize(w * Main.block_size, h * Main.block_size);
		setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(5))));
	}
}