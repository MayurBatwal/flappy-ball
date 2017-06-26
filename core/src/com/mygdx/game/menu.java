package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class menu implements Screen{
	
	public Sound soundintro;
	Sound soundgame;
	Sound soundend;
	private Stage stage;
	private Skin skin;
	private TextButton start;
	private TextButton end;
	private TextButton help;
	private Table table;
	private SpriteBatch batch;
	private Sprite sprite;
	private Sprite sprite2;
	private Texture bg;
	private Texture bg2;
	
	
	@Override
	public void show() {
		soundintro = Gdx.audio.newSound(Gdx.files.internal("265549__vikuserro__cheap-flash-game-tune.wav"));
		soundintro.loop(1.0f,1.0f,0f);
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage(new ScreenViewport());
		
		table = new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center|Align.top);
		table.setPosition(0, Gdx.graphics.getHeight());
		
		
		start = new TextButton("New Game", skin);
		end = new TextButton("Quit Game",skin);
		help = new TextButton("Help", skin);
		
		start.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				soundintro.dispose();
				( (Game)Gdx.app.getApplicationListener()).setScreen(new Play());
			
				
			} });
		end.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			} });
		help.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				soundintro.dispose();
				( (Game)Gdx.app.getApplicationListener()).setScreen(new Help());
			
				
			} });
		
		
		
		table.padTop(50);
		table.add(start).padBottom(50);
		table.row();
		table.add(help).padBottom(50);
		table.row();
		table.add(end);
		
		
		stage.addActor(table);
		bg = new Texture(Gdx.files.internal("bg1.png")); 
		bg2 = new Texture(Gdx.files.internal("badlogic.jpg")); 
		batch = new SpriteBatch();
		sprite = new Sprite(bg);
		sprite2 = new Sprite(bg2);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		sprite2.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//InputMultiplexer im = new InputMultiplexer(stage, this); 
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		sprite.draw(batch);
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
		
		/*stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();*/
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		
		
	}

}