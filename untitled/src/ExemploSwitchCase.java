import java.util.Scanner;

public class ExemploSwitchCase {

    public static void main (String[]args){

        var scanner = new Scanner(System.in);
        System.out.println("Informe um número de 1 até 7");
        var option =scanner.nextInt();

        switch (option){
            case 1:
                System.out.println("Sabado");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sábado");
            default:
                System.out.println("Opção inválida");
        }
    }
}
