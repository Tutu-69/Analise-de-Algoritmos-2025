public class OrdemDeVenda implements Ordem {
    private Investidor investidor;
    private double valor;

    public OrdemDeVenda(Investidor investidor, double valor) {
        if (investidor == null) {
            throw new OrdemInvalidaException("Investidor não pode ser nulo.");
        }
        if (valor <= 0) {
            throw new OrdemInvalidaException("Valor da ordem de venda deve ser positivo.");
        }
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
        return false;
    }
}