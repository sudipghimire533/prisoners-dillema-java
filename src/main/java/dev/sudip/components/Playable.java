package dev.sudip.components;

import dev.sudip.components.Decision.UnitRoundRes;

import java.util.Vector;

public interface Playable {
    public Decision playFirstMove(Vector<UnitRoundRes> gameHistory);

    public Decision playSecondMove(Vector<UnitRoundRes> gameHistory, Decision playerOneMove);
}
