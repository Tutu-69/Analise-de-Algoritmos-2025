import java.util.ArrayList;
import java.util.List;

public class Acao {
    private String nome;
    private double valor;
    private List<Ordem> ordens = new ArrayList<>();
    private List<Investidor> observadores = new ArrayList<>();

    public Acao(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void registrarOrdem(Ordem ordem) {
        ordens.add(ordem);
        processarOrdens();
    }

    public void inscrever(Investidor investidor) {
        if (!observadores.contains(investidor)) {
            observadores.add(investidor);
        }
    }

    public void cancelarInscricao(Investidor investidor) {
        observadores.remove(investidor);
    }

    private void notificarObservadores() {
        for (Investidor investidor : observadores) {
            investidor.notificar(this);
        }
    }

    private List<Ordem> filtrarOrdensPorTipo(boolean compra) {
        List<Ordem> filtradas = new ArrayList<>();
        for (Ordem ordem : ordens) {
            if (ordem.isCompra() == compra) {
                filtradas.add(ordem);
            }
        }
        return filtradas;
    }

    private void processarOrdens() {
        List<Ordem> compras = filtrarOrdensPorTipo(true);
        List<Ordem> vendas = filtrarOrdensPorTipo(false);

        for (Ordem compra : new ArrayList<>(compras)) {
            for (Ordem venda : new ArrayList<>(vendas)) {
                if (compra.getValor() >= venda.getValor()) {
                    this.valor = venda.getValor();
                    ordens.remove(compra);
                    ordens.remove(venda);
                    notificarObservadores();
                    compras.remove(compra);
                    vendas.remove(venda);
                    break;
                }
            }
        }
    }
}
