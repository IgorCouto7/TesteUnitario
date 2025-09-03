public class Mago extends Campeao {
    public Mago(String nome, String rota) {
        super(nome, rota);
    }

    // Novo construtor com nível
    public Mago(String nome, String rota, int nivel) {
        super(nome, rota, nivel);
    }

    @Override
    public void atacar() {
        System.out.println(nome + " lançou uma bola de fogo!");
    }
}
