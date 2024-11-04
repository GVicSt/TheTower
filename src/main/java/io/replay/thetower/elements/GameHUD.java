package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.util.font.Charset;
import jpize.util.font.Font;
import jpize.util.font.FontLoader;
import jpize.util.math.vector.Vec2f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameHUD {

    private Font font = FontLoader.loadTrueType("/fonts/square_pixel.ttf", 80, Charset.DEFAULT_ENG_RUS, false);
    private List<InterfaceElement> elements;

    public GameHUD(InterfaceElement... iElements){
        elements = new ArrayList<>();
        this.elements.addAll(Arrays.asList(iElements));
    }

    public void update(Vec2f position){
        for (InterfaceElement element : elements) {
            element.setPosition(position);
        }
    }

    public void render(){
        for (InterfaceElement element : elements) {
            if (element.get_isAnimation()) {
                element.drawAni();
            } else {
                element.draw();
            }
        }
        font.drawText("FPS: "+ Jpize.getFPS(),10,10);
    }



}
