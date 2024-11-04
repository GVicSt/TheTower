package io.replay.thetower.screens;

import io.replay.thetower.MainClass;
import io.replay.thetower.elements.*;
import jpize.gl.Gl;
import jpize.gl.texture.TextureBatch;

public class Game extends IScreen {

    private MainClass main;
    private TextureBatch batch = new TextureBatch(65535);
    private Floor floor = new Floor();
    private Player player;
    private final Fade fade = new Fade();

    public Game(MainClass main) {
        super("Game");
        System.out.println("[LOA] Game");

        this.main = main;
        this.batch.setColor(0f,0f,0f,1f);
    }

    @Override
    public void init() {
        main.audioManager.getMusic("bg_game_0").alSound().setLooping(true).play();
    }

    @Override
    public void load(){
        player = new Player(batch, main);
        floor.setID(0);
        floor.load();
        System.out.println("[DEB] Level loaded");
        setLoaded(true);
    }

    @Override
    public void update() {
        player.update();
        fade.in(batch, 1f);
    }

    @Override
    public void render() {
        Gl.clearColorBuffer();
        floor.render(batch, player.getCamera());
        player.render();
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
