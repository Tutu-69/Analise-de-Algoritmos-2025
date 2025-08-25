public class OrdemDeCompra implements Ordem {
    private Investidor investidor;
    private double valor;

    public OrdemDeCompra(Investidor investidor, double valor) {
        this.investidor = investidor;
        this.valor = valor;

    }

    @Override
    public Investidor getInvestidor() {
        return investidor;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public boolean isCompra() {
        return true;
    }
}