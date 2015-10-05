package gamesrc;

import java.awt.Image;
import java.awt.image.BufferedImage;

import jgame.ImageCache;

public class TurretFive extends Turret {
	int bulletSpacing = 5;
	public TurretFive(BufferedImage i, int bs) {
		super(i, bs, 100);
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.forClass(TowerGame.class).get("bullets/b5.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 50;
	}
}
