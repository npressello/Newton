package npressello.com.github.newton;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Newton extends Game {
	private SpriteBatch batch;
	private BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
		
	}
	
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
	
	public SpriteBatch getSpriteBatch() {
		return batch;
	}
	
	public BitmapFont getFont() {
		return font;
	}
}
