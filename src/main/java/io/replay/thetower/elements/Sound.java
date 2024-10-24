package io.replay.thetower.elements;

import jpize.audio.util.AlSound;

public class Sound {

    private AlSound audio;

    public Sound(String sound_name, float gain){
        this.audio = new AlSound("/sounds/"+sound_name+".wav");
        this.audio.setGain(gain);
    }

    public Sound(String music_name, float gain, float len){
        this.audio = new AlSound("/sounds/"+music_name+".mp3");
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
