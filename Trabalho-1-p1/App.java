public class App {
    public static void main(String[] args) throws Exception {
        Produto livro = new Produto("Livro de Java", 59.90, 1.2);
        Produto revista = new Produto("Revista de Tecnologia", 19.90, 0.5);
        Produto caderno = new Produto("Caderno", 29.90, 0.8);

        Pedido pedidoSedex = new Pedido(new EntregaSedex());
        pedidoSedex.adicionarProduto(livro);
        pedidoSedex.adicionarProduto(revista);
        pedidoSedex.adicionarProduto(caderno);
        System.out.println("Frete Sedex: " + pedidoSedex.calculaPesoPedido());

    }
}