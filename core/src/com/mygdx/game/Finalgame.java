package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Sound;

public class Finalgame extends Game{
	Sound soundintro;
	Sound soundgame;
	Sound soundend;
	
	
	
	@Override
	public void create () {
			setScreen(new menu());
		/*soundintro = Gdx.audio.newSound(Gdx.files.internal("265549__vikuserro__cheap-flash-game-tune.wav"));
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
				( (Game)Gdx.app.getApplicationListener()).setScreen(new Play(game));
			
				
			} });
		end.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
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
		
		InputMultiplexer im = new InputMultiplexer(stage, this); 
		Gdx.input.setInputProcessor(im);*/
	}

	@Override
	public void render () {
		super.render();
		
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();*/
		
	}
	
	public void dispose(){
		super.dispose();
	}
	
	public void resize(int width, int height){
		super.resize(width, height);
	}
	
	public void pause(){
		super.pause();
	}
	
	public void resume(){
		super.resume();
	}

	
	
					
	
					
}	
