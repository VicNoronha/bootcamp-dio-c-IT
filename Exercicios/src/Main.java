import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        var scanner = new Scanner(System.in);
        System.out.printf("Informe seu nome: ");
        var name = scanner.next();
        System.out.println("Informe sua idade");
        var age = scanner.nextInt();

        if (age >=18) {
            System.out.println("%s, tem %s anos, e pode dirigir \n");
        }else {
            System.out.println("%s, você não pode dirigir \n");
        }

       }

    }

