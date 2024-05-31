package dev.sudip.models;

import dev.sudip.components.Decision;
import dev.sudip.components.Playable;

import java.util.Vector;

public class Grudger implements Playable {
    private boolean holdGrudge = false;

    public Grudger() {
        holdGrudge = false;
    }

    @Override
    public Decision playFirstMove(Vector<Decision.UnitRoundRes> gameHistory) {
        if (holdGrudge) {
            // once we hold grudge
            // we never let go
            return Decision.Sniff;
        } else {
            try {
                if (gameHistory.lastElement().playerTwoMove == Decision.Cooperate) {
                    return Decision.Cooperate;
                } else {
                    holdGrudge = true;
                    return Decision.Sniff;
                }
            } catch (java.util.NoSuchElementException _e) {
                return Decision.Cooperate;
            }
        }
    }

    @Override
    public Decision playSecondMove(Vector<Decision.UnitRoundRes> gameHistory, Decision playerOneMove) {
        if (!holdGrudge && playerOneMove == Decision.Cooperate) {
            return Decision.Cooperate;
        } else {
            this.holdGrudge = true;
            return Decision.Sniff;
        }
    }
}
