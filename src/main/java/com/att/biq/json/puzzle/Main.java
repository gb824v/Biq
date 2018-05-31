/*
package com.att.biq.json.puzzle;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String puzlleAsJsonString = "{\n" +
                "\t\"puzzle\": {\n" +
                "\t\t\"rotate\": true,\n" +
                "\t\t\"pieces\": [{\n" +
                "\t\t\t\"id\": 1,\n" +
                "\t\t\t\"piece\": [0,0,0,0]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 2,\n" +
                "\t\t\t\"piece\": [0,1,-1,0]\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";

        Gson gson = new Gson();

        List<pukteam.poc.gson.puzzle.Piece> pieces = new ArrayList<>();
        pieces.add(new pukteam.poc.gson.puzzle.Piece(1, new int[] {0,0,0,0}));
        pieces.add(new pukteam.poc.gson.puzzle.Piece(2, new int[] {0,1,-1,0}));
        Puzzle puzzle = new Puzzle(new pukteam.poc.gson.puzzle.PuzzleDefinition(true, pieces));
        //Puzzle puzzle = gson.fromJson(puzlleAsJsonString, Puzzle.class);
        String s = gson.toJson(puzzle);

        Puzzle puzzle1 = gson.fromJson(puzlleAsJsonString, Puzzle.class);
        System.out.println("from json: " + puzzle1);
        System.out.println("to string: " + puzzle);

        System.out.println("From object to string: " + s);
    }
}
*/
