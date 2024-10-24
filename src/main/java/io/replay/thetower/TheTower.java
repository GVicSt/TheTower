package io.replay.thetower;

import jpize.app.Jpize;

public class TheTower {

    public static void main( String[] args ) {
        Jpize.create("The Tower", 1920, 1080).build().setApp(new MainClass());
        Jpize.window().setFullscreen();
        Jpize.run();
    }
}
