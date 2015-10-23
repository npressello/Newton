package npressello.com.github.newton;

public class OrbitBuilder {
	private float[] positions;	
	private Planet planet;
	private int lastPoint;
	
	public OrbitBuilder(Planet p) {
		positions = new float[720];
		for (int i = 0; i < 360; i++) {
			positions[2*i] = p.getPosition().x;
			positions[2*i+1] = p.getPosition().y;
		}
		planet = p;
		lastPoint = -1;
	}
	
	public void setPoint(int angle) {
		if (lastPoint != angle) {
			positions[2*angle] = planet.getPosition().x;
			positions[2*angle+1] = planet.getPosition().y;
			lastPoint = angle;
		}		
	}
	
	public float[] getPoints() {
		return positions;
	}
}
