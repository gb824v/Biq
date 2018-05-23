package pukteam.poc.gson.puzzle;

public class Puzzle {
    private PuzzleDefinition puzzle;

    public Puzzle(PuzzleDefinition puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "puzzle=" + puzzle +
                '}';
    }
}
