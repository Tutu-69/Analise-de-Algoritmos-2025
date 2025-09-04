package com.example;

import br.furb.analise.algoritmos.LampadaShoyuMi;

public class LampadaShoyouMiAdapter implements LampadaInterface {
    private LampadaShoyuMi lampada;

    public LampadaShoyouMiAdapter(LampadaShoyuMi lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        lampada.ligar();
    }

    @Override
    public void desligar() {
        lampada.desligar();
    }

}
