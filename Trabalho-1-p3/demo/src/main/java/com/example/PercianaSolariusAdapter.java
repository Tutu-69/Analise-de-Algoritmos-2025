package com.example;

import br.furb.analise.algoritmos.PersianaSolarius;

public class PercianaSolariusAdapter implements PersianaInterface {
    private PersianaSolarius persiana;

    public PercianaSolariusAdapter(PersianaSolarius persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        persiana.subirPersiana();
    }

    @Override
    public void fechar() {
        persiana.descerPersiana();
    }
    
}
