package io.replay.thetower.elements;

import jpize.gl.texture.Texture2D;
import jpize.util.Disposable;

public class Tile implements Disposable {

    private Texture2D texture;
    private int width;
    private int height;

    public Tile(String tex_path){
        this.texture = new Texture2D(tex_path);
        this.width = texture.getWidth();
        this.height = texture.getHeight();
    }

    public Texture2D getTexture2D() {
        return texture;
    }

    public int getTileSizeX() {
        return width;
    }

    public int getTileSizeY() {
        return height;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
