package com.example;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class ArCondicionadoVentoBaumnAdapter implements ArCondicionadoInterface {
    private ArCondicionadoVentoBaumn arCondicionado;

    public ArCondicionadoVentoBaumnAdapter(ArCondicionadoVentoBaumn arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {
        arCondicionado.ligar();
    }

    @Override
    public void desligar() {
        arCondicionado.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        
    }

    @Override
    public void diminuirTemperatura() {
    }

    @Override
    public void definirTemperatura(int temperatura) {
        arCondicionado.definirTemperatura(temperatura);
    }
    
}
