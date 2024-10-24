package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.Texture2D;
import jpize.gl.texture.TextureBatch;
import jpize.util.Animation;
import jpize.util.region.TextureRegion;

public class AtlasAnimation extends Base{

    private int w, h, s_i, s_j;
    private float aspect, time, speed;

    private TextureRegion[] frames_tex;
    private Texture2D atlas;
    private final Animation<TextureRegion> anime;

    public AtlasAnimation(TextureBatch batch, int x, int y, int i, int j, int w, int h, String path, int frames, int speed) {
        super(batch, x, y);
        this.s_i = i;
        this.s_j = j;
        this.w = w;
        this.h = h;
        this.speed = speed;

        this.frames_tex = new TextureRegion[frames];
        anime = new Animation<>(1f/frames, Animation.Mode.LOOP, frames_tex);

        atlas = new Texture2D(path+"/ani.png");
        for (int f = 0; f < frames; f++) {
            frames_tex[f] = new TextureRegion(atlas, f * s_i, 0, s_i, s_j);
        }
    }

    public AtlasAnimation(TextureBatch batch, int x, int y, int i, int j, int w, int h, String path, int frames, float speed, int num, int offset) {
        super(batch, x, y);
        this.s_i = i;
        this.s_j = j;
        this.w = w;
        this.h = h;
        this.speed = speed;

        this.frames_tex = new TextureRegion[frames];
        anime = new Animation<>(1f/frames, Animation.Mode.LOOP, frames_tex);

        atlas = new Texture2D(path+"/ani.png");
        for (int f = 0; f < frames; f++) {
            frames_tex[f] = new TextureRegion(atlas, f * s_i + offset * s_i, s_j * num, s_i, s_j);
        }
    }
    public AtlasAnimation(TextureBatch batch, int x, int y, int i, int j, int w, int h, String path, int frames, float speed, int num, int offset, Animation.Mode mode) {
        super(batch, x, y);
        this.s_i = i;
        this.s_j = j;
        this.w = w;
        this.h = h;
        this.speed = speed;

        this.frames_tex = new TextureRegion[frames];
        anime = new Animation<>(1f/frames, mode, frames_tex);

        atlas = new Texture2D(path+"/ani.png");
        for (int f = 0; f < frames; f++) {
            frames_tex[f] = new TextureRegion(atlas, f * s_i + offset * s_i, s_j * num, s_i, s_j);
        }
    }

    public void render(){
        aspect = 1920f/Jpize.getWidth();
        time += Jpize.getDT()*speed;

        batch.draw(anime.getKeyFrame(time), x*aspect, y*aspect, w*aspect, h*aspect);
    }

    public void setWH(int w, int h){
        this.w = w;
        this.h = h;
    }

    @Override
    public void dispose(){
        atlas.dispose();
    }
}
