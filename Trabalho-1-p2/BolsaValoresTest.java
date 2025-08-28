import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BolsaValoresTest {

    private Acao acao;
    private Investidor investidor1;
    private Investidor investidor2;

    @BeforeEach
    void setup() {
        acao = new Acao("PETR4", 25.0);
        investidor1 = new Investidor("João");
        investidor2 = new Investidor("Maria");
    }

    @Test
    void testRegistrarOrdemCompraVenda() {
        acao.registrarOrdem(new OrdemDeCompra(investidor1, 30.0));
        acao.registrarOrdem(new OrdemDeVenda(investidor2, 25.0));

        assertEquals(25.0, acao.getValor());
    }

    @Test
    void testNotificacaoInvestidor() {
        acao.registerObserver(investidor1);

        acao.registrarOrdem(new OrdemDeCompra(investidor1, 30.0));
        acao.registrarOrdem(new OrdemDeVenda(investidor2, 25.0));

        assertEquals(25.0, acao.getValor());
    }

    @Test
    void testInscricaoECancelamento() {
        acao.registerObserver(investidor1);
        acao.removeObserver(investidor1);

        assertDoesNotThrow(() -> acao.registrarOrdem(new OrdemDeCompra(investidor1, 30.0)));
    }

    @Test
    void testOrdemInvalidaExceptionCompra() {
        assertThrows(OrdemInvalidaException.class,
                () -> new OrdemDeCompra(null, 10.0));

        assertThrows(OrdemInvalidaException.class,
                () -> new OrdemDeCompra(investidor1, -5.0));
    }

    @Test
    void testOrdemInvalidaExceptionVenda() {
        assertThrows(OrdemInvalidaException.class,
                () -> new OrdemDeVenda(null, 10.0));

        assertThrows(OrdemInvalidaException.class,
                () -> new OrdemDeVenda(investidor1, -5.0));
    }

    @Test
    void testAcaoComValoresInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Acao(null, 10.0));
        assertThrows(IllegalArgumentException.class, () -> new Acao("", 10.0));
        assertThrows(IllegalArgumentException.class, () -> new Acao("ABC", 0));
    }

}
