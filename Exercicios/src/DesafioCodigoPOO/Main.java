package DesafioCodigoPOO;

import DesafioCodigoPOO.br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main (String[] args){

        Curso curso1 = new Curso (); // A classe é a planta da casa e o obj é a casa
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição Curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo(" Curso Java");
        curso2.setDescricao(" Descrição Curso Java");
        curso2.setCargaHoraria(4);

        Conteudo conteudo = new Curso(); // Exemplo de Polimorfismo

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(" Mentoria de Java");
        mentoria.setDescricao(" Descrição da Mentoria Java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição bootcamp java developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootCamp(bootcamp);
        System.out.println("Conteúdos Inscritos " + devCamila.getConteudosInscritos());

        devCamila.progredir();
        devCamila.progredir();

        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila " + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila " + devCamila.getConteudosConcluidos());
        System.out.println("XP " + devCamila.calcularTotalXp());

        System.out.println("------------------------");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootCamp(bootcamp);
        System.out.println("Conteúdos Inscritos " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos " + devJoao.getConteudosConcluidos());
        System.out.println("XP " + devJoao.calcularTotalXp());




    }
}
