package io.replay.thetower.elements;

import io.replay.thetower.scripts.Controlls;
import jpize.glfw.input.Key;
import jpize.util.math.vector.Vec2f;
import jpize.util.mesh.TextureBatch;

public class PlayerAnimation {

    static class Animation{
        String id;
        AtlasAnimation animation;

        public Animation(String id, AtlasAnimation animation){
            this.id = id;
            this.animation = animation;
        }
    }


    private final Animation[] animations_body;
    private final Animation[] animations_arm;
    private AtlasAnimation current_animation_body;
    private AtlasAnimation current_animation_arm;

    public PlayerAnimation(TextureBatch batch){
        this.animations_body = new Animation[]{
            new Animation("idle",            new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "body/player_idle", 4, 1    , false, 1, 0)),
            new Animation("walk_x+_start",   new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "body/player_walk_x+_start", 1, 0    , false, 1, 0)),
            new Animation("walk_x+_end",     new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "body/player_walk_x+_end", 2, 0    , false, 1, 2, jpize.util.Animation.Mode.NORMAL)),
            new Animation("walk_x+_loop",    new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "body/player_walk_x+_loop", 5, 0.95f, false, 1, 0)),
            new Animation("run_x+_start",    new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "body/player_run_x+_start", 1, 0    , false, 4, 0)),
            new Animation("run_x+_end",      new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "body/player_run_x+_end", 2, 0    , false, 4, 2, jpize.util.Animation.Mode.NORMAL)),
            new Animation("run_x+_loop",     new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "body/player_run_x+_loop", 6, 0.95f, false, 4, 0)),
        };
        this.animations_arm = new Animation[]{
            new Animation("idle",          new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "arm/player_idle", 4, 1    , false, 1, 0)),
            new Animation("walk_x+_start", new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "arm/player_walk_x+_start", 1, 0    , false, 1, 0)),
            new Animation("walk_x+_end",   new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "arm/player_walk_x+_end", 2, 0    , false, 1, 2, jpize.util.Animation.Mode.NORMAL)),
            new Animation("walk_x+_loop",  new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "arm/player_walk_x+_loop", 5, 0.95f, false, 1, 0)),
            new Animation("run_x+_start",  new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "arm/player_run_x+_start", 1, 0    , false, 4, 0)),
            new Animation("run_x+_end",    new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "arm/player_run_x+_end", 2, 0    , false, 4, 2, jpize.util.Animation.Mode.NORMAL)),
            new Animation("run_x+_loop",   new AtlasAnimation(batch, -16, -16, 32, 32, 32, 32, "arm/player_run_x+_loop", 6, 0.95f, false, 4, 0)),
        };
    }

    public void init(){
        setCurrent_animation("idle");
    }

    public void render(){
        current_animation_body.render();
        current_animation_arm.render();
    }

    public void update(Controlls controlls, Vec2f position){
        boolean idle = controlls.getMove().isZero() && controlls.getMove().isZero();
        boolean run = Key.LSHIFT.pressed();

        String dir = controlls.getMove().x>0?"x+":controlls.getMove().x<0?"x-":controlls.getMove().y>0?"y+":controlls.getMove().y<0?"y-":"";
        String sprite_id = idle ? "idle" : run ? ("run_" + dir + "_loop") : ("walk_" + dir + "_loop");
        setCurrent_animation(sprite_id);

        current_animation_body.x = position.x - 16;
        current_animation_body.y = position.y;
        current_animation_arm.x = position.x - 16;
        current_animation_arm.y = position.y;
    }

    public void setCurrent_animation(String id) {
        this.current_animation_arm = getAnimation_arm(id);
        this.current_animation_body = getAnimation_body(id);
    }

    public AtlasAnimation getAnimation_body(String id){
        for (Animation animation : animations_body)
            if (animation.id.equals(id))
                return animation.animation;
        return animations_body[0].animation;
    }
    public AtlasAnimation getAnimation_arm(String id){
        for (Animation animation : animations_arm)
            if (animation.id.equals(id))
                return animation.animation;
        return animations_arm[0].animation;
    }
}