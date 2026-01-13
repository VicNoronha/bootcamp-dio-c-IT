package ExerciciosCollections;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe a operação que deseja realizar (1 = sum, 2 = subtraction");

        var operationOption = scanner.nextInt();
        while (operationOption > 2 || operationOption <1){
            System.out.println("Escolha uma opção válida");
            operationOption = scanner.nextInt();
        }

        var selectedOperation = Operation.values()[operationOption - 1];// retorna um array com todos os valores válidos
        System.out.println("Informe os números separados por vírgula ( ex: 1,2,3)");
        var numbers = scanner.next();

        var numberArray = Arrays.stream(numbers.split(","))//Transforma em string e divide por virgula
                .mapToLong(Long::parseLong) //Converte cada string em um long
                .toArray();
        var result = selectedOperation.getOperationCallback().exec(numberArray);

        System.out.println(result);
    }
}
