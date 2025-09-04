public class Main {
    public static void main(String[] args) {
        Acao bb = new Acao("Banco do Brasil", 24.0);

        Investidor joaquim = new Investidor("Joaquim");
        Investidor mariana = new Investidor("Mariana");

        bb.registerObserver(joaquim); // joaquim quer notificações
        // mariana não se inscreve então não será notificada

        Ordem compra = new OrdemDeCompra(joaquim, 24.0);
        Ordem venda = new OrdemDeVenda(mariana, 24.0);

        bb.registrarOrdem(compra);
        bb.registrarOrdem(venda);
    }
}
