package com.skaleras.metronome;
import java.util.Scanner;

public class Metronome{
    private double bpm;
    private int beatsPerMeasure;
    static final double MILISECONDS_PER_SECOND = 1000.0;
    static final double SECONDS_PER_MINUTE = 60.0;

    public Metronome(double bpm, int beatsPerMeasure) {
        this.bpm = bpm;
        this.beatsPerMeasure = beatsPerMeasure;
    }

    public Metronome() {
        this.bpm = 0.0;
        this.beatsPerMeasure = 4;
    }

    public double getBpm() {
        return bpm;
    }

    public void setBpm(double newBpm) {
        this.bpm = newBpm;
    }

    public int getBeatsPerMeasure() {
        return beatsPerMeasure;
    }

    public void setBeatsPerMeasure(int newBeatsPerMeasure) {
        this.beatsPerMeasure = newBeatsPerMeasure;
    }

    public void setUpMetronomeThread() {
        try {
            Thread.sleep((long)(MILISECONDS_PER_SECOND*(SECONDS_PER_MINUTE/bpm)));
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setMetronomeTiming() {
        System.out.println("Enter the number of beats per minute (bpm) and then beats per measure");
        System.out.println();
        Scanner scannerBpm = new Scanner(System.in);
        Scanner scannerBeatsPerMeasure = new Scanner(System.in);
        setBpm(scannerBpm.nextDouble());
        setBeatsPerMeasure(scannerBeatsPerMeasure.nextInt());
        scannerBpm.close();
        scannerBeatsPerMeasure.close();
    }

    public void start() {
        for(int counter=1;true;counter++){
            setUpMetronomeThread();
            if(counter%beatsPerMeasure!=0)
                System.out.println("Tick");
            else{
                System.out.println("TOCK");
                System.out.println("----");
            }
        }
    }
}

class MetronomeTest{
    public static void main(String[] args) {
        Metronome metronome = new Metronome();
        metronome.setMetronomeTiming();
        metronome.start();
    }
}