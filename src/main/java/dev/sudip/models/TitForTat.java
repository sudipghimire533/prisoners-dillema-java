package dev.sudip.models;

import dev.sudip.components.Decision;
import dev.sudip.components.Playable;

import java.util.Vector;

public class TitForTat implements Playable {
    @Override
    public Decision playFirstMove(Vector<Decision.UnitRoundRes> gameHistory) {
        // Always start by cooperating
        return Decision.Cooperate;
    }

    @Override
    public Decision playSecondMove(Vector<Decision.UnitRoundRes> gameHistory, Decision playerOneMove) {
        // Tit for Tat:
        // i.e. return back what opponent had done
        return playerOneMove;
    }
}
