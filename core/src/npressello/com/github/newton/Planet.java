package npressello.com.github.newton;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Planet {
	
	private String name;
	private float mass;
	private float radius;
	private Vector2 position;
	private Vector2 velocity;
	private Color color;
	private OrbitBuilder orbit;
	private Vector2 initialPos;
	private Vector2 initialVel;
	private boolean setInitial = false;
	private boolean fixedPos;

	public Planet(Color color, String name, Vector2 pos, Vector2 vel, float mass, float radius, boolean fixed) {
		this.color = color;
		this.name = name;
		this.position = pos;
		this.velocity = vel;
		initialPos = new Vector2();
		initialVel = new Vector2();
		this.initialPos.x = pos.x;
		this.initialPos.y = pos.y;
		this.initialVel.x = vel.x;
		this.initialVel.y = vel.y;
		this.mass = mass;
		this.radius = radius;
		orbit = new OrbitBuilder(this);
		fixedPos = fixed;
	}

	public void update(float delta) {
		if (!fixedPos) {
			if (!setInitial)
				position = position.add(velocity.x * delta, velocity.y * delta);
			else {
				setInitial = false;
				position.x = initialPos.x;
				position.y = initialPos.y;
				velocity.x = initialVel.x;
				velocity.y = initialVel.y;
			}
			float angle = position.angle();
			if (angle > 359) setInitial = true;
			orbit.setPoint((int)angle);
		}
	}
	
	public float[] getOrbitPoints() {
		return orbit.getPoints();
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 vel) {
		this.velocity = vel;
	}
}
