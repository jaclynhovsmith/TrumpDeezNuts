package gamesrc;

import java.awt.Color;
import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GMessage;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.Context;
import jgame.listener.FrameListener;

public class InfoArea extends GContainer {
	
	//private int trumpHealth;
	
	public GMessage healthText;
	
		public InfoArea() {
			setSize(150, 570);
			this.setBackgroundColor(Color.black);
			
			BufferedImage bg = ImageCache.forClass(TowerGame.class).get("infoarea.png");
			GSprite gs = new GSprite(bg);
			this.setBackgroundSprite(gs);

			healthText = new GMessage();
			healthText.setX(this.getWidth()- 50);
			healthText.setAlignmentY(0.5);
			

			
			this.addListener(new FrameListener() {
				
				@Override
				public void invoke(GObject target, Context context) {
					healthText.setText("Trump Health: " + getHealth());
				}
			});
			this.add(healthText);
		}
		
		private String getHealth() {
			try{
			return this.getParent().getFirstAncestorOf(l1PlayArea.class).getFirstAncestorOf(Enemy.class).getHealth() + "";
			} catch(Exception e){
				e.printStackTrace();
				return "null";
			}
		}
		
		public void mySetParent(GObject object) {
			this.setParent(object);
		}
		
		public void printParent(){
			System.out.println(this.getParent().toString());
		}
}
