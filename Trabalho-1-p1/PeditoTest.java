import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class PeditoTest {

    @Test
    public void testEntregaPacPesoAte1() throws Exception {
        Pedido pedido = new Pedido(new EntregaPac());
        pedido.adicionarProduto(new Produto("Livro", 50.0, 0.8));
        assertEquals(10.0, pedido.calculaPesoPedido());
    }

    @Test
    public void testEntregaPacPesoAte2() throws Exception {
        Pedido pedido = new Pedido(new EntregaPac());
        pedido.adicionarProduto(new Produto("Livro", 50.0, 1.5));
        assertEquals(15.0, pedido.calculaPesoPedido());
    }

    @Test
    public void testEntregaPacPesoMaiorQue2() {
        Pedido pedido = new Pedido(new EntregaPac());
        pedido.adicionarProduto(new Produto("Livro", 50.0, 2.5));
        Exception exception = assertThrows(IllegalArgumentException.class, pedido::calculaPesoPedido);
        assertEquals("não aceita este tipo de entrega", exception.getMessage());
    }

    @Test
    public void testEntregaSedexPesoAte05() throws Exception {
        Pedido pedido = new Pedido(new EntregaSedex());
        pedido.adicionarProduto(new Produto("Pen drive", 30.0, 0.4));
        assertEquals(12.5, pedido.calculaPesoPedido());
    }

    @Test
    public void testEntregaSedexPesoAte1() throws Exception {
        Pedido pedido = new Pedido(new EntregaSedex());
        pedido.adicionarProduto(new Produto("Livro", 50.0, 0.9));
        assertEquals(20.0, pedido.calculaPesoPedido());
    }

    @Test
    public void testEntregaSedexPesoMaiorQue1() throws Exception {
        Pedido pedido = new Pedido(new EntregaSedex());
        pedido.adicionarProduto(new Produto("Livro", 50.0, 1.3));
        assertEquals(51.0, pedido.calculaPesoPedido());
    }

    @Test
    public void testRetiradaSempreZero() throws Exception {
        Pedido pedido = new Pedido(new Retirada());
        pedido.adicionarProduto(new Produto("Livro", 50.0, 10.0));
        assertEquals(0.0, pedido.calculaPesoPedido());
    }

    @Test
    public void testPedidoSemProdutos() throws Exception {
        Pedido pedido = new Pedido(new EntregaPac());
        assertEquals(10.0, pedido.calculaPesoPedido());
    }
}