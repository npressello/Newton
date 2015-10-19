package npressello.com.github.newton;

public class Universe {
	
	private GameScreen gameScreen;
	private Galaxy galaxy;
	
	public Universe(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		galaxy = new Galaxy(1);
		galaxy.setSystem(new SolarSystem(11));
		
		galaxy.getSystems()[0].setPlanet(new Planet("Sun", new Vector2d(0, 0), 
				new Vector2d(0, 0), (float) 1.99e27, 695000f));
		galaxy.getSystems()[0].setPlanet(new Planet("Mercury", new Vector2d(57900000, 0), 
				new Vector2d(0, 170640/2), (float) 3.30e20, 2440f));
		galaxy.getSystems()[0].setPlanet(new Planet("Venus", new Vector2d(108200000, 0), 
				new Vector2d(0, 126000/2), (float) 4.87e21, 6052f));
		galaxy.getSystems()[0].setPlanet(new Planet("Earth", new Vector2d(149600000, 0), 
				new Vector2d(0, 107280/2), (float) 5.97e21, 6378.137f));
		galaxy.getSystems()[0].setPlanet(new Planet("Moon", new Vector2d(149984000,0), 
				new Vector2d(0, 108300/2), (float) (7.34e19), 1738.14f));
		galaxy.getSystems()[0].setPlanet(new Planet("Mars", new Vector2d(227900000, 0), 
				new Vector2d(0, 86760/2), (float) 6.42e20, 3397f));		
		galaxy.getSystems()[0].setPlanet(new Planet("Jupiter", new Vector2d(778600000,0), 
				new Vector2d(0, 47160/2), (float) (1.89e24), 69911.14f));
		galaxy.getSystems()[0].setPlanet(new Planet("Saturn", new Vector2d(1433000000, 0), 
				new Vector2d(0, 34560/2), (float) 5.68e23, 60268f));
		galaxy.getSystems()[0].setPlanet(new Planet("Uranus", new Vector2d(2873000000f, 0), 
				new Vector2d(0, 24480/2), (float) 8.68e22, 25559f));
		galaxy.getSystems()[0].setPlanet(new Planet("Neptune", new Vector2d(4495000000f, 0), 
				new Vector2d(0, 19440/2), (float) 1.02e23, 24766f));
		galaxy.getSystems()[0].setPlanet(new Planet("Pluto", new Vector2d(5906000000f, 0), 
				new Vector2d(0, 17060/2), (float) 1.27e19, 1150f));
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
