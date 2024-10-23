package io.replay.thetower;

import io.replay.thetower.managers.ScreenManager;
import jpize.app.JpizeApplication;

public class Main extends JpizeApplication {

    public ScreenManager screenManager = new ScreenManager(this);

    public Main(){
        screenManager.set("LoadingMenu");
    }
}
