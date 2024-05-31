package dev.sudip;

import dev.sudip.components.Decision.UnitRoundRes;
import dev.sudip.components.MoveResult;
import dev.sudip.components.Playable;
import org.javatuples.Pair;

import java.util.Vector;

class Game<PlayerOne extends Playable, PlayerTwo extends Playable> {
    private final PlayerOne playerOne;
    private final PlayerTwo playerTwo;
    public Vector<UnitRoundRes> moves = new Vector<UnitRoundRes>();
    private int ongoingRound = 0;
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    public Game(PlayerOne playerOne, PlayerTwo playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void playNextMove() {
        ongoingRound += 1;

        var playerOneDecision = this.playerOne.playFirstMove(this.moves);
        var playerTwoDecision = this.playerTwo.playSecondMove(this.moves, playerOneDecision);

        var roundRes = new UnitRoundRes(playerOneDecision, playerTwoDecision);
        moves.add(roundRes);

        var points = MoveResult.init(roundRes.playerOneMove, roundRes.playerTwoMove).getPoints();
        playerOnePoints += points.getValue0();
        playerTwoPoints += points.getValue1();
    }

    public Pair<Integer, Integer> points() {
        return new Pair<Integer, Integer>(playerOnePoints, playerTwoPoints);
    }
}

