package com.example;

public class Sistema {
    private LampadaInterface lampada;
    private PersianaInterface persiana;
    private ArCondicionadoInterface arCondicionado;

    public Sistema(LampadaInterface lampada, PersianaInterface persiana, ArCondicionadoInterface arCondicionado) {
        this.lampada = lampada;
        this.persiana = persiana;
        this.arCondicionado = arCondicionado;
    }

    // Modo Sono: desliga ar-condicionado e luzes, fecha persiana
    public void modoSono() {
        lampada.desligar();
        arCondicionado.desligar();
        persiana.fechar();
    }

    // Modo Trabalho: liga luzes e ar-condicionado, ajusta temperatura para 25, abre persiana
    public void modoTrabalho() {
        lampada.ligar();
        arCondicionado.ligar();
        arCondicionado.definirTemperatura(25);
        persiana.abrir();
    }
}
