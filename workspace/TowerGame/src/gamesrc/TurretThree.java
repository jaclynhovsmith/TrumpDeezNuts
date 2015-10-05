package gamesrc;

import java.awt.Image;
import java.awt.image.BufferedImage;

import jgame.ImageCache;

public class TurretThree extends Turret {
	int bulletSpacing = 25;
	public TurretThree(BufferedImage i, int bs) {
		super(i, bs, 100);
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.forClass(TowerGame.class).get("bullets/b3.gif"));
	}

	@Override
	public double getBulletSpeed() {
		return 50;
	}
}