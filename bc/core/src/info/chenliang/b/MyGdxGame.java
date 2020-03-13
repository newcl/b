package info.chenliang.b;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
//	float rotation;

//	Vector2 pos;

	MoveSystem moveSystem;
	PositionComponent source, target;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("triangle.png");
//		img = scale("triangle.png", 128);
//		img = scale("triangle.png", 512);

		source = new PositionComponent(new Vector2(Gdx.graphics.getWidth() / 2 , Gdx.graphics.getHeight()/2 ), 0f);
		target = new PositionComponent(source);

		log.info(source.getPosition().toString());

		sprite = new Sprite(img);
		sprite.setOriginCenter();
		sprite.setScale(0.3f);
		sprite.setPosition(source.position.x, source.position.y);
		sprite.setRotation(source.rotation);


		moveSystem = new MoveSystem();

		Gdx.input.setInputProcessor(new InputAdapter(){
			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				log.info("{} {} {} {}", screenX, screenY, pointer, button);

				if (Input.Buttons.LEFT == button) {
					target.setPosition(new Vector2(screenX, screenY));
				}
				return true;
			}


		});

	}

	@Override
	public void render () {
		move();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

//		batch.draw(img, Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight()/2 - img.getHeight() / 2);
//		batch.draw(img, 100, 100);
//		batch.draw();


//		rotation += 5;
//		sprite.setRotation(-90);
		sprite.draw(batch);
//		log.info("{}", source.getPosition());
		sprite.setPosition(source.getPosition().x - sprite.getWidth() / 2, Gdx.graphics.getHeight() - source.getPosition().y - sprite.getHeight()/2);

//		System.out.println(sprite.getWidth() + ":" + sprite.getHeight());
//    System.out.println(sprite.getRegionWidth() + ":" + sprite.getRegionHeight());


//		Gdx.graphics.getWidth() / 2 - img.getWidth() / 2;
		batch.end();
	}

	private void move() {
		moveSystem.move(source, target);
	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	private Texture scale(String imagePath, int dimension) {
		Pixmap source = new Pixmap(Gdx.files.internal(imagePath));
		Pixmap target = new Pixmap(dimension, dimension, source.getFormat());

		target.drawPixmap(source,
			0, 0, source.getWidth(), source.getHeight(),
			0, 0, target.getWidth(), target.getHeight()
		);

//		target.setColor(Color.BLUE);
//		target.fillCircle(0, 0 , 70);

		Texture texture = new Texture(target);

		source.dispose();
		target.dispose();

		return texture;
	}
}
