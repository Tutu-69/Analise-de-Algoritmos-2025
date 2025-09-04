public class Investidor implements Observer {
    private String nome;

    public Investidor(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Acao acao) {
        System.out.println("Investidor " + nome + " notificado: Nova cotação da ação " + acao.getNome() + " = " + acao.getValor());
    }
}
