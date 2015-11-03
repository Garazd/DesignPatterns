package designPatterns.visitor.sample.midi;

import javax.sound.midi.MidiChannel;

public interface MidiChannelFactory {
    MidiChannel get();
}