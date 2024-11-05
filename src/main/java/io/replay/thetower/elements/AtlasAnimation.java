package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.Texture2D;
import jpize.util.Animation;
import jpize.util.mesh.TextureBatch;
import jpize.util.region.TextureRegion;

public class AtlasAnimation extends Base{

    public int w, h, s_i, s_j;
    private float time, speed;
    private TextureRegion[] frames_tex;
    private Texture2D atlas;
    private final Animation<TextureRegion> anime;
    private boolean scalable;

    private AtlasAnimation(TextureBatch batch, int x, int y, int i, int j, int w, int h, String name, int frames, float speed, boolean scalable, Animation.Mode mode) {
        super(batch, x, y);
        this.s_i = i;
        this.s_j = j;
        this.w = w;
        this.h = h;
        this.speed = speed;

        this.frames_tex = new TextureRegion[frames];
        this.anime = new Animation<>(1f/frames, mode, frames_tex);

        this.atlas = new Texture2D("/animations/"+name+".png");

        this.scalable = scalable;
    }

    public AtlasAnimation(TextureBatch batch, int x, int y, int i, int j, int w, int h, String name, int frames, float speed, boolean scalable) {
        this(batch, x, y, i, j, w, h, name, frames, speed, scalable, Animation.Mode.LOOP);
        for (int f = 0; f < frames; f++)
            this.frames_tex[f] = new TextureRegion(atlas, f * s_i, 0, s_i, s_j);
    }

    public AtlasAnimation(TextureBatch batch, int x, int y, int i, int j, int w, int h, String name, int frames, float speed, boolean scalable, int num, int offset) {
        this(batch, x, y, i, j, w, h, name, frames, speed, scalable, Animation.Mode.LOOP);
        for (int f = 0; f < frames; f++)
            this.frames_tex[f] = new TextureRegion(atlas, f * s_i + offset * s_i, s_j * num, s_i, s_j);
    }

    public AtlasAnimation(TextureBatch batch, int x, int y, int i, int j, int w, int h, String name, int frames, float speed, boolean scalable, int num, int offset, Animation.Mode mode) {
        this(batch, x, y, i, j, w, h, name, frames, speed, scalable, mode);
        for (int f = 0; f < frames; f++)
            this.frames_tex[f] = new TextureRegion(atlas, f * s_i + offset * s_i, s_j * num, s_i, s_j);
    }

    public void render(){
        time += Jpize.getDT()*speed;
        float scaleX = scalable ? (Jpize.getWidth()  / 1920f) : 1f;
        float scaleY = scalable ? (Jpize.getHeight() / 1080f) : 1f;
        batch.draw(anime.getKeyFrame(time), x, y, w * scaleX, h * scaleY);
    }

    @Override
    public void dispose(){
        atlas.dispose();
    }

}
