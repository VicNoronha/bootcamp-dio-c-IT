package DesafioDeCodigo.com.techconsult.Main;

import DesafioDeCodigo.com.techconsult.model.Analyst;
import DesafioDeCodigo.com.techconsult.model.Consultant;
import DesafioDeCodigo.com.techconsult.model.Developer;
import DesafioDeCodigo.com.techconsult.model.Manager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine().trim();

        List<Consultant> consultantList = new ArrayList<>();

        String[] entries = inputLine.split(";");

        for (String entry : entries) {
            entry = entry.trim();
            if (entry.isEmpty()) continue;

            String[] parts = entry.split(" ", 2);
            String jobTitle = parts[0];
            String personName = parts[1];

            if (jobTitle.equals("Developer")) {
                consultantList.add(new Developer(personName));

            } else if (jobTitle.equals("Analyst")) {
                consultantList.add(new Analyst(personName));

            } else if (jobTitle.equals("Manager")) {
                consultantList.add(new Manager(personName));
            }
        }

        for (Consultant consultant : consultantList) {
            System.out.println(consultant.present());
        }
    }
}
