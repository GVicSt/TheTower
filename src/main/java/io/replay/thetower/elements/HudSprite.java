package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.util.math.vector.Vec2f;
import jpize.util.mesh.TextureBatch;

public class HudSprite extends Base implements HudElement {

    private Sprite tex;
    public float w, h;

    public HudSprite(TextureBatch batch, float x, float y, float w, float h, String path) {
        super(batch, x, y);
        this.tex = new Sprite(batch, x, y, w, h, path, true);
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(){
        tex.render();
    }

    @Override
    public void setPosition(Vec2f position){
        tex.x = position.x - Jpize.getWidth() / 8f;
        tex.y = position.y + Jpize.getHeight() / 8f - tex.h;
    }

}
