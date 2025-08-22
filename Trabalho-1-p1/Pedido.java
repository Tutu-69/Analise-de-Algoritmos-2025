import java.util.ArrayList;

public class Pedido {

    private final ArrayList<Produto> listaDeProdutos;
    private final PedidoInterface tipoDeEntrega;

    public Pedido(PedidoInterface tipoDeEntrega) {
        this.listaDeProdutos = new ArrayList<>();
        this.tipoDeEntrega = tipoDeEntrega;

    }

    public void adicionarProduto(Produto produto) {
        this.listaDeProdutos.add(produto);
    }

    public double calculaPesoPedido() throws Exception {
        double pesoTotal = 0;
        for (Produto produto : listaDeProdutos) {
            pesoTotal += produto.getPeso();
        }
        return tipoDeEntrega.calculaPesoPedido(pesoTotal);
    }
}
