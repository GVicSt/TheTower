package io.replay.thetower;

import io.replay.thetower.managers.AudioManager;
import io.replay.thetower.managers.ScreenManager;
import io.replay.thetower.screens.Game;
import io.replay.thetower.screens.Loading;
import io.replay.thetower.screens.Menu;
import jpize.app.Jpize;
import jpize.app.JpizeApplication;
import jpize.audio.Audio;

public class MainClass extends JpizeApplication {

    public ScreenManager screenManager;
    public AudioManager audioManager;

    public MainClass(){
        Audio.init();
        Audio.openDevice();
        this.audioManager = new AudioManager();
        this.screenManager = new ScreenManager().register(
                new Loading(this,"LoadingMenu", "2Menu"),
                new Loading(this, "LoadingGame", "Menu2Game"),
                new Loading(this, "LoadingGameMenu", "Game2Menu"),
                new Menu(this),
                new Game(this)
        );
    }

    @Override
    public void init() {
        screenManager.show("LoadingMenu");
        Jpize.window().setFullscreen(true);
    }

    @Override
    public void update() {
        screenManager.update();
    }

    @Override
    public void render() {
        screenManager.render();
    }

    @Override
    public void resize(int width, int height) {
        screenManager.resize(width, height);
    }

    @Override
    public void dispose() {
        Audio.dispose();
        screenManager.dispose();
        System.out.println("[DIS] screen manager");
    }

}
