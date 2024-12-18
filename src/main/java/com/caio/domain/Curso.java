package com.caio.domain;

public class Curso extends Conteudo {

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    private int cargaHoraria;

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

}
