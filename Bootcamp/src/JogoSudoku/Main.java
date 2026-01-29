package JogoSudoku;

import JogoSudoku.model.Board;
import JogoSudoku.model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Board board;
    private static final int BOARD_LIMIT = 9;

    public static void main(String[] args) {

        final Map<String, String> positions = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));

        int option;

        while (true) {
            System.out.println("\nSelecione uma das opções:");
            System.out.println("1 - Iniciar um novo jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }
    }

    // MENU

    private static void startGame(final Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("O jogo já foi iniciado");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();

        for (int row = 0; row < BOARD_LIMIT; row++) {
            spaces.add(new ArrayList<>());

            for (int col = 0; col < BOARD_LIMIT; col++) {
                var positionConfig = positions.get("%s,%s".formatted(row, col));

                if (positionConfig == null) {
                    spaces.get(row).add(new Space(null, false));
                    continue;
                }

                var parts = positionConfig.split(",");
                var expected = Integer.parseInt(parts[0]);
                var fixed = Boolean.parseBoolean(parts[1]);

                spaces.get(row).add(new Space(expected, fixed));
            }
        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto para começar!");
    }

    private static void inputNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.print("Informe a coluna (0 a 8): ");
        var col = runUntilGetValidNumber(0, 8);

        System.out.print("Informe a linha (0 a 8): ");
        var row = runUntilGetValidNumber(0, 8);

        System.out.print("Informe o valor (1 a 9): ");
        var value = runUntilGetValidNumber(1, 9);

        if (!board.changeValue(col, row, value)) {
            System.out.println("Essa posição possui um valor fixo");
        }
    }

    private static void removeNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.print("Informe a coluna (0 a 8): ");
        var col = runUntilGetValidNumber(0, 8);

        System.out.print("Informe a linha (0 a 8): ");
        var row = runUntilGetValidNumber(0, 8);

        if (!board.clearValue(col, row)) {
            System.out.println("Essa posição possui um valor fixo");
        }
    }

    private static void showCurrentGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.println("\nSeu jogo encontra-se da seguinte forma:\n");

        for (int row = 0; row < BOARD_LIMIT; row++) {

            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }

            for (int col = 0; col < BOARD_LIMIT; col++) {

                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }

                Integer value = board.getSpaces().get(row).get(col).getActual();
                System.out.print(value == null ? ". " : value + " ");
            }
            System.out.println();
        }
    }


    private static void showGameStatus() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.printf("Status do jogo: " + board.getStatus().getLabel());
        if(board.hasErrors()){
            System.out.println("O jogo contém erros");
        } else {
            System.out.println("O jogo não contém erros ");
        }
    }

    private static void clearGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.println("Tem certeza que deseja limpar o jogo? ");
        var confirm = scanner.next();
        while (!confirm.equalsIgnoreCase("sim")||confirm.equalsIgnoreCase("não")){
            System.out.println("Informe 'sim' ou 'não' ");
            confirm =scanner.next();
        }
        if(confirm.equalsIgnoreCase("sim")){
            board.reset();
        }
    }

    private static void finishGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        if (board.gameIsFinished()) {
            System.out.println("Parabéns! Você finalizou o Sudoku corretamente 🎉");
        } else {
            System.out.println("O jogo ainda possui erros ou espaços vazios");
        }
    }


    private static int runUntilGetValidNumber(final int min, final int max) {
        int current = scanner.nextInt();

        while (current < min || current > max) {
            System.out.printf("Informe um número entre %d e %d: ", min, max);
            current = scanner.nextInt();
        }
        return current;
    }
}
