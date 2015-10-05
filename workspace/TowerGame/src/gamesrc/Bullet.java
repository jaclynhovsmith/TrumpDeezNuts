package gamesrc;

import java.awt.image.BufferedImage;

import jgame.GObject;
import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;
import jgame.Context;

public class Bullet extends GSprite {
	
	public Bullet(BufferedImage image) {
		super(image);
		addListener(new BoundaryRemovalListener());
		addListener(new TrumpHitListener(Enemy.class) {
			
			@Override
			public void invoke(GObject target, Context context){
				target.removeSelf();
				context.getInstancesOfClass(Enemy.class).get(0).takeDamage(5);
			}
		});
	}

}
