package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.TextureBatch;
import jpize.util.math.vector.Vec2f;

public class InterfaceElement extends Base{

    private Sprite tex;
    private AtlasAnimation ani;
    public float w, h;

    public InterfaceElement(TextureBatch batch, float x, float y, float w, float h, String path) {
        super(batch, x, y);
        this.tex = new Sprite(batch, x, y, w, h, path, true);
        this.w = w;
        this.h = h;
    }
    public InterfaceElement(TextureBatch batch, float x, float y, float w, float h, int aw, int ah, String path, int frames) {
        super(batch, x, y);
        this.ani = new AtlasAnimation(batch, (int) x, (int) y, aw, ah, (int) w, (int) h, path, frames, 1, false);
        this.w = w;
        this.h = h;
    }

    public void draw(){
        tex.render();
    }
    public void drawAni(){
        ani.render();
    }

    public void setPosition(Vec2f position){
        if(get_isAnimation()){
            ani.x = position.x - Jpize.getWidth() / 8f;
            ani.y = position.y + Jpize.getHeight() / 8f - ani.h ;
        }else{
            tex.x = position.x - Jpize.getWidth() / 8f;
            tex.y = position.y + Jpize.getHeight() / 8f - tex.h;
        }
    }

    public boolean get_isAnimation(){
        return ani!=null;
    }

}
