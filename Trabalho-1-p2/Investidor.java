public class Investidor {
    private String nome;

    public Investidor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void registrarOrdem(Acao acao, Ordem ordem) {
        acao.registrarOrdem(ordem);
    }

    public void inscreverAcao(Acao acao) {
        acao.inscrever(this);
    }

    public void cancelarInscricaoAcao(Acao acao) {
        acao.cancelarInscricao(this);
    }

    public void notificar(Acao acao) {
        System.out.println("Investidor " + nome + " recebeu notificação: valor de "
                + acao.getNome() + " é " + acao.getValor());
    }
}
