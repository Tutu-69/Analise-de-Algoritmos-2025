public interface Ordem {
    Investidor getInvestidor();

    double getValor();

    boolean isCompra();
}
