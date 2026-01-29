package JogoSudoku.util;

import JogoSudoku.model.Board;
import JogoSudoku.model.Space;

import java.util.ArrayList;
import java.util.List;


public class BoardTemplate {

    private static final int SIZE = 9;

    /**
     * Cria um tabuleiro padrão de Sudoku.
     *
     * @return Board inicializado
     */
    public static Board createDefaultBoard() {

        List<List<Space>> spaces = new ArrayList<>();

        // Template base (0 = espaço vazio)
        int[][] template = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        for (int row = 0; row < SIZE; row++) {
            spaces.add(new ArrayList<>());

            for (int col = 0; col < SIZE; col++) {
                int value = template[row][col];

                if (value == 0) {
                    // Espaço vazio (não fixo)
                    spaces.get(row).add(new Space(null, false));
                } else {
                    // Espaço fixo
                    spaces.get(row).add(new Space(value, true));
                }
            }
        }

        return new Board(spaces);
    }
}

