package gamesrc;

import jgame.Context;
import jgame.GButton;
import jgame.GMessage;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.ButtonState;
import jgame.listener.ButtonListener;

public class Tile extends GButton {
	
	private GSprite innerSprite = null;
	private final int TILE_SIZE = 150;
	
	public Tile(final int turretNumber) {
		setSize(TILE_SIZE, TILE_SIZE);
		
		GSprite sNone = new GSprite(ImageCache.forClass(TowerGame.class).get("buttons/tilenone.png"));
		GSprite sHover = new GSprite(ImageCache.forClass(TowerGame.class).get("buttons/tilehover.png"));
		GSprite sPressed = new GSprite(ImageCache.forClass(TowerGame.class).get("buttons/tilepressed.png"));

		setStateSprite(ButtonState.NONE, sNone);
		setStateSprite(ButtonState.HOVERED, sHover);
		setStateSprite(ButtonState.PRESSED, sPressed);
		
		addListener(new ButtonListener() {
			
			@Override
			public void mouseClicked(Context context) {
				getFirstAncestorOf(TGLevelOneView.class).initializeTurret(turretNumber);
			}
		});
		

	}
	
	public void setInnerSprite(GSprite inner){
		this.innerSprite = inner;
		if(innerSprite != null) {
			System.out.println("Ran!");
			innerSprite.setAnchorTopLeft();
			innerSprite.setX(25);
			innerSprite.setY(25);
			this.add(innerSprite);
		}
	}

	public void setInnerText(String s) {
		Integer i = null;
		String bigNum = null;
		try {
			i = Integer.parseInt(s);
			i++;
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		if(i != null) {
			bigNum = i + "";
		} else {
			bigNum = s;
		}
		GMessage message = new GMessage();
		message.setText(bigNum);
		message.setAnchorCenter();
		//message.setLocation(35, 25);
		message.setFontSize(100);
		this.addAtCenter(message);
	}
}
