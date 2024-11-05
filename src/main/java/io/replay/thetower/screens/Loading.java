package io.replay.thetower.screens;

import io.replay.thetower.MainClass;
import io.replay.thetower.elements.AtlasAnimation;
import io.replay.thetower.elements.Fade;
import io.replay.thetower.elements.Sprite;
import io.replay.thetower.elements.IScreen;
import jpize.app.Jpize;
import jpize.gl.Gl;
import jpize.util.mesh.TextureBatch;

public class Loading extends IScreen {

    private MainClass main;
    private TextureBatch batch = new TextureBatch();

    private String go_to;
    private boolean isLoaded;
    private float timer = -0.5f;
    private final Fade fadei = new Fade();
    private final Fade fadeo = new Fade();
    private AtlasAnimation loading_indicator = new AtlasAnimation(batch, 1756, 50, 48, 48, 64, 64, "loading_buble", 6, 1, true);
    private final Sprite replay_logo = new Sprite(batch, 588, 404, 744, 280, "/sprites/replay_logo.png", true);

    public Loading(MainClass main, String id, String go_to) {
        super(id);
        this.main = main;
        this.go_to = go_to;
        if(go_to.equals("2Menu"))
            timer = -4f;
        System.out.println("[LOA] Loading screen to " + go_to);
    }

    @Override
    public void update(){
        fadei.in(batch, 1f);
        if(!isLoaded) {
            if (go_to.equals("Menu2Game"))
                if (!main.screenManager.getScreens().get("Game").isLoaded()) {
                    main.screenManager.getScreens().get("Game").load();
                }else{
                    isLoaded = true;
                }
            if (go_to.equals("Game2Menu"))
                isLoaded = true;

            if (go_to.equals("2Menu"))
                isLoaded = true;
        }else{
            timer += Jpize.getDT();
            if(timer>0&&fadeo.out(batch, 3f)){

                if(go_to.equals("2Menu"))
                    main.audioManager.getSound("menu_loaded_0").alSound().play();

                timer = -1f;
                fadei.reset();
                fadeo.reset();

                System.out.println("[SCR] Setting "+go_to+" screen");

                if (go_to.equals("2Menu"))
                    main.screenManager.show("Menu");
                if (go_to.equals("Menu2Game"))
                    main.screenManager.show("Game");
                if (go_to.equals("Game2Menu"))
                    main.screenManager.show("Menu");
            }
        }
    }

    @Override
    public void render(){
        Gl.clearColorBuffer();
        batch.setup();
        if(!(go_to.equals("Game2Menu") || go_to.equals("Menu2Game")))
            replay_logo.render();
        loading_indicator.render();
        batch.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose(){
        loading_indicator.dispose();
        batch.dispose();
    }

}
