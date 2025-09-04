package com.example;

import br.furb.analise.algoritmos.PersianaNatLight;

public class PercianaNatLightAdapter implements PersianaInterface {
    private PersianaNatLight persiana;

    public PercianaNatLightAdapter(PersianaNatLight persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        persiana.abrirPalheta();
    }

    @Override
    public void fechar() {
        persiana.descerPalheta();
    }    
}