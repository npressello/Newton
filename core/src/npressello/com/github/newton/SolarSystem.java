package npressello.com.github.newton;

public class SolarSystem {
	
	private Planet[] planet;
	private int cont = 0;
	
	public SolarSystem(int numPlanets) {
		planet = new Planet[numPlanets];
	}
	
	public void setPlanet(Planet p) {
		planet[cont++] = p;
	}
	
	public Planet[] getPlanets() {
		return planet;
	}

}
