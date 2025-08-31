package com.example;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class ArCondicionadoGellaKazaAdapter implements ArCondicionadoInterface {
    private ArCondicionadoGellaKaza arCondicionado;

    public ArCondicionadoGellaKazaAdapter(ArCondicionadoGellaKaza arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {
        arCondicionado.ativar();
    }

    @Override
    public void desligar() {
        arCondicionado.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionado.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionado.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        int atual = arCondicionado.getTemperatura();
        while (atual < temperatura) {
            arCondicionado.aumentarTemperatura();
            atual = arCondicionado.getTemperatura();
        }
        while (atual > temperatura) {
            arCondicionado.diminuirTemperatura();
            atual = arCondicionado.getTemperatura();
        }
    }

    
}
