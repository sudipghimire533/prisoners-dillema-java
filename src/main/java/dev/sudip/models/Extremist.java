package dev.sudip.models;

import dev.sudip.components.Decision;
import dev.sudip.components.Playable;

import java.util.Vector;

public class Extremist {
    public static class AlwaysSniff implements Playable {
        @Override
        public Decision playFirstMove(Vector<Decision.UnitRoundRes> gameHistory) {
            return Decision.Sniff;
        }

        @Override
        public Decision playSecondMove(Vector<Decision.UnitRoundRes> gameHistory, Decision playerOneMove) {
            return Decision.Sniff;
        }
    }

    public static class AlwaysCooperate implements Playable {
        @Override
        public Decision playFirstMove(Vector<Decision.UnitRoundRes> gameHistory) {
            return Decision.Cooperate;
        }

        @Override
        public Decision playSecondMove(Vector<Decision.UnitRoundRes> gameHistory, Decision playerOneMove) {
            return Decision.Cooperate;
        }
    }
}
