package com.caio.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dev {

    private String nome;
    private List<Conteudo> conteudosIncristos = new ArrayList<>();
    private List<Conteudo> conteudosConcluidos = new ArrayList<>();;

    public void inscrever(Conteudo conteudo) {
        if (conteudosIncristos.contains(conteudo)) {
            System.err.println("Voce já se inscreveu nesse conteudo");
        } else {
            conteudosIncristos.add(conteudo);
        }
    }

    public void inscrever(Bootcamp bootcamp) {
        // Alternativa 1: foreach tradicional.
        for (Conteudo conteudo : bootcamp.getConteudos()) {
            inscrever(conteudo);
        }

        bootcamp.getDevs().add(this);

        // Alternativa 2: API de Stream.
        //bootcamp.getConteudos().stream().forEach(this::inscrever);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = conteudosIncristos.stream().findFirst();
        if (conteudo.isPresent()) {
            conteudosConcluidos.add(conteudo.get());
            conteudosIncristos.remove(conteudo.get());
        } else {
            System.err.println("Voce nao está mais inscrito em nenhum conteúdo");
        }
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream()
                .mapToDouble(conteudo -> conteudo.calcularXp())
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
