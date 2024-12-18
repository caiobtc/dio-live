package com.caio;

import com.caio.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Curso cursoJavaBasico = new Curso();
        cursoJavaBasico.setTitulo("Java Basico");
        cursoJavaBasico.setDescricao("Aprenda os conceitos básicos sobre Java");
        cursoJavaBasico.setCargaHoraria(8);

        Curso cursoDotNet = new Curso();
        cursoDotNet.setTitulo("Java .NET");
        cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre C#");
        cursoDotNet.setCargaHoraria(8);


        Curso cursoJavaAvancado = new Curso();
        cursoJavaAvancado.setTitulo("Java Avançado");
        cursoJavaAvancado.setDescricao("Aprenda os conceitos avançados sobre Java");
        cursoJavaAvancado.setCargaHoraria(8);


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aprenda Orientaçao a Objetos com Java");
        mentoria.setDescricao("Imersao sobre os pilares da orientaçao a objetos");
        mentoria.setData(LocalDateTime.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Live DIO Java");
        bootcamp.setInicio(LocalDate.now());
        bootcamp.setFim(bootcamp.getInicio().plusDays(45));
        List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
        bootcamp.setConteudos(conteudosBootcamp);

        Dev felipao = new Dev();
        felipao.setNome("Felipao");

        Dev caio = new Dev();
        caio.setNome("Caio");

        felipao.inscrever(cursoDotNet);
        felipao.inscrever(bootcamp);
        felipao.progredir();
        felipao.progredir();

        caio.inscrever(bootcamp);
        caio.progredir();
        caio.progredir();
        caio.progredir();

        System.out.println(String.format("XP Felipao: %,2f", felipao.calcularTotalXp()));
        System.out.println(String.format("XP Caio: %,2f", caio.calcularTotalXp()));

        List<Dev> ranking = Arrays.asList(felipao, caio).stream()
                                  .sorted((dev1, dev2) -> Double.compare(dev1.calcularTotalXp(), dev2.calcularTotalXp()))
                                  .collect(Collectors.toList());
        for (Dev dev : ranking) {
            System.out.println(dev.getNome());
        }

    }
}
