package io.replay.thetower.elements;

import io.replay.thetower.MainClass;
import io.replay.thetower.managers.PlayerAnimationManager;
import io.replay.thetower.scripts.Controlls;
import jpize.app.Jpize;
import jpize.gl.texture.TextureBatch;
import jpize.glfw.input.Key;
import jpize.util.camera.OrthographicCameraCentered;
import jpize.util.math.vector.Vec2f;

import static java.lang.Float.max;
import static java.lang.Float.min;

public class Player{

    public OrthographicCameraCentered cam;
    private TextureBatch batch;
    private PlayerAnimationManager animation_body;
    private PlayerAnimationManager animation_arm;
    private Controlls controlls = new Controlls();
    private Vec2f position;
    private float timer;

    public Player(TextureBatch batch){
        this.batch = batch;
        this.position = new Vec2f(632,632);
        this.animation_body = new PlayerAnimationManager(batch);
        this.animation_arm = new PlayerAnimationManager(batch);
        this.cam = new OrthographicCameraCentered();
        this.cam.scale(4f);
        this.animation_body.setCurrent_animation("idle");
        this.animation_arm.setCurrent_animation("a_idle");
    }

    public void update(MainClass main) {
        cam.update();
        position.add(controlls.getMove());
        cam.position().set(max(min(position.x, 63f * 16), 16f * 16), max(min(position.y, 69f * 16), 10f * 16));

        boolean idle = controlls.getMove().isZero() && controlls.getMove().isZero();
        boolean run = Key.LSHIFT.pressed();

        String dir = controlls.getMove().x>0?"x+":controlls.getMove().x<0?"x-":controlls.getMove().y>0?"y+":controlls.getMove().y<0?"y-":"";
        String sprite_id = idle ? "idle" : run ? ("run_" + dir + "_loop") : ("walk_" + dir + "_loop");
        animation_body.setCurrent_animation(sprite_id);
        animation_arm.setCurrent_animation("a_"+ (sprite_id));

        animation_body.getCurrent_animation().x = position.x;
        animation_arm.getCurrent_animation().x = position.x;
        animation_body.getCurrent_animation().y = position.y;
        animation_arm.getCurrent_animation().y = position.y;

        timer += Jpize.getDT();
        if((controlls.getMove().x != 0 || controlls.getMove().y != 0) && timer > 1f)
            main.audioManager.getSound(0).play();
        if(timer>0.1f)
            timer = 0;
    }

    public void render(){
        batch.setup(cam);
        animation_body.getCurrent_animation().render();
        animation_arm.getCurrent_animation().render();
    }

    public Vec2f getPosition(){
        return position;
    }

    public OrthographicCameraCentered getCamera(){
        return cam;
    }

}
