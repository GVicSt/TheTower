package io.replay.thetower.screens;

import io.replay.thetower.MainClass;
import io.replay.thetower.elements.Button;
import io.replay.thetower.elements.Fade;
import io.replay.thetower.elements.Sprite;
import io.replay.thetower.elements.IScreen;
import jpize.app.Jpize;
import jpize.audio.al.fx.AlEffectSlot;
import jpize.audio.al.fx.effects.AleReverb;
import jpize.gl.Gl;
import jpize.util.font.Charset;
import jpize.util.font.FontLoader;
import jpize.util.font.Font;
import jpize.util.mesh.TextureBatch;

public class Menu extends IScreen {

    private MainClass main;
    private TextureBatch batch = new TextureBatch();

    private final Fade fade = new Fade();
    private Font font = FontLoader.loadTrueType("/fonts/square_pixel.ttf", 80, Charset.DEFAULT_ENG_RUS ,false);
    private final Sprite background = new Sprite(batch, 0, 0, 1920, 1080, "/sprites/menu_background.png", true);
    private final Sprite replay_logo = new Sprite(batch, 1687, 51, 186, 70, "/sprites/replay_logo_small.png", true);

    private final Button play = new Button(batch, font, 704, 240, 512, 64, "/buttons/play", "новая игра", true);
    private final Button options = new Button(batch, font, 704, 170, 512, 64, "/buttons/play", "настройки", true);
    private final Button exit = new Button(batch, font, 832, 100, 256, 64, "/buttons/play", "выход", true);

    private AleReverb reverb = new AleReverb();
    private AlEffectSlot effectSlotReverb = new AlEffectSlot();

    public Menu(MainClass main) {
        super("Menu");
        System.out.println("[LOA] Menu");

        this.main = main;
        this.batch.setColor(0f,0f,0f,1f);
        this.font.getRenderOptions().color().set(0f,0f,0f,1f);
    }

    @Override
    public void init() {
        reverb.setDensity(16f);
        reverb.setDiffusion(0.1f);
        reverb.setDecayTime(0.3f);
        reverb.setLateReverbDelay(0.3f);
        effectSlotReverb.setEffect(reverb);
        main.audioManager.getMusic("bg_menu_0").alSound().setLooping(true).play();
    }

    @Override
    public void update() {
        fade.in(batch, font, 0.2f);
        if(play.isReleased()){
            main.audioManager.getMusic("bg_menu_0").alSound().stop();
            fade.reset();
            main.screenManager.show("LoadingGame");
        }
        if(options.isReleased())
            main.audioManager.getMusic("bg_menu_0").alSound().setGain(0.5f).setAuxSendFilter(effectSlotReverb, 4, null);
            //main.screenManager.show("Options");
        if(exit.isReleased())
            Jpize.exit();
    }

    @Override
    public void render() {
        Gl.clearColorBuffer();
        batch.setup();
        background.render();
        replay_logo.render();
        play.render();
        options.render();
        exit.render();
        batch.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
