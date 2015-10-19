package npressello.com.github.newton;

public class Galaxy {
	
	private SolarSystem[] system;
	private int cont = 0;
	
	public Galaxy(int numSystem) {
		system = new SolarSystem[numSystem];
	}
	
	public void setSystem(SolarSystem s) {
		system[cont++] = s;
	}
	
	public SolarSystem[] getSystems() {
		return system;
	}

}
