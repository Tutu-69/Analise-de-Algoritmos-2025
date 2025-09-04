package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class SistemaTest {

    @Test
    void testModoSono() {
        LampadaInterface lampada = mock(LampadaInterface.class);
        PersianaInterface persiana = mock(PersianaInterface.class);
        ArCondicionadoInterface arCondicionado = mock(ArCondicionadoInterface.class);

        Sistema sistema = new Sistema(lampada, persiana, arCondicionado);
        sistema.modoSono();

        verify(lampada).desligar();
        verify(arCondicionado).desligar();
        verify(persiana).fechar();
    }

    @Test
    void testModoTrabalho() {
        LampadaInterface lampada = mock(LampadaInterface.class);
        PersianaInterface persiana = mock(PersianaInterface.class);
        ArCondicionadoInterface arCondicionado = mock(ArCondicionadoInterface.class);

        Sistema sistema = new Sistema(lampada, persiana, arCondicionado);
        sistema.modoTrabalho();

        verify(lampada).ligar();
        verify(arCondicionado).ligar();
        verify(arCondicionado).definirTemperatura(25);
        verify(persiana).abrir();
    }
}