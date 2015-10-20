package npressello.com.github.newton;

public class Universe {
	
	private GameScreen gameScreen;
	private Galaxy galaxy;
	
	public Universe(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		galaxy = new Galaxy(1);
		galaxy.setSystem(new SolarSystem(11));
		
		galaxy.getSystems()[0].setPlanet(new Planet("Sun", new Vector2d(0, 0), 
				new Vector2d(0, 0), (float) 100000000.99, 300));
		galaxy.getSystems()[0].setPlanet(new Planet("Mercury", new Vector2d(1000, 0), 
				new Vector2d(0, 170), (float) 30.30, 20));
		galaxy.getSystems()[0].setPlanet(new Planet("Venus", new Vector2d(1300, 0), 
				new Vector2d(0, 126), (float) 400.87, 60));
		galaxy.getSystems()[0].setPlanet(new Planet("Earth", new Vector2d(1600, 0), 
				new Vector2d(0, 107), (float) 500.97, 60));
		galaxy.getSystems()[0].setPlanet(new Planet("Moon", new Vector2d(1605,0), 
				new Vector2d(0, 108), (float) 7.34, 10));
		galaxy.getSystems()[0].setPlanet(new Planet("Mars", new Vector2d(2000, 0), 
				new Vector2d(0, 86), (float) 60.42, 30));		
		galaxy.getSystems()[0].setPlanet(new Planet("Jupiter", new Vector2d(2500,0), 
				new Vector2d(0, 47), (float) 100000.89, 60));
		galaxy.getSystems()[0].setPlanet(new Planet("Saturn", new Vector2d(3000, 0), 
				new Vector2d(0, 34), (float) 50000.68, 59));
		galaxy.getSystems()[0].setPlanet(new Planet("Uranus", new Vector2d(3500, 0), 
				new Vector2d(0, 24), (float) 8000.68, 20));
		galaxy.getSystems()[0].setPlanet(new Planet("Neptune", new Vector2d(4000, 0), 
				new Vector2d(0, 19), (float) 10000.02, 20));
		galaxy.getSystems()[0].setPlanet(new Planet("Pluto", new Vector2d(4500, 0), 
				new Vector2d(0, 17), (float) 1.27, 10));
	}
	
	public void update(float delta) {

		for (Planet planet: galaxy.getSystems()[0].getPlanets()) {
			Vector2d netForce = Physics.calcNetForce(planet, galaxy.getSystems()[0].getPlanets());
			Vector2d accel = Physics.calcAccel(planet, netForce);
			Vector2d vel = Physics.newVel(delta, planet, accel);
			planet.setVelocity(vel);
			planet.update(delta);
		}
	}
	
	public Galaxy getGalaxy() {
		return galaxy;
	}
}
