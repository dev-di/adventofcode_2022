package advent.day02;

public enum Selection {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    String opponentSymbol;
    String symbol;
    int score;

    Selection(String opponentSymbol, String symbol, int points) {
        this.opponentSymbol = opponentSymbol;
        this.symbol = symbol;
        this.score = points;
    }

    public boolean winsOver(Selection s) {
        return (this == ROCK && s == SCISSORS) ||
                (this == PAPER && s == ROCK) ||
                (this == SCISSORS && s == PAPER);
    }

    public Selection getLoosesOver() {
        switch (this) {
            case ROCK: return PAPER;
            case PAPER: return SCISSORS;
            default: return ROCK;
        }
    }
    public Selection getWinsOver() {
        switch (this) {
            case ROCK: return SCISSORS;
            case PAPER: return ROCK;
            default: return PAPER;
        }
    }

    public int getScore() {
        return score;
    }
}
