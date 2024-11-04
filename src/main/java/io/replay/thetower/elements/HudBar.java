package io.replay.thetower.elements;

import jpize.app.Jpize;
import jpize.gl.texture.Texture2D;
import jpize.gl.texture.TextureBatch;
import jpize.util.math.vector.Vec2f;
import jpize.util.region.TextureRegion;

public class HudBar implements HudElement {

    private TextureBatch batch;
    private TextureRegion pointFull;
    private TextureRegion pointHalf;
    private TextureRegion pointEmpty;
    private TextureRegion pointEnd;
    private int isSt;
    private int points, maxPoints;
    private float x,y;

    public HudBar(TextureBatch batch, float x, float y, int isSt){
        this.batch = batch;
        this.x = x;
        this.y = y;
        this.isSt = isSt;
        Texture2D atlas = new Texture2D("/sprites/hud_player_bars.png");
        this.pointFull = new TextureRegion(atlas, 0, 8*isSt, 3, 8);
        this.pointHalf = new TextureRegion(atlas, 8, 8*isSt, 3, 8);
        this.pointEmpty = new TextureRegion(atlas, 16, 8*isSt, 3, 8);
        this.pointEnd = new TextureRegion(atlas, 24, 8*isSt, 1, 8);
    }

    public void update(int points, int maxPoints){
        this.points = points;
        this.maxPoints = maxPoints;
    }

    @Override
    public void draw() {
        for (int i = 0; i < maxPoints; i++) {
            if(i < points)
                batch.draw(pointFull,x+i*6,y+12,6,12);
            else
                batch.draw(pointEmpty,x+i*6,y+12,6,12);
            if(i == points)
                batch.draw(pointHalf,x+i*6,y+12,6,12);
            if(i == maxPoints-1)
                batch.draw(pointEnd,x+i*6+6,y+12,1.5f,12);
        }
    }

    @Override
    public void setPosition(Vec2f position) {
        this.x = position.x - Jpize.getWidth() / 8f + 64;
        this.y = position.y + Jpize.getHeight() / 8f - 12 - 12 - 12*isSt;
    }
}
