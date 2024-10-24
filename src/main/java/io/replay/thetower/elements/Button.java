package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.Texture2D;
import jpize.gl.texture.TextureBatch;
import jpize.glfw.input.MouseBtn;
import jpize.util.color.Color;
import jpize.util.font.Font;

public class Button extends Base{

    private int w, h;
    private boolean is_at_button, is_pressed, is_released, only_text;
    private String text;

    private Texture2D sprite, sprite_pressed;
    private Font font;

    public Button(TextureBatch batch, Font font, int x, int y, int w, int h, String path, String text, boolean only_text) {
        super(batch, x, y);
        this.w = w;
        this.h = h;
        this.text = text;
        this.only_text = only_text;
        this.font = font;
        this.sprite = new Texture2D(path+"/0.png");
        this.sprite_pressed = new Texture2D(path+"/1.png");
    }

    public void render(){
        float scaleX = Jpize.getWidth() / 1920f;
        float scaleY = Jpize.getHeight() / 1080f;
        font.options().scale = scaleY;
        Color old_color = font.options().color.copy();
        is_at_button = Jpize.getX() >= x * scaleX && Jpize.getX() <= x * scaleX + w * scaleX && Jpize.getY() >= y * scaleY && Jpize.getY() <= y * scaleY + h * scaleY;
        is_pressed = ( Jpize.input().isButtonPressed(MouseBtn.LEFT) || Jpize.input().isButtonPressed(MouseBtn.RIGHT) ) && is_at_button;
        is_released = ( Jpize.input().isButtonUp(MouseBtn.LEFT) || Jpize.input().isButtonUp(MouseBtn.RIGHT) ) && is_at_button;
        if(!only_text)batch.draw(is_pressed?sprite_pressed:sprite, x * scaleX, y * scaleY, w*scaleX, h*scaleY);
        if(is_pressed)font.options().color.set(0.75f,0.75f,0.75f,1f);
        batch.render();
        font.drawText(batch,text,x * scaleX+(w*scaleX/2f)-font.getTextWidth(text)/2f,y * scaleY+(h*scaleY/2f)-font.getTextHeight(text)/2f);
        font.options().color.set(old_color);
    }

    public boolean isPressed(){
        return is_pressed;
    }

    public boolean isReleased(){
        return is_released;
    }

    @Override
    public void dispose(){
        sprite.dispose();
    }

}
