package npressello.com.github.newton;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Universe {
	
	private GameScreen gameScreen;
	private Galaxy galaxy;
	private Ship player;
	private UniverseController controller;
	
	public Universe(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		player = new Ship(new Color(1f, 1f, 1f, 1f), "scorp", new Vector2(1700, 0), 
				new Vector2(0, 0), 0.001f);
		galaxy = new Galaxy(1);
		galaxy.setSystem(new SolarSystem(10));
		
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(1f, 0.3f, 0.4f, 1f), "Sun", 
				new Vector2(0, 0), new Vector2(0, 0), 100000000.99f, 300, true));
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(1f, 0.3f, 1f, 1f), "Mercury", 
				new Vector2(1000, 0), new Vector2(0, 200), 30.30f, 20, false));
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(0, 0.3f, 0.4f, 1f), "Venus", 
				new Vector2(1300, 0), new Vector2(0, 180), 400.87f, 60, false));
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(0.6f, 0.8f, 0.7f, 1f), "Earth", 
				new Vector2(1600, 0), new Vector2(0, 160), 500.97f, 60, false));
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(0.8f, 0.4f, 0.4f, 1f), "Mars", 
				new Vector2(2000, 0), new Vector2(0, 143), 60.42f, 30, false));		
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(0.7f, 0.5f, 0.3f, 1f), "Jupiter", 
				new Vector2(2500,0), new Vector2(0, 125), 100000.89f, 60, false));
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(0.3f, 0.5f, 0.7f, 1f), "Saturn", 
				new Vector2(3000, 0), new Vector2(0, 113), 50000.68f, 59, false));
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(0.7f, 0.8f, 1f, 1f), "Uranus", 
				new Vector2(3500, 0), new Vector2(0, 103), 8000.68f, 20, false));
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(0.8f, 0.7f, 1f, 1f), "Neptune", 
				new Vector2(4000, 0), new Vector2(0, 97), 10000.02f, 20, false));
		galaxy.getSystems()[0].setPlanet(new Planet(new Color(1f, 0.5f, 1f, 1f), "Pluto", 
				new Vector2(4500, 0), new Vector2(0, 93), 1.27f, 10, false));
	}
	
	public void update(float delta) {
		if (controller.isPressed(2)) { // left
			player.addDirection(1f);
		} else if (controller.isPressed(3)){ // right
			player.addDirection(-1f);
		}
		if (controller.isPressed(0)) { // up
			player.changeVelocity(1);
		} else if (controller.isPressed(1)){ // down
			player.changeVelocity(-1);
		}
		player.update(delta);
		for (Planet planet: galaxy.getSystems()[0].getPlanets()) {
			Vector2 netForce = Physics.calcNetForce(planet, galaxy.getSystems()[0].getPlanets());
			Vector2 accel = Physics.calcAccel(planet, netForce);
			Vector2 vel = Physics.newVel(delta, planet, accel);
			planet.setVelocity(vel);
			planet.update(delta);
		}
	}
	
	public Ship getPlayer() {
		return player;
	}
	
	public Galaxy getGalaxy() {
		return galaxy;
	}

	public void setController(UniverseController controller) {
		this.controller = controller;		
	}
}
