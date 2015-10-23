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
	private static float CAMERA_WIDTH = 8000;
	private static float CAMERA_HEIGHT = 6000;
	private float zoom = 1.0f;
	private boolean pause = false;
	private boolean lockCam = false;
	private String planetLocked = "Earth";
	float xPos;
	float yPos;
	float xSpeed;
	float ySpeed;
	
	public GameScreen(final Newton game) {
		this.game = game;
		universe = new Universe(this);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		camera.position.x = 0;
		camera.position.y = 0;
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
			long time = System.nanoTime();
			universe.update(delta);
			long timePassed = System.nanoTime() - time;
			System.out.printf("%f\n", ((double)timePassed/1000000000));
			shapeRenderer.setProjectionMatrix(camera.combined);		
			shapeRenderer.begin(ShapeType.Filled);			
			for (Planet planet: universe.getGalaxy().getSystems()[0].getPlanets()) {
				shapeRenderer.setColor(planet.getColor());
				shapeRenderer.circle(planet.getPosition().x, planet.getPosition().y, planet.getRadius());
				if (planet.getName().equals(planetLocked)) {
					xPos = planet.getPosition().x;
					yPos = planet.getPosition().y;
					xSpeed = planet.getVelocity().x;
					ySpeed = planet.getVelocity().y;
					if (lockCam) {
						camera.position.x = xPos;
						camera.position.y = yPos;
						camera.update();
					}					
				}
			}		
			shapeRenderer.end();
			
			shapeRenderer.begin(ShapeType.Line);
			for (Planet planet: universe.getGalaxy().getSystems()[0].getPlanets()) {
				shapeRenderer.setColor(planet.getColor());
				shapeRenderer.polygon(planet.getOrbitPoints());				
			}
			shapeRenderer.end();
			
			game.getSpriteBatch().setProjectionMatrix(textCamera.combined);
			game.getSpriteBatch().begin();
			game.getFont().draw(game.getSpriteBatch(), "Name: "+planetLocked, 10, 590);
			game.getFont().draw(game.getSpriteBatch(), "xPos: "+xPos, 10, 575);
			game.getFont().draw(game.getSpriteBatch(), "yPos: "+yPos, 10, 560);
			game.getFont().draw(game.getSpriteBatch(), "xSpeed: "+xSpeed, 10, 545);
			game.getFont().draw(game.getSpriteBatch(), "ySpeed: "+ySpeed, 10, 530);
			game.getFont().draw(game.getSpriteBatch(), "FPS: "+Gdx.graphics.getFramesPerSecond(), 650, 590);
			game.getFont().draw(game.getSpriteBatch(), "Java Heap: "+Gdx.app.getJavaHeap() / 1024, 650, 575);
			game.getFont().draw(game.getSpriteBatch(), "Native Heap: "+Gdx.app.getNativeHeap() / 1024, 650, 560);
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
