package dev.sudip.components;

import org.javatuples.Pair;

// What was the result after both player make move in this round
public enum MoveResult {
    BothCooperate,
    BothSniff,
    ISniff,
    TheySniff,
    _Unreachable;

    public static MoveResult init(Decision myMove, Decision otherMove) {
        if (myMove == Decision.Cooperate && otherMove == Decision.Cooperate) {
            return BothCooperate;
        } else if (myMove == Decision.Cooperate && otherMove == Decision.Sniff) {
            return TheySniff;
        } else if (myMove == Decision.Sniff && otherMove == Decision.Cooperate) {
            return ISniff;
        } else if (myMove == Decision.Sniff && otherMove == Decision.Sniff) {
            return BothSniff;
        } else {
            // should never be reachable
            return _Unreachable;
        }
    }

    public Pair<Integer, Integer> getPoints() {
        switch (this) {
            case BothCooperate -> {
                return new Pair<Integer, Integer>(3, 3);
            }
            case BothSniff -> {
                return new Pair<Integer, Integer>(1, 1);
            }
            case ISniff -> {
                return new Pair<Integer, Integer>(5, 0);
            }
            case TheySniff -> {
                return new Pair<Integer, Integer>(0, 5);
            }
        }
        return new Pair<>(0, 0);
    }
}
