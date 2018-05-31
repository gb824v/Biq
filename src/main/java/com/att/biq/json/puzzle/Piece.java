package com.att.biq.json.puzzle;
import java.util.Arrays;

public class Piece {
    private int id;
    private int[] piece;

    public Piece(int id, int[] piece) {
        this.id = id;
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "id=" + id +
                ", piece=" + Arrays.toString(piece) +
                '}';
    }
}
