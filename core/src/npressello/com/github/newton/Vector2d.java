package npressello.com.github.newton;

public class Vector2d {

	public double x;
	public double y;
	
	public Vector2d(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2d add(Vector2d v) {
		this.x += v.x;
		this.y += v.y;
		return new Vector2d(this.x,this.y);
	}
	
	public Vector2d add(double x, double y) {
		this.x += x;
		this.y += y;
		return new Vector2d(this.x,this.y);
	}
	
	public double dst(Vector2d v) {
		double diffx = v.x - this.x;
		double diffy = v.y - this.y;
		return Math.sqrt(diffx*diffx + diffy*diffy);		
	}
	
}
