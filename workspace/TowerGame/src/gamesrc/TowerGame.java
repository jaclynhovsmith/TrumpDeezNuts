package gamesrc;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;
import jgame.SoundManager;

public class TowerGame extends Game {

	public static void main(String[] args) {
		ImageCache.create(TowerGame.class, "/rsc/tgimages/");
		SoundManager.create(TowerGame.class, "/TowerGame/src/rsc/tgsounds/");	
		TowerGame tg = new TowerGame();
		tg.startGame();
	}
	
	public TowerGame() {
		//Needs Root Container
		GRootContainer root = new GRootContainer(Color.BLUE);
		setRootContainer(root);
		//TGMenuView tgmv = new TGMenuView();
		//root.addView(Views.MAIN_MENU, tgmv);		
		TGLevelOneView tgl1v = new TGLevelOneView();
		root.addView(Views.LEVEL_ONE, tgl1v);
	}
	
	public enum Views {
		MAIN_MENU, LEVEL_ONE, INSTRUCTIONS;
	}

}
