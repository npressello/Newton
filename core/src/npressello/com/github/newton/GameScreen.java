package npressello.com.github.newton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameScreen implements Screen{

	private Newton game;
	private OrthographicCamera camera;
	private OrthographicCamera textCamera;
	private ShapeRenderer shapeRenderer;
	private Universe universe;
	private UniverseController controller;
	private static float CAMERA_WIDTH = 1600000;
	private static float CAMERA_HEIGHT = 1200000;
	private float zoom = 1.0f;
	private boolean pause = false;
	private boolean lockCam = false;
	private String planetLocked = "Earth";
	
	public GameScreen(final Newton game) {
		this.game = game;
		universe = new Universe(this);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1600000, 1200000);
		camera.update();
		textCamera = new OrthographicCamera();
		textCamera.setToOrtho(false, 800, 600);
		textCamera.update();
		shapeRenderer = new ShapeRenderer();
		controller = new UniverseController(this, universe);
		Gdx.input.setInputProcessor(controller);
	}
	
	@Override
	public void show() {		
	}

	@Override
	public void render(float delta) {
		if (!pause) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			universe.update(delta);
			
			shapeRenderer.setProjectionMatrix(camera.combined);		
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(1, 0, 0, 1);
			for (Planet planet: universe.getGalaxy().getSystems()[0].getPlanets()) {
				shapeRenderer.circle((float)planet.getPosition().x, (float)planet.getPosition().y, (float)planet.getRadius());
				if (planet.getName().equals(planetLocked) && lockCam) {
					camera.position.x = (float) planet.getPosition().x;
					camera.position.y = (float) planet.getPosition().y;
					camera.update();
				}
			}		
			shapeRenderer.end();
			
			game.getSpriteBatch().setProjectionMatrix(textCamera.combined);
			game.getSpriteBatch().begin();
			float xPos = 0;
			float yPos = 0;
			float xSpeed = 0;
			float ySpeed = 0;
			for (Planet p : universe.getGalaxy().getSystems()[0].getPlanets()) {
				if (p.getName().equals(planetLocked)) {
					xPos = (float) p.getPosition().x;
					yPos = (float) p.getPosition().y;
					xSpeed = (float) p.getVelocity().x;
					ySpeed = (float) p.getVelocity().y;
				}
			}
			game.getFont().draw(game.getSpriteBatch(), "Name: "+planetLocked, 10, 590);
			game.getFont().draw(game.getSpriteBatch(), "xPos: "+xPos, 10, 575);
			game.getFont().draw(game.getSpriteBatch(), "yPos: "+yPos, 10, 560);
			game.getFont().draw(game.getSpriteBatch(), "xSpeed: "+xSpeed, 10, 545);
			game.getFont().draw(game.getSpriteBatch(), "ySpeed: "+ySpeed, 10, 530);
			game.getFont().draw(game.getSpriteBatch(), "FPS: "+Gdx.graphics.getFramesPerSecond(), 740, 590);
			game.getSpriteBatch().end();
		}		
	}
	
	public void setCamera(float x, float y, float width, float height) {
		camera.position.x = x;
		camera.position.y = y;
		camera.update();
	}

	public void setZoom(float zoom) {
		if (this.zoom > 0.1f || zoom > 0) {
			this.zoom += zoom;
			camera.viewportWidth = CAMERA_WIDTH * this.zoom;
			camera.viewportHeight = CAMERA_HEIGHT * this.zoom;
			camera.update();
		}		
	}
	
	public void lockCam(String planet) {
		planetLocked = planet;
		if (lockCam) {
			lockCam = false;
		} else {
			lockCam = true;
		}
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	public boolean getPause() {
		return pause;
	}
	
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
