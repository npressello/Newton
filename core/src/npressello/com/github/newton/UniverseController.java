package npressello.com.github.newton;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class UniverseController implements InputProcessor{

	private GameScreen screen;
	private Universe universe;
	private int lastKey = 0;
	private boolean[] keysPressed;
	
	public UniverseController(GameScreen screen, Universe universe) {
		this.screen = screen;
		this.universe = universe;
		keysPressed = new boolean[10];
	}
	
	@Override
	public boolean keyDown(int keycode) {
		float xPos = 0;
		float yPos = 0;
		if (keycode == Input.Keys.NUM_0) {
			lastKey = 0;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[0].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[0].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_1) {
			lastKey = 1;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[1].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[1].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_2) {
			lastKey = 2;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[2].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[2].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_3) {
			lastKey = 3;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[3].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[3].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_4) {
			lastKey = 4;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[4].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[4].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_5) {
			lastKey = 5;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[5].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[5].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_6) {
			lastKey = 6;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[6].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[6].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_7) {
			lastKey = 7;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[7].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[7].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_8) {
			lastKey = 8;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[8].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[8].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.NUM_9) {
			lastKey = 9;
			xPos = universe.getGalaxy().getSystems()[0].getPlanets()[9].getPosition().x;
			yPos = universe.getGalaxy().getSystems()[0].getPlanets()[9].getPosition().y;
			screen.setCamera(xPos, yPos, 0, 0);
		}
		if (keycode == Input.Keys.L) {
			String name = universe.getGalaxy().getSystems()[0].getPlanets()[lastKey].getName();
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
		if (keycode == Input.Keys.UP) {
			keysPressed[0] = true;
		} else if (keycode == Input.Keys.DOWN) {
			keysPressed[1] = true;
		}
		if (keycode == Input.Keys.LEFT) {
			keysPressed[2] = true;
		} else if (keycode == Input.Keys.RIGHT) {
			keysPressed[3] = true;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Input.Keys.UP) {
			keysPressed[0] = false;
		}
		if (keycode == Input.Keys.DOWN) {
			keysPressed[1] = false;
		}
		if (keycode == Input.Keys.LEFT) {
			keysPressed[2] = false;
		}
		if (keycode == Input.Keys.RIGHT) {
			keysPressed[3] = false;
		}
		return true;
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
	
	public boolean isPressed(int key) {
		return keysPressed[key];
	}
}
