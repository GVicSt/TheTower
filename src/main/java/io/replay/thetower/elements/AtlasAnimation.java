package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.Texture2D;
import jpize.gl.texture.TextureBatch;
import jpize.util.region.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class Animation extends Base{

    private int w, h, frames, speed, frame=0;
    private float aspect, time;

    private List<Texture2D> sprites;

    public Animation(TextureBatch batch, int x, int y, int w, int h, String path, int frames, int speed) {
        super(batch, x, y);
        this.w = w;
        this.h = h;
        this.frames = frames;
        this.speed = speed;

        this.sprites = new ArrayList<Texture2D>();

        for (int i = 0; i < frames; i++) {
            frames[i] = new TextureRegion(ani_tex, i * 48, 0, 48, 48);
        }
    }

    public void render(){
        aspect = 1920f/Jpize.getWidth();
        time += Jpize.getDT();
        if(time>=((float)speed/frames*1)) {
            if (frame >= (frames - 1))
                frame = 0;
            else
                frame++;
            time = 0;
        }

        batch.draw(sprites.get(frame), x*aspect, y*aspect, w*aspect, h*aspect);
    }

    @Override
    public void dispose(){
        for (int i = 0; i < frames; i++) {
            sprites.get(i).dispose();;
        }
    }
}
