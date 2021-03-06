//TODO: YOU'RE AT 1:15 ON LESSON 5



package gamesrc;

import java.awt.Color;
import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;

public class MenuArea extends GContainer {
	public MenuArea() {
		
		setSize(1280, 150);
		this.setBackgroundColor(Color.black);
		
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("menuarea.png");
		GSprite gs = new GSprite(bg);
		this.setBackgroundSprite(gs);
		
		GSprite pic = null;
		
		for(int i = 0; i < 5; i++){
			pic = setPicture(i + 1);
			setTile(i, pic);

		}
	}

	private void setTile(int i, GSprite sprite) {
		Tile tile = new Tile(i);
		tile.setAnchorTopLeft();
		tile.setX((160*i) + 25);
		tile.setInnerText(i + "");
		//tile.setInnerSprite(sprite);
		add(tile);
	}
	
	private GSprite setPicture(int i){
		String ending = null;
		if(i <= 2)
			ending = "png";
		else {
			ending = "gif";
		}
		return new GSprite(ImageCache.forClass(TowerGame.class).get("buttons/kitty" + i + "." + ending));
	}
	
	public void mySetParent(GObject object) {
		this.setParent(object);
	}
}
