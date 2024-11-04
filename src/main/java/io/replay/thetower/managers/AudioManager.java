package io.replay.thetower.managers;

import io.replay.thetower.elements.Sound;
import io.replay.thetower.elements.Tile;

public class AudioManager {

    private final Audio[] sounds;
    private final Audio[] music;

    static class Audio {
        String id;
        Sound audio;

        public Audio(String id, Sound audio){
            this.id = id;
            this.audio = audio;
        }
    }

    public AudioManager(){
        this.sounds = new Audio[]{
            new Audio("player_hit_0", new Sound("player_hit_0","wav",1f)),
            new Audio("menu_loaded_0", new Sound("menu_loaded_0","wav",1f)),
        };
        this.music = new Audio[]{
            new Audio("bg_menu_0", new Sound("bg_menu_0","mp3", 1f, 1f)),
            new Audio("bg_game_0", new Sound("bg_game_0","mp3", 1f, 1f)),
        };
    }

    public Sound getSound(String id){
        for (Audio sound_curr : sounds)
            if (sound_curr.id.equals(id))
                return sound_curr.audio;
        return null;
    }

    public Sound getMusic(String id){
        for (Audio music_curr : music)
            if (music_curr.id.equals(id))
                return music_curr.audio;
        return null;
    }

}
