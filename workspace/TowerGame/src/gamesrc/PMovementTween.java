package gamesrc;

import java.awt.geom.Point2D;

import jgame.controller.Interpolation;
import jgame.controller.MovementTween;

public class PMovementTween extends MovementTween {
	
	public double x1;
	public double y1;
	public double x2;
	public double y2;
	
	private Point2D endpoint = null;
	
	public PMovementTween(int duration, Interpolation interpolationType, double x1, double y1, double x2, double y2) {
		super(duration, interpolationType, x1, y1, x2 - x1, y2 - y1);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.setEndpoint(this.x2, this.y2);
	}
	
	public void setEndpoint(double x2, double y2){
		endpoint = null;
		endpoint = new Point2D.Double(x2, y2);
	}
	
	public Point2D getEndpoint(){
		//System.out.println("x::: " + endpoint.getX() + " y::: " + endpoint.getY());
		return endpoint;
	}
	
	public void addLink(int duration, int x2, int y2) {
		this.chain(new PMovementTween(duration, Interpolation.LINEAR, this.getEndpoint().getX(), this.getEndpoint().getY(), x2, y2));
		this.setEndpoint(x2, y2);
	}

	
	
}
