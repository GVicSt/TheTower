package io.replay.thetower.screens;

import io.replay.thetower.MainClass;
import io.replay.thetower.elements.Fade;
import io.replay.thetower.elements.Sprite;
import jpize.app.JpizeApplication;
import jpize.gl.Gl;
import jpize.util.mesh.TextureBatch;

public class VNovel extends JpizeApplication {

    private MainClass main;
    private TextureBatch batch = new TextureBatch();

    private final Fade fade = new Fade();
    private final Sprite background = new Sprite(batch, 0, 0, 1920, 1080, "/sprites/menu_background.png", true);

    public VNovel(MainClass main) {
        System.out.println("[LOA] VNovel");

        this.main = main;
        this.batch.setColor(0f,0f,0f,1f);
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
    public void dispose() {
        batch.dispose();
    }

}
