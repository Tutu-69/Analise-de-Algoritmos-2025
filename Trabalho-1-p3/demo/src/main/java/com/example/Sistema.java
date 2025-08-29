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

}
