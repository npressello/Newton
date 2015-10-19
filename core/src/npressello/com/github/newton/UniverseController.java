package npressello.com.github.newton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class UniverseController implements InputProcessor{

	private GameScreen screen;
	private Universe universe;
	private int lastKey = 0;
	
	public UniverseController(GameScreen screen, Universe universe) {
		this.screen = screen;
		this.universe = universe;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		float xPos = 0;
		float yPos = 0;
		if (keycode == Input.Keys.NUM_0) {
			lastKey = 0;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[0].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[0].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_1) {
			lastKey = 1;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[1].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[1].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_2) {
			lastKey = 2;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[2].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[2].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_3) {
			lastKey = 3;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[3].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[3].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_4) {
			lastKey = 4;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[5].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[5].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_5) {
			lastKey = 5;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[6].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[6].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_6) {
			lastKey = 6;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[7].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[7].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_7) {
			lastKey = 7;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[8].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[8].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_8) {
			lastKey = 8;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[9].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[9].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_9) {
			lastKey = 9;
			xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[10].getPosition().x;
			yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[10].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.L) {
			if (lastKey > 3) lastKey++;
			//xPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[lastKey].getPosition().x;
			//yPos = (float) universe.getGalaxy().getSystems()[0].getPlanets()[lastKey].getPosition().y;
			String name = universe.getGalaxy().getSystems()[0].getPlanets()[lastKey].getName();
			//screen.setCamera(xPos, yPos, 0, 0);
			screen.lockCam(name);
		}
		if (keycode == Input.Keys.PLUS) {
			screen.setZoom(-0.1f);
		}
		if (keycode == Input.Keys.MINUS) {
			screen.setZoom(0.1f);
		}
		if (keycode == Input.Keys.SPACE) {
			if (screen.getPause()) {
				screen.setPause(false);;
			} else {
				screen.setPause(true);
			}
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (button == Input.Buttons.LEFT ) {
			screen.setCamera(screenX, screenY, 0, 0);
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
}
