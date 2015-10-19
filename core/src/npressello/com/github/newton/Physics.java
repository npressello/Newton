package npressello.com.github.newton;

public class Physics {
	
	private static final double G = 6.67e-11;
	
	public static Vector2d calcNetForce(Planet planet, Planet[] others) {
		Vector2d netForce = new Vector2d(0,0);
		double x = planet.getPosition().x;
		double y = planet.getPosition().y;
		for (Planet p: others) {
			if (!planet.getName().equalsIgnoreCase(p.getName())) {
				double xDiff = p.getPosition().x - x;
				double yDiff = p.getPosition().y - y;
				double r = planet.getPosition().dst(p.getPosition());
				if (p.getName().equals("Earth") && planet.getName().equals("Moon")) {
					System.out.println(r);
				}
				double F = calcForce(planet, p, r*r);
				double Fx = calcFcoord(F, xDiff, r);
				double Fy = calcFcoord(F, yDiff, r);
				netForce = netForce.add(Fx, Fy);
			}			
		}
		return netForce;
	}
	
	public static Vector2d calcAccel(Planet p, Vector2d netForce) {
		double ax = netForce.x / p.getMass();
		double ay = netForce.y / p.getMass();
		Vector2d accel = new Vector2d(ax,ay);
		return accel;
	}
	
	public static Vector2d newVel(float delta, Planet p, Vector2d a) {
		double vx = p.getVelocity().x + a.x * delta;
		double vy = p.getVelocity().y + a.y * delta;
		Vector2d vel = new Vector2d(vx, vy);
		return vel;
	}
	
	public static double calcForce(Planet planet, Planet p, double squareDist) {
		return (G * planet.getMass() * p.getMass()) / squareDist;
	}
	
	public static double calcFcoord(double F, double xDiff, double dist) {
		return F * xDiff / dist;
	}

	
//	float x0 = earth.getPosition().x;
//	float y0 = earth.getPosition().y;
//	float x = moon.getPosition().x;
//	float y = moon.getPosition().y;
//	float distance = (float) Math.sqrt(((x0-x)*(x0-x)) + ((y0-y)*(y0-y)));
//	Vector2 moonToEarth = new Vector2(x0-x, y0-y);
//	moonToEarth.scl(1/distance);		
//	float force = (G * earth.getMass()) / distance;
//	moonToEarth.scl(force);
//	moon.addGravity(moonToEarth);
}
