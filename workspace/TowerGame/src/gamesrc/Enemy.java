package gamesrc;

import java.awt.image.BufferedImage;

import jgame.Context;
import jgame.GAnimatable;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;

public class Enemy extends GSprite implements GAnimatable {
	
	private int frameNumber = 0;
	private int health;
	private boolean playing = true;
	
	//TODO: ArrayList<BufferedImage> Constructor
	
	public Enemy(BufferedImage i) {
		super(i);
		health = 100;
//		addListener(new TrumpHitListener(Bullet.class) {
//			
//			@Override
//			public void invoke(GObject target, Context context) {
//				health -= 5;
//				System.out.println(health);
//				target.removeSelf();
//			}
//		});
	}
	
	
	@Override
	public boolean isPlaying() {
		return playing;
	}
	
	@Override
	public void nextFrame(){
		this.setImage(ImageCache.forClass(TowerGame.class).get("trumpanimation/t" + frameNumber + ".png"));
		frameNumber++;
		if(frameNumber == 24){
			setFrameNumber(0);
		}
	}
	
	@Override
	public void previousFrame() {
		//Not needed (maybe)
	}
	
	@Override
	public void setFrameNumber(int frameNumber){
		this.frameNumber = frameNumber;
	}
	
	@Override
	public void setPlaying(boolean playing){
		this.playing = playing;
	}
	
	public void takeDamage(int damage){
		health = health-damage;
		System.out.println(health);
		if(health <= -1){
			this.removeSelf();
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public boolean isDead() {
		if(health <= 0)
			return true;
		return false;
	}
	
	
}
