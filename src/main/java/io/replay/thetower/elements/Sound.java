package io.replay.thetower.elements;

import jpize.audio.Audio;
import jpize.audio.util.AlSound;

import javax.sound.sampled.spi.AudioFileReader;

public class Sound {

    private AlSound audio;

    public Sound(String sound_name, float gain){
        audio = new AlSound("/sounds/"+sound_name+".wav");
        audio.setGain(gain);
    }

    public Sound(String music_name, float gain, float len){
        audio = new AlSound("/sounds/"+music_name+".mp3");
        audio.setGain(gain);
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
