package designPatterns.visitor.sample.midi;

public interface Synthesizer {
    void tone(int noteNumber,
              int duration,
              int velocity);
}