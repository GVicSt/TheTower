package io.replay.thetower.elements;

import io.replay.thetower.MainClass;
import io.replay.thetower.scripts.Controlls;
import jpize.app.Jpize;
import jpize.gl.texture.TextureBatch;
import jpize.util.camera.OrthographicCameraCentered;
import jpize.util.math.vector.Vec2f;

import static java.lang.Float.max;
import static java.lang.Float.min;

public class Player{

    public OrthographicCameraCentered cam;
    private TextureBatch batch;
    private PlayerAnimation animation;
    private Controlls controlls = new Controlls();
    private Vec2f position;
    private Vec2f camPosition;
    private MainClass main;
    private final GameHUD gameHUD;

    private int hp, maxHp, stamina, maxStamina;

    public Player(TextureBatch batch, MainClass main){
        this.batch = batch;
        this.position = new Vec2f(640,640);
        this.camPosition = new Vec2f(640,640);
        this.cam = new OrthographicCameraCentered();
        this.cam.scale(4f);
        this.animation = new PlayerAnimation(batch);
        this.animation.init();
        this.main = main;

        this.hp = 5;
        this.maxHp = 10;
        this.stamina = 7;
        this.maxStamina = 10;

        float x = position.x-Jpize.getWidth()/8f;
        float y = position.y+Jpize.getHeight()/8f;
        gameHUD = new GameHUD(this,
                new HudSprite(batch, x, y, 64, 64, "/sprites/hud_player_cover.png"),
                new HudAnimation(batch, x, y, 64, 64, 32, 32, "hud/player_head", 2),
                new HudBar(batch, x, y, 0),
                new HudBar(batch, x, y, 1)
        );
    }

    public void update() {
        position.add(controlls.getMove());
        camPosition.set(max(min(position.x, 63f * 16), 16f * 16), max(min(position.y+16, 69f * 16), 10f * 16));
        cam.position().set(camPosition);

        controlls.updateGame(main);
        cam.update();
        gameHUD.update(camPosition);
        animation.update(controlls, position);
    }

    public void render(){
        batch.setup(cam);
        gameHUD.render();
        animation.render();
    }

    public Vec2f getPosition(){
        return position;
    }

    public OrthographicCameraCentered getCamera(){
        return cam;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }
}
