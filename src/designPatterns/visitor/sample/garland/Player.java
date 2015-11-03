package designPatterns.visitor.sample.garland;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.element.Led;
import designPatterns.visitor.sample.music.Music;

// а это хоть и визитор, но цель у него другая немного
// он музыку играет
public class Player implements Music {

    // светодиоды загораются в консоли буковками
    @Override
    public void affect(Led led) {
        switch (led.getColor()) {
            case RED:    System.out.print('R'); break;
            case GREEN:  System.out.print('G'); break;
            case BLUE:   System.out.print('B'); break;
            case YELLOW: System.out.print('Y'); break;
        }
    }

    // звоночек звучит
    @Override
    public void affect(Bell bell) {
        bell.beep();
        System.out.print('!');
    }

    // лазеры либо светят '+' либо нет '-'
    @Override
    public void affect(Laser laser) {
        if (laser.isOn()) {
            System.out.print('+');
        } else {
            System.out.print('-');
        }
    }
}