package designPatterns.visitor.sample.midi;

import javax.sound.midi.*;
import javax.sound.midi.Synthesizer;

public class RealMidiChannelFactory implements MidiChannelFactory {

    @Override
    public MidiChannel get() {
        try {
            // init sequencer
            Sequencer sequencer = null;
            sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // init synthesizer
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();

            // get channel for synthesizing: the highest numbered channel.  sets it up
            MidiChannel[] channels = synth.getChannels();
            MidiChannel midi = channels[channels.length - 1];

            // тут у нас меняется инструмент
            // детальнее смотри http://wikipedia.org/wiki/General_MIDI
            int instrument = 124;

            midi.programChange(instrument - 1);

            midi.noteOn(0, 10);
            sleep();
            midi.noteOff(0);
            return midi;
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}