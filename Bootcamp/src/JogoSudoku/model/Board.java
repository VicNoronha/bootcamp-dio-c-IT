package JogoSudoku.model;

import java.util.Collection;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {

    // Representa o tabuleiro 9x9 do Sudoku
    private final List<List<Space>> spaces;

    public Board(final List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    // Retorna o tabuleiro completo
    public List<List<Space>> getSpaces() {
        return spaces;
    }


    public GameStatus getStatus() {

        // Verifica se o jogo ainda não foi iniciado
        // Nenhum espaço não-fixo possui valor preenchido
        boolean noneStarted = spaces.stream()
                .flatMap(Collection::stream)
                .noneMatch(space ->
                        !space.isFixed() && nonNull(space.getActual())
                );

        if (noneStarted) {
            return GameStatus.NON_STARTED;
        }

        // Verifica se ainda existem espaços vazios
        boolean hasEmptySpaces = spaces.stream()
                .flatMap(Collection::stream)
                .anyMatch(space -> isNull(space.getActual()));

        // Se não houver espaços vazios → jogo completo
        return hasEmptySpaces
                ? GameStatus.INCOMPLETE
                : GameStatus.COMPLETE;
    }

    // ================== VALIDAÇÕES ==================

    public boolean hasErrors() {

        // Um jogo não iniciado não possui erros
        if (getStatus() == GameStatus.NON_STARTED) {
            return false;
        }

        // Verifica se algum valor atual difere do esperado
        return spaces.stream()
                .flatMap(Collection::stream)
                .anyMatch(space ->
                        nonNull(space.getActual()) &&
                                !space.getActual().equals(space.getExpected())
                );
    }



    public boolean changeValue(final int col, final int row, final Integer value) {
        Space space = spaces.get(row).get(col);

        // Não permite alteração em espaços fixos
        if (space.isFixed()) {
            return false;
        }

        space.setActual(value);
        return true;
    }

    public boolean clearValue(final int col, final int row) {
        Space space = spaces.get(row).get(col);

        // Não permite limpeza de espaços fixos
        if (space.isFixed()) {
            return false;
        }

        space.clearSpace();
        return true;
    }

    // Limpa todos os espaços não fixos
    public void reset() {
        spaces.forEach(row ->
                row.forEach(space -> {
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


