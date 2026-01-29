package JogoSudoku;

import JogoSudoku.model.Board;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    public static void main (String [] args){
        final var positions:Map<String,String> = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v->v.split(";")[1]
                ));

        var option  = -1;
        while(true){
            System.out.println("Selecione uma das opções a seguir ");
            System.out.println("1 - Iniciar um novo jogo ");
            System.out.println("2 - Colocar um novo número ");
            System.out.println("3 - Remover um número ");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo ");
            System.out.println("7 - Finalizar jogo ");
            System.out.println("8 - Sair ");


            option = scanner.nextInt();







        }


    }
}
