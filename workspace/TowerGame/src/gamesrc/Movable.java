package gamesrc;

import java.awt.image.BufferedImage;

import jgame.GAnimatable;
import jgame.ImageCache;

public abstract class Movable implements GAnimatable {

	int framecount = 0;
	
	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void nextFrame() {

	}

	@Override
	public void previousFrame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFrameNumber(int frameNumber)
			throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlaying(boolean playing) {
		// TODO Auto-generated method stub

	}

}
