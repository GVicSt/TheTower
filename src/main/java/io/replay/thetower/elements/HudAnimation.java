package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.TextureBatch;
import jpize.util.math.vector.Vec2f;

public class HudAnimation extends Base implements HudElement {

    private AtlasAnimation ani;
    public float w, h;

    public HudAnimation(TextureBatch batch, float x, float y, float w, float h, int aw, int ah, String path, int frames) {
        super(batch, x, y);
        this.ani = new AtlasAnimation(batch, (int) x, (int) y, aw, ah, (int) w, (int) h, path, frames, 1, false);
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(){
        ani.render();
    }

    @Override
    public void setPosition(Vec2f position){
        ani.x = position.x - Jpize.getWidth() / 8f;
        ani.y = position.y + Jpize.getHeight() / 8f - ani.h ;
    }

}
