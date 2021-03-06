package gamesrc;

import java.awt.Image;
import java.awt.image.BufferedImage;

import jgame.ImageCache;

public class TurretOne extends Turret {
	public TurretOne(Image image, int bulletSpacing) {
		super(image, bulletSpacing, 100);
		radius = 50;
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.forClass(TowerGame.class).get("bullets/b1.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 50;
	}
	
	
}
