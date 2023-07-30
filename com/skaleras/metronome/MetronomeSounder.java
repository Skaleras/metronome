package com.skaleras.metronome;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MetronomeSounder {
    public static void main(String[] args) {
        String fileName = "/home/skaleras/Desktop/code/projects/metronome/src/com/skaleras/metronome/resources/drum1.wav";
        play(fileName);
    }

    public static void play(String fileName) {
        try {
            File musicFile = new File(fileName);
            if(musicFile.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else
                System.out.println("Can't find file");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}