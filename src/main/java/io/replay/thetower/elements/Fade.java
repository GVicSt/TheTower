package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.TextureBatch;
import jpize.util.color.Color;
import jpize.util.font.Font;

import java.util.Objects;

public class Fade {

    private boolean end;
    private float time = 0;
    private Color black = new Color(0f, 0f, 0f, 1f);
    private Color white = new Color(1f, 1f, 1f, 1f);

    public boolean in(TextureBatch batch, float speed){
        if(!Objects.equals(batch.color(), white))
            if(!(time/speed>=1)) {
                time += Jpize.getDT();
                batch.setColor(0f + (time / speed), 0f + (time / speed), 0f + (time / speed), 1f);
            } else {
                end = true;
                batch.setColor(white);
            }
        return end;
    }

    public boolean in(TextureBatch batch, Font font, float speed){
        if(!Objects.equals(batch.color(), white))
            if(!(time/speed>=1)) {
                time += Jpize.getDT();
                font.options().color.set(0f + (time / speed), 0f + (time / speed), 0f + (time / speed), 1f);
                batch.setColor(0f + (time / speed), 0f + (time / speed), 0f + (time / speed), 1f);
            } else {
                end = true;
                batch.setColor(white);
                font.options().color.set(white);
            }
        return end;
    }

    public boolean out(TextureBatch batch, float speed){
        if(!Objects.equals(batch.color(), black))
            if(!(time/speed>=1)) {
                time += Jpize.getDT();
                batch.setColor(1f - (time / speed), 1f - (time / speed), 1f - (time / speed), 1f);
            } else {
                end = true;
                batch.setColor(black);
            }
        return end;
    }

    public boolean out(TextureBatch batch, Font font, float speed){
        if(!Objects.equals(batch.color(), black))
            if(!(time/speed>=1)) {
                time += Jpize.getDT();
                font.options().color.set(0f + (time / speed), 0f + (time / speed), 0f + (time / speed), 1f);
                batch.setColor(1f - (time / speed), 1f - (time / speed), 1f - (time / speed), 1f);
            } else {
                end = true;
                batch.setColor(black);
                font.options().color.set(white);
            }
        return end;
    }

    public void reset() {
        time = 0;
        end = false;
    }

}
