package gamesrc;

import java.awt.Image;
import java.util.List;

import jgame.GMessage;
import jgame.GObject;
import jgame.GSprite;
import jgame.Context;
import jgame.controller.ConstantMovementController;
import jgame.listener.FrameListener;
import jgame.listener.TimerListener;

public abstract class Turret extends GSprite {
	

	public int bulletSpacing;
	public int radius;
	public boolean gamestate = false;
	
	private double leastDistance;
	private int frames = 0;
	
	public Turret(Image image, int bs, int rad) {
		super(image);
		radius = rad;
		bulletSpacing = bs;
		this.addListener(new FrameListener() {
			//TODO: DO THIS
			@Override
			public void invoke(GObject target, Context context) {
				try{
					if(context.getInstancesOfClass(Enemy.class) != null){
						List<Enemy> enemies = context.getInstancesOfClass(Enemy.class);
						//System.out.println(enemies.size());
						if(enemies.size() != 0){
							leastDistance = Math.sqrt((enemies.get(0).getX()-target.getX())+(enemies.get(0).getY()-target.getY()));
							//System.out.println(leastDistance);
							GObject targetedObject = enemies.get(0);
							/*for(GMessage e : enemies){
								System.out.println("setup for loop");
								//TODO: Find closest enemy
								//TODO: getDistance to ^
								double tempDistance = Math.sqrt((e.getX()-target.getX())+e.getY()-target.getY());
								System.out.println(tempDistance);
								if(tempDistance <= leastDistance){
									leastDistance = tempDistance;
									System.out.println("Found least dist");
									targetedObject = e;
								}
			
							}*/
							target.face(targetedObject);
							target.setRotation(target.angleTo(targetedObject));
							frames++;
						}
					}
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		this.addListener(new TimerListener(bulletSpacing) {
			
			public void invoke(GObject target, Context context){
				if(leastDistance <= radius)
					//System.out.println(radius + "  " + leastDistance);
					if(context.getInstancesOfClass(Enemy.class) != null)
						fireBullet();
			}
		});
	}
	
	public abstract Bullet createBullet();
	public abstract double getBulletSpeed();
	
	public void fireBullet() {
		final Bullet b = createBullet();
		b.setRotation(this.getRotation());
		final ConstantMovementController c = ConstantMovementController.createPolar(getBulletSpeed(), getRotation());
		b.addController(c);
		snapAnchor(b);
		b.moveAtAngle(getWidth() / 2 + 20, getRotation());
		this.addSibling(b);
	}
	
	public void setGameOver(boolean gamestate){
		this.gamestate = gamestate;
	}

}
