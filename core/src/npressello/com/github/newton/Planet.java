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

	public Planet(Color color, String name, Vector2 pos, Vector2 vel, float mass, float radius) {
		this.color = color;
		this.name = name;
		this.position = pos;
		this.velocity = vel;
		this.mass = mass;
		this.radius = radius;
		orbit = new OrbitBuilder(this);
	}

	public void update(float delta) {
		position = position.add(velocity.x * delta, velocity.y * delta);
		orbit.setPoint((int)position.angle());
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
