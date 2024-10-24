package io.replay.thetower.managers;

import io.replay.thetower.elements.Sound;

public class AudioManager {

    private Sound[] sounds;

    public AudioManager(){
        sounds = new Sound[3];
        sounds[0] = new Sound("hit01", 1);
        sounds[1] = new Sound("music-menu", 1, 1);
        sounds[2] = new Sound("music-game", 1, 1);
    }

    public Sound getSound(int id) {
        return sounds[id];
    }
}
