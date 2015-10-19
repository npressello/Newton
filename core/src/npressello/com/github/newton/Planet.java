package npressello.com.github.newton;

public class Planet {
	
	private String name;
	private double mass;
	private double radius;
	private Vector2d position;
	private Vector2d velocity;

	public Planet(String name, Vector2d pos, Vector2d vel, double mass, double radius) {
		this.name = name;
		this.position = pos;
		this.velocity = vel;
		this.mass = mass;
		this.radius = radius;
	}

	public void update(float delta) {
		position = position.add(velocity.x * delta, velocity.y * delta);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Vector2d getPosition() {
		return position;
	}

	public void setPosition(Vector2d position) {
		this.position = position;
	}

	public Vector2d getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2d vel) {
		this.velocity = vel;
	}
}
