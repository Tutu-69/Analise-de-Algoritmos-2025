public class EntregaSedex implements PedidoInterface {

    @Override
    public double calculaPesoPedido(double peso) throws Exception {
        if (peso <= 0.5)
            return 12.5;
        if (peso <= 1)
            return 20.0;
        double valorFrete = 46.5;
        double excessoKg = peso - 1.0;
        int blocos100g = (int) Math.floor(excessoKg * 10);
        valorFrete += blocos100g * 1.5;
        return valorFrete;
    }

}
