package advent.day02;

public class Strategy2 implements Strategy {
    private final char LOOSE = 'X';
    private final char DRAW  = 'Y';
    private final char WIN   = 'Z';

    public int getPoints(String row) {
        String[] input = row.split(" ");
        Selection opponentSelection = null;
        Selection selection = null;
        for (Selection s: Selection.values()) {
            if (input[0].equals(s.opponentSymbol)) {
                opponentSelection = s;
            }
        }
        switch (input[1].charAt(0)) {
            case LOOSE:
                selection = opponentSelection.getWinsOver();
                break;
            case DRAW:
                selection = opponentSelection;
                break;
            case WIN:
                selection = opponentSelection.getLoosesOver();
                break;
            default:
                System.err.println("Invalid input, second word should be one of X,Y,Z!");
        }
        return getPoints(opponentSelection, selection);
    }

}
