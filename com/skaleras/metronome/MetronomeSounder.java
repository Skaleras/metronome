package com.skaleras.metronome;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;


// bookmarked five step process in head first java book
public class MetronomeSounder  {
    
    public void play() {
        try {
            //1
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            //2
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            //3
            Track track = seq.createTrack();

            //4
            //a.setMessage(messageType, channel, noteToPlay, velocity)

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 40, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 40, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            //5
            player.setSequence(seq);
            player.start();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MetronomeSounder metronomeSounder = new MetronomeSounder();
            metronomeSounder.play();
    }
}
