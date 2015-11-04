package npressello.com.github.newton;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Ship {
	private String name;
	private float mass;
	private Vector2 position;
	private Vector2 velocity;
	private float direction;
	private float vel;
	private Color color;
	private Polygon shape;
	
	public Ship(Color color, String name, Vector2 position, Vector2 velocity, float mass) {
		this.color = color;
		this.name = name;
		this.position = position;
		this.velocity = velocity;
		this.mass = mass;
		float[] vertices = {5, -5, 0, 5, -5, -5};		
		shape = new Polygon(vertices);	
		shape.setPosition(position.x, position.y);
		System.out.println(shape.getRotation());
		vel = 0.5f;
	}
	
	public void update(float delta) {
		position.add(velocity.x * delta, velocity.y * delta);
		shape.setPosition(position.x, position.y);
	}
	
	public void addDirection(float angle) {
		direction += angle;
		direction %= 360;
		shape.setRotation(direction);
	}
	
	public Polygon getShape() {
		return shape;
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

	public void changeVelocity(int f) {
		this.velocity.x = this.velocity.x + (float) (f*vel * Math.cos(Math.toRadians((direction+90)%360)));
		this.velocity.y = this.velocity.y + (float) (f*vel * Math.sin(Math.toRadians((direction+90)%360)));
	}
	
	public float getRealVelocity() {
		return (float) Math.sqrt(velocity.x*velocity.x + velocity.y*velocity.y);
	}
}
