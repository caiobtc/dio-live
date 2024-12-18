package com.caio.domain;
import java.time.LocalDateTime;

public class Mentoria extends Conteudo {

    @Override
    public double calcularXp() {
        return XP_PADRAO;
    }

    private LocalDateTime data;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
