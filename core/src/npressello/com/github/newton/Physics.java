package npressello.com.github.newton;

import com.badlogic.gdx.math.Vector2;

public class Physics {
	
	private static final float G = 0.367f;
	
	public static Vector2 calcNetForce(Planet planet, Planet[] others) {
		Vector2 netForce = new Vector2(0,0);
		float x = planet.getPosition().x;
		float y = planet.getPosition().y;
		for (Planet p: others) {
			if (!planet.getName().equalsIgnoreCase(p.getName())) {
				float xDiff = p.getPosition().x - x;
				float yDiff = p.getPosition().y - y;
				float r = planet.getPosition().dst(p.getPosition());
				float F = calcForce(planet, p, r*r);
				float Fx = calcFcoord(F, xDiff, r);
				float Fy = calcFcoord(F, yDiff, r);
				netForce = netForce.add(Fx, Fy);
			}			
		}
		return netForce;
	}
	
	public static Vector2 calcAccel(Planet p, Vector2 netForce) {
		float ax = netForce.x / p.getMass();
		float ay = netForce.y / p.getMass();
		Vector2 accel = new Vector2(ax,ay);
		return accel;
	}
	
	public static Vector2 newVel(float delta, Planet p, Vector2 a) {
		float vx = p.getVelocity().x + a.x * delta;
		float vy = p.getVelocity().y + a.y * delta;
		Vector2 vel = new Vector2(vx, vy);
		return vel;
	}
	
	public static float calcForce(Planet planet, Planet p, float squareDist) {
		return (G * planet.getMass() * p.getMass()) / squareDist;
	}
	
	public static float calcFcoord(float F, float xDiff, float dist) {
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
