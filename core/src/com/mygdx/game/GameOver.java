package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver implements Screen {

	SpriteBatch batchfont;
	BitmapFont endfont;
	String h;
	public void show() {
		batchfont = new SpriteBatch();
		endfont = new BitmapFont(Gdx.files.internal("default.fnt"));
		h = "                          GAME OVER	\n\n Press Enter or Escape to go back to the main menu";
		Gdx.input.setInputProcessor(new InputCont() { 
			public boolean keyDown(int keycode) {
				if(keycode == Keys.ENTER || keycode == Keys.ESCAPE) {
					( (Game)Gdx.app.getApplicationListener()).setScreen(new menu());
				}
				return true;
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0 ,0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batchfont.begin();
		
	//	batchfont.draw();

		
		endfont.draw(batchfont, h, Gdx.graphics.getWidth() / 2 - 250, Gdx.graphics.getHeight()/2 + 100);
		batchfont.end();

	}
	

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}