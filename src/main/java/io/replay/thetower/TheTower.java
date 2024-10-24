package io.replay.thetower;

import jpize.app.Jpize;
import jpize.glfw.Glfw;
import jpize.glfw.init.GlfwPlatform;

public class TheTower {

    public static void main( String[] args ) {
        if(System.getProperty("os.name").equals("Linux"))
            Glfw.glfwInitHintPlatform(GlfwPlatform.X11); // fix for wayland users

        Jpize.create("The Tower", 1920, 1080).build().setApp(new MainClass());
        Jpize.run();
    }

}
