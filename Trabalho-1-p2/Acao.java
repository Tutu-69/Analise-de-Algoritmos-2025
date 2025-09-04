import java.util.ArrayList;
import java.util.List;

public class Acao implements Subject {
    private String nome;
    private double valor;
    private List<Ordem> ordens = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Acao(String nome, double valor) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da ação não pode ser vazio.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da ação deve ser positivo.");
        }
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
        if (ordem == null) {
            throw new OrdemInvalidaException("Ordem não pode ser nula.");
        }
        if (ordem.getValor() <= 0) {
            throw new OrdemInvalidaException("Valor da ordem deve ser positivo.");
        }
        ordens.add(ordem);
        processarOrdens();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) throw new IllegalArgumentException("Observer não pode ser nulo.");
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer == null) throw new IllegalArgumentException("Observer não pode ser nulo.");
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
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
                    notifyObservers();
                    compras.remove(compra);
                    vendas.remove(venda);
                    break;
                }
            }
        }
    }
}
