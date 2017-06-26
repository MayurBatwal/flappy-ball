package com.mygdx.game;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Play2 implements Screen {

	private OrthographicCamera cam;
	private Sound endsound;
	private World world;
	private Box2DDebugRenderer debugRenderer;
	private final float TIMESTEP = 1/60f;
	private final int VELOCITYITERATION = 8;
	private final int POSITIONITERATION = 3;
	private Body ball;
	private Body endwall;
	private Body bwall1;
	private Body bwall2;
	private Body bwall3;
	private Body bwall4;
	private Body bwall5;
	private Body bwall6;
	private Body bwall7;
	private Sound soundintro; 

	private float speed = 450;
	private Vector2 movement = new Vector2();
	
	SpriteBatch batchfont;
	BitmapFont helpfont;
	String h;
	
	
	@Override
	public void show() {
		batchfont = new SpriteBatch();
		helpfont = new BitmapFont(Gdx.files.internal("default.fnt"));
		h = "Level 2";
		soundintro = Gdx.audio.newSound(Gdx.files.internal("131659__bertrof__game-sound-intro-to-game.wav"));
		soundintro.loop(1.0f,1.0f,0f);
		endsound = Gdx.audio.newSound(Gdx.files.internal("76376__spazzo-1493__game-over.wav"));
		
		world = new World(new Vector2(0, -9.81f), true); 
		debugRenderer = new Box2DDebugRenderer();
		cam = new OrthographicCamera();
		
		
		movement.x = 25;
		Gdx.input.setInputProcessor(new InputCont() { 
			public boolean keyDown(int keycode) {
				if(keycode == Keys.ESCAPE) {
					( (Game)Gdx.app.getApplicationListener()).setScreen(new menu());
				}
							if(keycode == Keys.UP) {
								movement.y = speed;
							}
							if(keycode == Keys.DOWN) {
								movement.y = -(speed - 50);
							}
				return true;
			}
					public boolean keyUp(int keycode) {
							if(keycode == Keys.UP) {
								movement.y = 0;
							}
							if(keycode == Keys.DOWN) {
								movement.y = 0;
							}
							return true;
					}

			
					
		});
		
		BodyDef balldef = new BodyDef();
		balldef.type = BodyType.DynamicBody;
				balldef.position.set(-47,0);		//modification
		
		FixtureDef fixturedef = new FixtureDef();
		fixturedef.density = 2.5f;
		fixturedef.friction = 0.2f;
		fixturedef.restitution = 0f;
		
		CircleShape shape = new CircleShape();
		shape.setRadius(1.0f);
		fixturedef.shape = shape;
		ball = world.createBody(balldef);
		ball.createFixture(fixturedef);
		
		balldef.type = BodyType.StaticBody;
		balldef.position.set(0,0);
		
		ChainShape groundshape = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(-50,-30), new Vector2(50,-30)});
		fixturedef.friction = 1f;
		fixturedef.restitution = 1f;
		fixturedef.shape = groundshape;
		world.createBody(balldef).createFixture(fixturedef);
		groundshape.dispose();
		
		ChainShape groundshape2 = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(-50,-30), new Vector2(-50,30)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0.8f;
		fixturedef.shape = groundshape2;
		world.createBody(balldef).createFixture(fixturedef);
		groundshape2.dispose();
		
						balldef.type = BodyType.KinematicBody;
		ChainShape groundshape3 = new ChainShape();
		groundshape3.createChain(new Vector2[] { new Vector2(50,-30), new Vector2(50,30)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0.8f;
		fixturedef.shape = groundshape3;
		endwall = world.createBody(balldef);
		endwall.createFixture(fixturedef);
		groundshape3.dispose();
		
						balldef.type = BodyType.StaticBody;

		ChainShape groundshape4 = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(-50,30), new Vector2(50,30)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0.8f;
		fixturedef.shape = groundshape4;
		world.createBody(balldef).createFixture(fixturedef);
		groundshape4.dispose();
		
		
		
		ChainShape groundshape5 = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(-30,-10), new Vector2(-30,10)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0f;
		fixturedef.shape = groundshape5;
		bwall1 = world.createBody(balldef);
		bwall1.createFixture(fixturedef);
		groundshape5.dispose();
		
		ChainShape groundshape6 = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(-10, 0), new Vector2(-10,20)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0f;
		fixturedef.shape = groundshape6;
		bwall2 = world.createBody(balldef);
		bwall2.createFixture(fixturedef);		groundshape6.dispose();
		
		ChainShape groundshape7 = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(10, 0), new Vector2(10,-20)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0f;
		fixturedef.shape = groundshape7;
		bwall3 = world.createBody(balldef);
		bwall3.createFixture(fixturedef);
		groundshape7.dispose();
		
		ChainShape groundshape8 = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(30, 10), new Vector2(30,-10)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0f;
		fixturedef.shape = groundshape8;
		bwall4 = world.createBody(balldef);
		bwall4.createFixture(fixturedef);		groundshape8.dispose();
		
		ChainShape groundshape9 = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(-20,-20), new Vector2(0,-20)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0f;
		fixturedef.shape = groundshape9;
		bwall5 = world.createBody(balldef);
		bwall5.createFixture(fixturedef);
		groundshape9.dispose();
		
		ChainShape groundshape10 = new ChainShape();
		groundshape.createChain(new Vector2[] { new Vector2(10,20), new Vector2(30,20)});
		fixturedef.friction = 0.5f;
		fixturedef.restitution = 0f;
		fixturedef.shape = groundshape10;
		bwall6 = world.createBody(balldef);
		bwall6.createFixture(fixturedef);
		groundshape10.dispose();
		
		
		
		
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0 , 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batchfont.begin();
		
		//	batchfont.draw();

			
			helpfont.draw(batchfont, h, Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getHeight()/2 + 320);
			batchfont.end();
		debugRenderer.render(world, cam.combined);
		world.step(1/60f, 8, 3);
							ball.applyForceToCenter(movement, true);
							
							
							
							
							//contact detection
							int contacts = world.getContactCount();
							if(contacts > 0) {
								for(Contact contact : world.getContactList()){
									Fixture a = contact.getFixtureA();
									Fixture b = contact.getFixtureB();
									if(a.getBody().getType() == BodyType.KinematicBody || b.getBody().getType() == BodyType.KinematicBody) {
										soundintro.dispose();
										( (Game)Gdx.app.getApplicationListener()).setScreen(new Play4());
									}
									else if(a.getBody().getType() == BodyType.DynamicBody) {
										soundintro.dispose();
										
										endsound.play();
										( (Game)Gdx.app.getApplicationListener()).setScreen(new GameOver());
									}
									else if(b.getBody().getType() == BodyType.DynamicBody) {
										soundintro.dispose();
										
										endsound.play();
										( (Game)Gdx.app.getApplicationListener()).setScreen(new GameOver());
									}
								}
							}
		
	}

	@Override
	public void resize(int width, int height) {
		cam.viewportWidth = width / 10;
		cam.viewportHeight = height / 10;
		cam.update();
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
		dispose();

	}

	@Override
	public void dispose() {
		world.dispose();
		

	}
}
	