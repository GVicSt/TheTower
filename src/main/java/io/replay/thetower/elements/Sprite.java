package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.Texture2D;
import jpize.gl.texture.TextureBatch;

public class Sprite extends Base{

    private int w, h;
    private Texture2D sprite;
    private boolean scalable;

    public Sprite(TextureBatch batch, float x, float y, int w, int h, String path, boolean scalable) {
        super(batch, x, y);

        this.w = w;
        this.h = h;
        this.sprite = new Texture2D(path);
        this.scalable = scalable;
    }

    public void render(){
        float scaleX = scalable ? (Jpize.getWidth()  / 1920f) : 1f;
        float scaleY = scalable ? (Jpize.getHeight() / 1080f) : 1f;

        batch.draw(sprite, x, y, w * scaleX, h * scaleY);
    }

    @Override
    public void dispose(){
        sprite.dispose();
    }

}
