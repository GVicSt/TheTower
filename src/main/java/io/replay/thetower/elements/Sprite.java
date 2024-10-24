package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.Texture2D;
import jpize.gl.texture.TextureBatch;

import java.util.ArrayList;
import java.util.List;

public class Sprite extends Base{

    private int w, h;
    private float aspect;

    private Texture2D sprite;

    public Sprite(TextureBatch batch, int x, int y, int w, int h, String path) {
        super(batch, x, y);
        this.w = w;
        this.h = h;

        this.sprite = new Texture2D(path);
    }

    public Sprite(TextureBatch batch, float x, float y, int w, int h, String path) {
        super(batch, x, y);
        this.w = w;
        this.h = h;

        this.sprite = new Texture2D(path);
    }

    public void render(){
        aspect = 1920f/ Jpize.getWidth();

        batch.draw(sprite, x*aspect, y*aspect, w*aspect, h*aspect);
    }

    @Override
    public void dispose(){
        sprite.dispose();
    }
}
