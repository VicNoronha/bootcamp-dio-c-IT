package br.com.dio.dao.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final UserDAO dao = new UserDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Cadastro de Usuários ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por ID");
            System.out.println("5 - Listar todos");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            int userInput = scanner.nextInt();

            // Proteção contra opções inválidas
            if (userInput < 1 || userInput > MenuOption.values().length) {
                System.out.println("Opção inválida!");
                continue;
            }

            MenuOption selectedOption = MenuOption.values()[userInput - 1];

            switch (selectedOption) {

                case SAVE -> {
                    UserModel user = dao.save(requestToSave());
                    System.out.println("Usuário salvo com sucesso:");
                    System.out.println(user);
                }

                case UPDATE -> {
                    UserModel user = dao.update(requestToUpdate());
                    System.out.println("Usuário atualizado com sucesso:");
                    System.out.println(user);
                }

                case DELETE -> {
                    long id = requestId();
                    dao.delete(id);
                    System.out.println("Usuário excluído com sucesso!");
                }

                case FIND_BY_ID -> {
                    long id = requestId();
                    UserModel user = dao.findById(id);
                    System.out.println("Usuário encontrado:");
                    System.out.println(user);
                }

                case FIND_ALL -> {
                    System.out.println("\nUsuários cadastrados:");
                    System.out.println("----------------------");
                    dao.findAll().forEach(System.out::println);
                    System.out.println("----------------------");
                }

                case EXIT -> {
                    System.out.println("Encerrando o sistema...");
                    System.exit(0);
                }
            }
        }
    }

    private static long requestId() {
        System.out.print("Informe o ID do usuário: ");
        return scanner.nextLong();
    }

    private static UserModel requestToSave() {
        System.out.print("Informe o nome do usuário: ");
        String name = scanner.next();

        System.out.print("Informe o email do usuário: ");
        String email = scanner.next();

        System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
        String birthdayString = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthdayString, formatter);
        OffsetDateTime birthday = localDate.atStartOfDay().atOffset(ZoneOffset.UTC);

        return new UserModel(0, name, email, birthday);
    }

    private static UserModel requestToUpdate() {
        System.out.print("Informe o ID do usuário: ");
        long id = scanner.nextLong();

        System.out.print("Informe o novo email do usuário: ");
        String email = scanner.next();

        System.out.print("Informe a nova data de nascimento (dd/MM/yyyy): ");
        String birthdayString = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthdayString, formatter);
        OffsetDateTime birthday = localDate.atStartOfDay().atOffset(ZoneOffset.UTC);

        return new UserModel(id, null, email, birthday);
    }
}
