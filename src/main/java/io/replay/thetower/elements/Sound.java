package io.replay.thetower.elements;

import jpize.audio.util.AlSound;

public class Sound {

    private AlSound audio;

    public Sound(String sound_name, String extension, float gain){
        this.audio = new AlSound("/audios/sounds/"+sound_name+"."+extension);
        this.audio.setGain(gain);
    }

    public Sound(String music_name, String extension, float gain, float len){
        this.audio = new AlSound("/audios/music/"+music_name+"."+extension);
        this.audio.setGain(gain);
    }

    public void play(){
        audio.play();
    }

    public void pause(){
        audio.play();
    }

    public boolean isPlaying(){
        return audio.isPlaying();
    }

    public AlSound alSound(){
        return audio;
    }

}
