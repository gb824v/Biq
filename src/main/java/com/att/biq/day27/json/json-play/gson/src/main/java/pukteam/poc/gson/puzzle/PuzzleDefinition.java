package pukteam.poc.gson.puzzle;

import java.util.Collection;

public class PuzzleDefinition {
    private boolean rotate;
    Collection<Piece> pieces;

    public PuzzleDefinition(boolean rotate, Collection<Piece> pieces) {
        this.rotate = rotate;
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "PuzzleDefinition{" +
                "rotate=" + rotate +
                ", pieces=" + pieces +
                '}';
    }
}
