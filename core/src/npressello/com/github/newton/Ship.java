package npressello.com.github.newton;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Ship {
	private String name;
	private float mass;
	private Vector2 position;
	private Vector2 velocity;
	private float direction;
	private Color color;
	
	public Ship(Color color, String name, Vector2 position, Vector2 velocity, float mass) {
		this.color = color;
		this.name = name;
		this.position = position;
		this.velocity = velocity;
		this.mass = mass;
	}
	
	public void update(float delta, float angle) {
		position.add(velocity.x * delta, velocity.y * delta);
		direction += angle;
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

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getDirection() {
		return direction;
	}
	
	public void setDirection(float direction) {
		this.direction = direction;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
