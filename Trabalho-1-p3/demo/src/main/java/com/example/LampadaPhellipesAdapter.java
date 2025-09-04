package com.example;

import br.furb.analise.algoritmos.LampadaPhellipes;

public class LampadaPhellipesAdapter implements LampadaInterface {
    private LampadaPhellipes lampadaPhelippes;

    @Override
    public void ligar() {
        lampadaPhelippes.setIntensidade(100);
    }

    @Override
    public void desligar() {
        lampadaPhelippes.setIntensidade(0);
    }
}
