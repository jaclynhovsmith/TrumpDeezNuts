package gamesrc;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import jgame.Context;
import jgame.GContainer;
import jgame.GMessage;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.FrameListener;
import jgame.listener.LocalClickListener;
import jgame.listener.TimerListener;
import jgame.controller.PolygonController;

public class l1PlayArea extends GContainer {
	
	private boolean debug = false;
	//private MovementTween testmt = null;
	public PMovementTween testmt = null;
	//public GMessage test = null;
	public Enemy number1 = null;
	//public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	int index;
	GMessage trumpHealth;
	
	public l1PlayArea() {
		setSize(1130, 570);
		this.setBackgroundColor(Color.black);
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("playarealevelone.jpg");
		GSprite gs = new GSprite(bg);
		this.setBackgroundSprite(gs);
		
		if(debug){
			LocalClickListener gcl = new LocalClickListener() {
				@Override
				public void invoke(GObject object, Context context) {
					System.out.println("x: " + context.getMouseRelative().x + " y: " + context.getMouseRelative().y);
				}
				
			};
			this.addListener(gcl);
		}
		
		int[] x = new int[] { 1155, 1130, 1105, 1078, 1052, 1025, 1001, 979, 958, 
				939, 921, 900, 878, 854, 829, 802, 781, 763, 751, 742, 735, 731, 
				727, 721, 705, 684, 661, 639, 616, 591, 566, 538, 510, 484, 458, 
				432, 413, 401, 391, 391, 391, 398, 406, 418, 437, 460, 484, 505, 
				518, 522, 522, 520, 511, 491, 470, 444, 418, 389, 364, 339, 312, 
				286, 260, 234, 213, 193, 181, 170, 161, 152, 143, 135, 125, 114, 
				100, 84, 66, 46, 25, -1, -20, -100 };
		int[] y = new int[] { 269, 275, 278, 278, 279, 279, 269, 256, 240, 
				222, 202, 187, 173, 163, 162, 169, 186, 207, 230, 256, 281, 306,
				333, 358, 380, 396, 407, 419, 429, 440, 449, 456, 459, 459, 459, 
				452, 435, 413, 389, 362, 335, 310, 285, 262, 244, 233, 223, 209, 
				187, 160, 134, 108, 84, 62, 48, 45, 45, 47, 43, 40, 40, 40, 40, 
				45, 59, 75, 97, 120, 145, 170, 197, 223, 246, 269, 291, 312, 333,
				349, 363, 377, 337, 337 };
		Polygon p = new Polygon(x, y, 82);
		PolygonController pc = new PolygonController(p);
		
		
		
/*		for(int i = 0; i < 10; i++) {
			enemies.add(new Enemy(ImageCache.forClass(TowerGame.class).get("trumpanimation/t0.png")));
			enemies.get(i).addController(pc);
		}

		index = 0;
		
		TimerListener tl = new TimerListener(120) {
			
			@Override
			public void invoke(GObject target, Context context){
				add(enemies.get(index));
				
			}
		};*/

		number1 = new Enemy(ImageCache.forClass(TowerGame.class).get("trumpanimation/t0.png"));
		number1.addController(pc);
		number1.setLocation(1300, this.getHeight()/2);
		this.add(number1);
		pc.setRotateToFollow(false);
		pc.setRotationOffset(180);
		trumpHealth = new GMessage();
		trumpHealth.setFontSize(50);
		trumpHealth.setLocation(1180, 100);
		FrameListener fl = new FrameListener() {
			
			@Override
			public void invoke(GObject target, Context context){
				try{
					trumpHealth.setText("" + context.getInstancesOfClass(Enemy.class).get(0).getHealth());
				} catch(Exception e) {
					trumpHealth.setText("You Won!");
				}
			}
		};
		this.addListener(fl);
		this.add(trumpHealth);


		
	}
	
	public void mySetParent(GObject object){
		if(this.getParent() == null)
			this.setParent(object);
	}
	


	
}
