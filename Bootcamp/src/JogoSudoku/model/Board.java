package JogoSudoku.model;

import java.util.Collection;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {

    private final List<List<Space>> spaces;

    public Board(final List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatus getStatus() {

        // Nenhum espaço preenchido (exceto os fixos)
        boolean noneStarted = spaces.stream()
                .flatMap(Collection::stream)
                .noneMatch(s -> !s.isFixed() && nonNull(s.getActual()));

        if (noneStarted) {
            return GameStatus.NON_STARTED;
        }

        // Se ainda existe algum espaço vazio → jogo incompleto
        boolean hasEmptySpaces = spaces.stream()
                .flatMap(Collection::stream)
                .anyMatch(s -> isNull(s.getActual()));

        return hasEmptySpaces ? GameStatus.INCOMPLETE : GameStatus.COMPLETE;
    }

    public boolean hasErrors() {
        if (getStatus() == GameStatus.NON_STARTED) {
            return false;
        }

        return spaces.stream()
                .flatMap(Collection::stream)
                .anyMatch(s ->
                        nonNull(s.getActual()) &&
                                !s.getActual().equals(s.getExpected()));
    }

    public boolean changeValue(final int col, final int row, final Integer value) {
        Space space = spaces.get(row).get(col);

        if (space.isFixed()) {
            return false;
        }

        space.setActual(value);
        return true;
    }

    public boolean clearValue(final int col, final int row) {
        Space space = spaces.get(row).get(col);

        if (space.isFixed()) {
            return false;
        }

        space.clearSpace();
        return true;
    }

    public void reset() {
        spaces.forEach(col ->
                col.forEach(space -> {
                    if (!space.isFixed()) {
                        space.clearSpace();
                    }
                })
        );
    }

    public boolean gameIsFinished() {
        return !hasErrors() && getStatus() == GameStatus.COMPLETE;
    }
}

