package io.replay.thetower.managers;

import io.replay.thetower.elements.AtlasAnimation;
import jpize.gl.texture.TextureBatch;

public class PlayerAnimationManager {

    static class Animation{
        String id;
        AtlasAnimation animation;

        public Animation(String id, AtlasAnimation animation){
            this.id = id;
            this.animation = animation;
        }
    }


    private Animation[] animations;
    private AtlasAnimation current_animation;

    public PlayerAnimationManager(TextureBatch batch){
        this.animations = new Animation[]{
            new Animation("idle",            new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/0/body" , 4, 1    , false, 1, 0)),
            new Animation("a_idle",          new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/0/arm"  , 4, 1    , false, 1, 0)),
            new Animation("walk_x+_start",   new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/body", 1, 0    , false, 1, 0)),
            new Animation("walk_x+_end",     new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/body", 2, 0    , false, 1, 2, jpize.util.Animation.Mode.NORMAL)),
            new Animation("walk_x+_loop",    new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/body", 5, 0.95f, false, 1, 0)),
            new Animation("a_walk_x+_start", new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/arm" , 1, 0    , false, 1, 0)),
            new Animation("a_walk_x+_end",   new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/arm" , 2, 0    , false, 1, 2, jpize.util.Animation.Mode.NORMAL)),
            new Animation("a_walk_x+_loop",  new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/arm" , 5, 0.95f, false, 1, 0)),
            new Animation("run_x+_start",    new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/body", 1, 0    , false, 4, 0)),
            new Animation("run_x+_end",      new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/body", 2, 0    , false, 4, 2, jpize.util.Animation.Mode.NORMAL)),
            new Animation("run_x+_loop",     new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/body", 6, 0.95f, false, 4, 0)),
            new Animation("a_run_x+_start",  new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/arm" , 1, 0    , false, 4, 0)),
            new Animation("a_run_x+_end",    new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/arm" , 2, 0    , false, 4, 2, jpize.util.Animation.Mode.NORMAL)),
            new Animation("a_run_x+_loop",   new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/arm" , 6, 0.95f, false, 4, 0)),
            new Animation("8",               new AtlasAnimation(batch, 0, 0, 32, 32, 32, 32, "/animations/player/x1/body", 6, 1    , false, 1, 0)),
        };
    }

    public AtlasAnimation getAnimation(String id){
        for (Animation animation : animations)
            if (animation.id.equals(id))
                return animation.animation;
        return animations[0].animation;
    }

    public AtlasAnimation getCurrent_animation() {
        return current_animation;
    }

    public void setCurrent_animation(String id) {
        this.current_animation = getAnimation(id);
    }

}