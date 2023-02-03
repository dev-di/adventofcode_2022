package advent.day02;

public interface Strategy {

    public int getPoints(String row) ;

    default public int getPoints(Selection opponentSelection, Selection selection) {
        int selectionPoint = selection.getScore();
        boolean draw = opponentSelection == selection;
        boolean win = selection.winsOver(opponentSelection);
        return selectionPoint + (draw?3:0) + (win?6:0);
    }
}
