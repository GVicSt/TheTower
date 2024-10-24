package io.replay.thetower.elements;

import jpize.gl.texture.TextureBatch;

public class Base {

    public TextureBatch batch;
    public float x, y;

    public Base(TextureBatch batch, float x, float y){
        this.batch = batch;
        this.x = x;
        this.y = y;
    }

    public void dispose(){
    }
}
