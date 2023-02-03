package advent.day02;

public class Strategy1 implements Strategy {

    public int getPoints(String row) {
        String[] selections = row.split(" ");
        Selection selection = null;
        Selection opponentSelection = null;
        for (Selection s: Selection.values()) {
            if (selections[0].equals(s.opponentSymbol)) {
                opponentSelection = s;
            }
            if (selections[1].equals(s.symbol)) {
                selection = s;
            }
        }
        return getPoints(opponentSelection, selection);
    }

}
