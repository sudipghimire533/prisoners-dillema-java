package dev.sudip;

import dev.sudip.components.Playable;
import dev.sudip.models.Extremist;
import dev.sudip.models.Grudger;
import dev.sudip.models.TitForTat;

class GameConfig {
    private final int rounds;

    GameConfig(int rounds) {
        this.rounds = Math.max(rounds, 1);
    }

    public <P1 extends Playable, P2 extends Playable> Game<P1, P2> simulate(P1 playerOne, P2 playerTwo) {
        var game = new Game<P1, P2>(playerOne, playerTwo);
        for (int i = 0; i < rounds; i++) {
            game.playNextMove();
        }
        return game;
    }
}

public class Main {
    public static void main(String[] args) {
        var titTat = new TitForTat();
        var grudger = new Grudger();
        var alwaysCooperate = new Extremist.AlwaysCooperate();
        var alwaysDefect = new Extremist.AlwaysSniff();

        var config = new GameConfig(10);
        System.out.println("Config: " + config);
        var defect_cooperate = config.simulate(alwaysDefect, alwaysCooperate);
        var grudger_defect = config.simulate(grudger, alwaysDefect);
        var grudger_cooperate = config.simulate(grudger, alwaysCooperate);
        var tit_grudger = config.simulate(titTat, grudger);

        System.out.println("Always Defect v/s Always Cooperate. Points: " + defect_cooperate.points());
        System.out.println("Grudger v/s Always Defect. Points:  " + grudger_defect.points());
        System.out.println("Grudger v/s Always Cooperate. Points:  " + grudger_cooperate.points());
        System.out.println("TitForTat v/s Grudger. Points: " + tit_grudger.points());
    }
}