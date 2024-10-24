package io.replay.thetower.screens;

import io.replay.thetower.MainClass;
import io.replay.thetower.elements.Fade;
import io.replay.thetower.elements.Player;
import io.replay.thetower.managers.IScreen;
import io.replay.thetower.managers.LevelManager;
import jpize.app.Jpize;
import jpize.gl.Gl;
import jpize.gl.texture.TextureBatch;
import jpize.glfw.input.Key;
import jpize.util.font.Charset;
import jpize.util.font.Font;
import jpize.util.font.FontLoader;

public class Game extends IScreen {

    private MainClass main;
    private TextureBatch batch = new TextureBatch();
    private LevelManager levelManager = new LevelManager();
    private Font font = FontLoader.loadTrueType("/fonts/square_pixel.ttf", 80, Charset.DEFAULT_ENG_RUS, false);
    private Player player;
    private final Fade fade = new Fade();
    // private Bloom bloom = new Bloom(0.8f, 100f);

    public Game(MainClass main) {
        super("Game");
        System.out.println("[LOA] Game");

        this.main = main;
        this.batch.setColor(0f,0f,0f,1f);
    }

    @Override
    public void init() {
        main.audioManager.getSound(2).alSound().setLooping(true).play();
    }

    @Override
    public void load(){
        player = new Player(batch);
        levelManager.setLevel(0);
        System.out.println("[DEB] Level loaded");
        setLoaded(true);
    }

    @Override
    public void update() {
        player.update(main);
        if (Key.ESCAPE.up())
            main.screenManager.show("LoadingGameMenu");
        fade.in(batch, 1f);
    }

    @Override
    public void render() {
        Gl.clearColorBuffer();
        levelManager.getFloor().render(batch, player.getCamera());
        player.render();

        // loom.begin();
        // ex.drawO_;
        // atch.render();
        // loom.end();

        font.drawText("FPS: "+Jpize.getFPS(),10,10);

        batch.render();
    }

    @Override
    public void resize(int width, int height) {
        player.cam.resize(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
