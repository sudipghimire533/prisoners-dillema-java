package dev.sudip.components;

// A decision layer can decide for a single move
public enum Decision {
    Cooperate,
    Sniff;


    // One round result
    public static class UnitRoundRes {
        public Decision playerOneMove;
        public Decision playerTwoMove;

        public UnitRoundRes(Decision playerOne, Decision playerTwo) {
            this.playerOneMove = playerOne;
            this.playerTwoMove = playerTwo;
        }
    }
}
