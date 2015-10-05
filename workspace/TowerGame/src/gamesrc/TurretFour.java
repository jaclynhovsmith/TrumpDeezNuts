package gamesrc;

import java.awt.Image;
import java.awt.image.BufferedImage;

import jgame.ImageCache;

public class TurretFour extends Turret {
	int bulletSpacing = 30;
	public TurretFour(BufferedImage i, int bs) {
		super(i, bs, 200);
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.forClass(TowerGame.class).get("bullets/b4.gif"));
	}

	@Override
	public double getBulletSpeed() {
		return 50;
	}
}