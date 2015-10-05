package gamesrc;

import gamesrc.TowerGame.Views;
import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class TGMenuView extends GContainer{

	public TGMenuView(){
		setSize(900, 700);
		
		MenuBackground mbg = new MenuBackground();
		this.addAtCenter(mbg);
		
		GSprite none_img = new GSprite(ImageCache.forClass(TowerGame.class).get("buttons/playnone.png"));
		none_img.setScaleX(0.1);
		none_img.setScaleY(0.1);
		GSprite hover_img = new GSprite(ImageCache.forClass(TowerGame.class).get("buttons/playhover.png"));
		hover_img.setScaleX(0.1);
		hover_img.setScaleY(0.1);
		GSprite pressed_img = new GSprite(ImageCache.forClass(TowerGame.class).get("buttons/playpressed.png"));
		pressed_img.setScaleX(0.1);
		pressed_img.setScaleY(0.1);
		
		GButton play_btn = new GButton();
		
		play_btn.setStateSprite(ButtonState.NONE, none_img);
		play_btn.setStateSprite(ButtonState.HOVERED, hover_img);
		play_btn.setStateSprite(ButtonState.PRESSED, pressed_img);
		play_btn.setAnchorTopLeft();
		play_btn.setX(100);
		play_btn.setY(200);
		
		ButtonListener play_listener = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.LEVEL_ONE);
			}
		};
		
		play_btn.addListener(play_listener);
		
		this.add(play_btn);
		

	}
}
