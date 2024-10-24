package io.replay.thetower.screens;

import io.replay.thetower.MainClass;
import io.replay.thetower.elements.Button;
import io.replay.thetower.elements.Fade;
import io.replay.thetower.elements.Sprite;
import jpize.app.Jpize;
import jpize.app.JpizeApplication;
import jpize.gl.Gl;
import jpize.gl.texture.TextureBatch;

public class VNovel  extends JpizeApplication {

    private MainClass main;
    private TextureBatch batch = new TextureBatch();

    private final Fade fade = new Fade();
    private final Sprite background = new Sprite(batch, 0, 0, 1920, 1080, "/sprites/menu_background.png");

    public VNovel(MainClass main) {
        this.main = main;
        System.out.println("[LOA] VNovel");
        Gl.clearColorBuffer();
        batch.setup();
        batch.setColor(0f,0f,0f,1f);
        batch.render();
    }
    @Override
    public void init() {
    }
    @Override
    public void update() {
        fade.in(batch, 1f);
    }
    @Override
    public void render() {
        Gl.clearColorBuffer();
        batch.setup();
        background.render();
        batch.render();
    }
    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void dispose() {
        batch.dispose();
    }
}
