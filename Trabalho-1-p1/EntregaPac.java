public class EntregaPac implements PedidoInterface {

    @Override
    public double calculaPesoPedido(double peso) throws Exception {
        if (peso <= 1)
            return 10.0;
        if (peso <= 2)
            return 15.0;
        throw new IllegalArgumentException("não aceita este tipo de entrega");
    }

}
